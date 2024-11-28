#!/bin/bash

# Script to monitor network performance

set -e  # Exit immediately if a command exits with a non-zero status

echo "Starting network monitoring..."

# Define variables
LOG_FILE="/var/log/strathosnet/network_monitor.log"

# Function to log network statistics
log_network_stats() {
    echo "Logging network statistics..."
    echo "$(date +'%Y-%m-%d %H:%M:%S') - $(ifstat -S 1 1)" >> "$LOG_FILE"
}

# Monitor network every minute
while true; do
    log_network_stats
    sleep 60
done
