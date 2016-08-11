#!/bin/bash

echo "delete all war files in jenkins_home"
find . -name "*.war" -exec rm -rf {} \;

echo "stop and remove all docker containers"
sudo docker stop $(sudo docker ps -a -q)
sudo docker rm --force `sudo docker ps -qa`

