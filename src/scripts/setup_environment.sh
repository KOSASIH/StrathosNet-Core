#!/bin/bash

# Script to set up the environment for StrathosNet

set -e  # Exit immediately if a command exits with a non-zero status

echo "Setting up environment for StrathosNet..."

# Update package list and install dependencies
echo "Updating package list..."
apt-get update

echo "Installing required packages..."
apt-get install -y openjdk-11-jdk maven git

# Set up environment variables
echo "Setting up environment variables..."
export STRATHOSNET_HOME="/path/to/StrathosNet"
export JAVA_HOME="/usr/lib/jvm/java-11-openjdk-amd64"

# Add to .bashrc for persistence
echo "export STRATHOSNET_HOME=$STRATHOSNET_HOME" >> ~/.bashrc
echo "export JAVA_HOME=$JAVA_HOME" >> ~/.bashrc
source ~/.bashrc

echo "Environment setup completed successfully!"
