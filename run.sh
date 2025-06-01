#!/bin/bash

# Get the JAR file name from output directory
JAR_FILE=$(ls output/*.jar | grep -v 'original')

# Run the application
java -jar "$JAR_FILE" \
     --spring.config.location=output/config/application.yml \
     --logging.config=output/config/log4j2.xml 