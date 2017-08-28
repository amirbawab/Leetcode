#!/bin/bash

# Config variables
CLASS_DIR="${PWD}/build"

# Create destination directory
echo "Deleting old build directory"
rm -rf ${CLASS_DIR}
echo "Creating a build directory"
mkdir -p ${CLASS_DIR}

# Compile all java files
for java_file in $(ls *.java)
do
    echo ">> Compiling file: ${java_file}"
    javac -d ${CLASS_DIR} ${java_file}
done
