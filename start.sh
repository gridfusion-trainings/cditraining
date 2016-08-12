#!/bin/bash

echo "delete all war files in jenkins_home"
cd /home/e34
find . -name "*.war" -exec rm -rf {} \;

echo "stop and remove all docker containers"
sudo docker stop $(sudo docker ps -a -q)
sudo docker rm --force `sudo docker ps -qa`


echo "starting jenkins"
sudo docker run -d -p 8080:8080 -p 50000:50000 -v /home/e34/jenkins_home:/var/jenkins_home palotas/jenkins-cdi:0.1 

echo "starting tomcat QA"
sudo docker run -d -p 9999:8080 --expose=8080 palotas/tomcat7-cdi 

echo "starting tomcat PRODUCTION"
sudo docker run -d -p 9998:8080 --expose=8080 palotas/tomcat7-cdi

echo "starting sonarqube"
sudo docker run -d --name sonarqube -p 9000:9000 -p 9092:9092 sonarqube

echo "setting git timeout to 5 minutes"
cd /home/e34/Workspace/cditraining
git config credential.helper 'cache --timeout=300'
