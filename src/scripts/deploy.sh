#!/bin/bash

# Script to deploy the StrathosNet application

set -e  # Exit immediately if a command exits with a non-zero status

echo "Starting deployment of StrathosNet..."

# Define variables
APP_DIR="/path/to/StrathosNet"
DEPLOY_DIR="/var/www/strathosnet"
BACKUP_DIR="/var/backups/strathosnet"

# Create backup of existing deployment
if [ -d "$DEPLOY_DIR" ]; then
    echo "Backing up existing deployment..."
    tar -czf "$BACKUP_DIR/strathosnet_backup_$(date +%F).tar.gz" -C "$DEPLOY_DIR" .
fi

# Copy new files to deployment directory
echo "Copying files to deployment directory..."
cp -r "$APP_DIR/"* "$DEPLOY_DIR/"

# Set permissions
echo "Setting permissions..."
chown -R www-data:www-data "$DEPLOY_DIR"
chmod -R 755 "$DEPLOY_DIR"

echo "Deployment completed successfully!"
