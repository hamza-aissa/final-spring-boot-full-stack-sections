#!/bin/bash

# MariaDB Startup Script for Spring Boot Project
# This script ensures MariaDB is running before starting your application

set -e # Exit on any error

echo "================================"
echo "MariaDB Startup Script"
echo "================================"
echo ""

# Colors for output
GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Check if MariaDB service exists
if ! systemctl list-unit-files | grep -q mariadb.service; then
  echo -e "${RED}ERROR: MariaDB service not found!${NC}"
  echo "Please install MariaDB first: sudo pacman -S mariadb"
  exit 1
fi

# Check current status
echo "Checking MariaDB status..."
if systemctl is-active --quiet mariadb; then
  echo -e "${GREEN}✓ MariaDB is already running${NC}"
else
  echo -e "${YELLOW}MariaDB is not running. Starting it now...${NC}"

  # Start MariaDB service
  sudo systemctl start mariadb

  # Wait a moment for service to fully start
  sleep 2

  # Verify it started
  if systemctl is-active --quiet mariadb; then
    echo -e "${GREEN}✓ MariaDB started successfully${NC}"
  else
    echo -e "${RED}ERROR: Failed to start MariaDB${NC}"
    echo "Check status with: sudo systemctl status mariadb"
    exit 1
  fi
fi

# Enable MariaDB to start on boot (if not already enabled)
if ! systemctl is-enabled --quiet mariadb; then
  echo -e "${YELLOW}Enabling MariaDB to start on boot...${NC}"
  sudo systemctl enable mariadb
  echo -e "${GREEN}✓ MariaDB enabled on boot${NC}"
else
  echo -e "${GREEN}✓ MariaDB is already enabled on boot${NC}"
fi

echo ""
echo "================================"
echo "Testing Database Connection..."
echo "================================"

# Test if we can connect to MariaDB
if mariadb -u root -e "SELECT 1;" &>/dev/null; then
  echo -e "${GREEN}✓ Database connection successful${NC}"

  # Check if spring_DB exists
  if mariadb -u root -e "USE spring_DB;" &>/dev/null; then
    echo -e "${GREEN}✓ Database 'spring_DB' exists${NC}"
  else
    echo -e "${YELLOW}! Database 'spring_DB' will be created by Spring Boot${NC}"
  fi
else
  echo -e "${RED}ERROR: Cannot connect to MariaDB${NC}"
  echo "Please check your MariaDB configuration"
  exit 1
fi

echo ""
echo "================================"
echo -e "${GREEN}MariaDB is ready!${NC}"
echo "================================"
echo ""
echo "Database Info:"
echo "  - Host: localhost"
echo "  - Port: 3306"
echo "  - Database: spring_DB"
echo "  - User: root"
echo "  - Password: (empty)"
echo ""
echo "You can now start your Spring Boot application with:"
echo "  mvn spring-boot:run"
echo ""
