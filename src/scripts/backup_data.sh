#!/bin/bash

# Script to back up StrathosNet data

set -e  # Exit immediately if a command exits with a non-zero status

echo "Starting data backup..."

# Define variables
DATA_DIR="/path/to/StrathosNet/data"
BACKUP_DIR="/var/backups/strathosnet/data_backup_$(date +%F).tar.gz"

# Create backup
echo "Creating backup of data directory..."
tar -czf "$BACKUP_DIR" -C "$DATA_DIR" .

# Verify backup
if [ -f "$BACKUP_DIR" ]; then
    echo "Backup created successfully at $BACKUP_DIR"
else
    echo "Backup failed!"
    exit 1
fi
