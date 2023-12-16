# Makefile for a Gradle-based Kotlin project

# Define Gradle wrapper command
GRADLEW=./gradlew

# Default make target
all: build

# Compile the project
build:
	$(GRADLEW) build

# Run the project
run:
	$(GRADLEW) run

# Run tests
test:
	$(GRADLEW) test

# Clean the project
clean:
	$(GRADLEW) clean

.PHONY: all build run test clean
