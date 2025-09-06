#!/bin/bash
# Build script for Render deployment

echo "Starting build process..."

# Build with Maven
mvn clean package -DskipTests

echo "Build completed successfully!"
