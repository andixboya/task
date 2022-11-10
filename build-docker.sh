#!/bin/bash

export IMAGE=task:0.0.1-SNAPSHOT

.\\gradlew clean build
docker build -f Dockerfile -t $IMAGE .
