#!/bin/bash

echo "delete all war files in jenkins_home"
cd /home/e34
sudo find . -name "*.war" -exec rm -rf {} \;

echo "stop and remove all docker containers"
sudo docker stop $(sudo docker ps -a -q)
sudo docker rm --force `sudo docker ps -qa`


#echo "starting jenkins"
sudo docker run -d --name jenkins -p 8080:8080 -p 50000:50000 -v /home/e34/jenkins_home/jobs:/var/jenkins_home/jobs palotas/e34_jenkins_noadmin:0.7

echo "starting tomcat QA"
sudo docker run -d --name tomcat-QA -p 9999:8080 --expose=8080 palotas/tomcat7-cdi

echo "starting tomcat PRODUCTION"
sudo docker run -d --name tomcat-PROD -p 9998:8080 --expose=8080 palotas/tomcat7-cdi

echo "starting sonarqube"
sudo docker run -d --name sonarqube -p 9000:9000 -p 9092:9092 sonarqube

echo "starting busybox"
sudo docker pull palotas/busybox
sudo docker run -d --name busybox palotas/busybox sh

echo "setting git timeout to 5 minutes"
cd /home/e34/workspace/cditraining
git config credential.helper 'cache --timeout=300'
