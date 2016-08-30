#!/bin/bash

echo "delete all war files in jenkins_home"
cd /home/e34
find . -name "*.war" -exec rm -rf {} \;

echo "remove all builds"
rm -rf /home/e34/jenkinshome/jobs/unittests/builds/*
rm -rf /home/e34/jenkinshome/jobs/deploy/builds/*
rm -rf /home/e34/jenkinshome/jobs/seleniumtests/builds/*
rm -rf /home/e34/jenkinshome/jobs/deployProd/builds/*
rm -rf /home/e34/jenkinshome/jobs/seleniumProd/builds/*

echo "stop and remove all docker containers"
sudo docker stop $(sudo docker ps -a -q)
sudo docker rm --force `sudo docker ps -qa`

