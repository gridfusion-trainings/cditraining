# CDI Training 
### General Agenda
1. What is agile? 8.30 - 09.00
2. What is DevOps? What is not DevOps? 09.00 - 
https://www.slideshare.net/Codemotion/the-devops-disaster-15-ways-to-fail-at-devops-bert-jan-schrijver-codemotion-amsterdam-2016?qid=44911502-1e01-41d1-92fb-9382b72f7f25&v=&b=&from_search=5
- Dev and operations engineers being responsible TOGETHER for the entire lifecycle of a product 
- Development and operations engineers
  working together on a shared goal : 
  
  building and running better-quality software
  more quickly and more reliably
  
  Questions: 
  1. DevOps is the same thing as
     Continuous Delivery and Continuous Deployment
  2. You need a central ‘DevOps team’
     that handles all ops stuff
  3. DevOps is only for
     development and operations engineers
  4. DevOps means
     developers managing production
  5. DevOps is only for
     hipsters, startups and unicorns
  6. You need containers, microservices
     and ‘the cloud’ to do DevOps
  7. DevOps is about
     automation
  8. DevOps is about
     tools
  9. DevOps is a job title -
     something you can be certified in
  10. DevOps replaces
      Agile
  11. You don’t need to define
      what DevOps means to your organisation
  12. You can do DevOps
      without management buy-in
  13. You can enforce DevOps
      in an organisation
  14. DevOps prevents
      failure
      
  What is DevOps about:
  - DevOps is about culture
  - DevOps is about freedom and responsibility
  - DevOps is about empathy


3. What is CI / Why CI? - 10.00 
- Reduzieren der Risiken
- Reduktion des manuellen repetitiven Prozess
- Generierung von deploybarer Software zu jeder Zeit
- Bessere Visibilität in das Projekt
- Erhöhte “Confidence” in das Produkt und das Team
- Häufigere Lieferung von “Business Value” 
- Bessere Qualität
- Frühere Bugs
- Bug Prevention anstatt late detection
- Fast & frequent feedback

4. Core Principles of CI 
- Häufige Commits
- Kein Commit von “broken Code”
- Rote Builds müssen sofort gefixt werden 
- Entwickler schreiben Tests
- Alle Tests und Inspektionen müssen grün sein

5. GIT
- mkdir myproject
- git init
- git status
- vi file.txt
- git add file.txt
- git status
- git commit -m "initial checkin"
- add new entry in file.txt
- git commit -am "added entry"
- git log
- git revert <commitID>
- change file.txt
- git diff
- git branch
- git branch dev
- git checkout dev
- vi file.txt
- git commit -am "added entry on the branch"
- git checkout master
- cat file.txt
- git merge dev
- cat file.txt
- git branch -d dev


6. Maven 
    - Create new maven project: ``mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false``
    - Import into IntelliJ
    - change JUnit version in pom.xml
    - maven targets: clean, compile, test, package
    - execute program: ``java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.app.App``
    - mvn install
7. Introduction into main app

8. Build the app
    - ``mvn package -DskipTests=true``
    - copy war file to docker container: ``sudo docker cp cdi-1.2-SNAPSHOT-null.war tomcat-QA:/usr/local/tomcat/webapps/bison.war``
    - go to: http://172.17.0.2:8080/bison

9. Introduction Test Automation

    9.1 Unit Tests
    - run in IntelliJ
    - run via maven: ``mvn clean test –Dgroup=unit``
10. Automated Code Quality
    - what do you think? 
    - Cobertura: ``mvn cobertura:cobertura -Dgroup=unit``
    - look at report: /home/e34/Workspace/cdiTraining/target/site/cobertura/index.html
    - SONAR: ``mvn clean test -Dgroup=unit sonar:sonar``
    
11. JENKINS
    - first build job: unit test 
    - deploy to QA 
    - manually test on tomcat-QA
    
12. SELENIUM 
13. TEST FRAMEWORKS / TestNG Introduction 
14. WEBDRIVER BASICS
15. REMOTE WEBDRIVER
16. SELENIUM GRID 
17. Complete the pipeline 
Set up AWS Docker instance
- go to AWS console -> AMIs
- launch Docker-Base AMI 
- pick security profile5 
- attach elastic IP 
- ssh into instance: ssh -i "dell-laptop.pem" ec2-user@ec2-18-195-78-49.eu-central-1.compute.amazonaws.com
- docker run -d --name aws-prod -p 9998:8080 palotas/tomcat7-cdi
- check that container is up: ec2-18-195-78-49.eu-central-1.compute.amazonaws.com:9998
- in Jenkins job add container to deployProd job: admin/admin,ec2-18-195-78-49.eu-central-1.compute.amazonaws.com:9998/


18. DOCKER Excercise 
    - docker pull ubuntu:17.04
    - docker run -ti --rm ubuntu:17.04
    - check if wget is there
    - build own ubuntu under palotas/ubuntu (FROM ubuntu:17.04)
    - docker build -t palotas/ubuntu
    - docker run -ti --rm palotas/ubuntu
    - edit Dockerfile and add wget
        - RUN apt-get update
        - RUN apt-get install -y wget
    - docker build -t palotas/ubuntu .
    - docker run -ti --rm palotas/ubuntu
    - check that wget is there
    - docker login / docker push
    - Users download palotas/ubuntu and play with it
    - in Docker Cloud create new repo
    - connect cditraining repo and create job for docker/ubuntu/Dockerfile
    - change Dockerfile (i.e. install vi) 
    - git push --> should build new docker image automatically
    - Users download palotas/ubuntu and play with it
    
    - cloud.docker.com -> set up automated builds 



## Changes for Bison Training
change start.sh: sudo docker run -d --net="host" --name jenkins -p 8080:8080 -p 50000:50000 -p 4444:4444 -v /home/e34/jenkins_home/jobs:/var/jenkins_home/jobs palotas/e34_jenkins_noadmin:0.7
tomcat-QA : 172.17.0.2
tomcat-PROD: 172.17.0.3
change jenkins job IP address to the above

        




### Copy file to docker container
sudo docker cp cdi-1.2-SNAPSHOT-null.war tomcat-QA:/usr/local/tomcat/webapps/cisco.war
### Attach to running docker container
sudo docker exec -i -t tomcat-QA /bin/bash




### Run tests with Maven
Unit tests: mvn test -Dgroup=unit</br>
Integration tests: mvn test -Dgroup=integration </br>
E2E tests: mvn test -Dgroup=end2end </br>

####Run in specific environments: 
mvn test -Dgroup=end2end -Denv=QA / PRODUCTION / VAGRANT

### Cobertura code coverage
mvn clean test cobertura:cobertura -Dgroup=unit,integration (--> this will run both groups of tests)

### SONAR
SONAR is running on http://localhost:9000 (via Docker container)
mvn clean test -Dgroup=unit sonar:sonar </br>

### Copy file to docker container
sudo docker cp cdi-1.2-SNAPSHOT-null.war tomcat-QA:/usr/local/tomcat/webapps/cisco.war

### Attach to running docker container
sudo docker exec -i -t tomcat-QA /bin/bash

## Set up AWS Docker instance
- go to AWS console -> AMIs
- launch Docker-Base AMI 
- make sure all traffic is open
- ssh into instance: ssh -i "gridfusion.pem" ec2-user@ec2-54-191-143-205.us-west-2.compute.amazonaws.com
- docker run -d --name aws-prod -p 9998:8080 palotas/tomcat7-cdi
- check that container is up: http://ec2-54-191-143-205.us-west-2.compute.amazonaws.com:9998
- in Jenkins job add container to deployProd job: admin/admin, http://ec2-54-218-104-110.us-west-2.compute.amazonaws.com:9998/












### Setting up the VM
- start VirtualBox and import the OVA/OVF file
- in the VM, start a terminal window
- `cd /Workspace/cditraining`
- `./start.sh`
- when prompted enter the sudo password "111111"
- --> docker container should be started now
- open Chrome browser
- go to http://localhost:8080
- --> you should see Jenkins (this may take a moment for Jenkins to initialize)
- go back to Terminal window
- make sure you are in /home/e34/Workspace/cditraining
- `mvn clean`
- `mvn test -Dgroup=unit`
- `git status`
- `git pull origin master`
- start IntelliJ

- in terminal: `cd /home/e34/Downloads`
- `java -jar selenium-server-standalone-3.4.0.jar`
- Selenium server is up and running message should appear in terminal
- in IntelliJ open EndToEndTest.java (in package src/test/e2e)
- double-click on method fillPage()
- right-click and select Run 'fillPage()'
- --> test will fail but browser should at least open

- in browser go to http://localhost:8080
- click on "build" icon in "unittests" job (this will trigger the build pipeline)
- click on the cisco-pipeline tab to view the build pipeline

- open "Seleniumtraining" project
- go to src/test/java/webdriverBasics and open BasicTests.java
- right-click on "firstFirefoxTest()" and Run the test
- browser should open and navigate to element34.net website



### start EC2 environment
knife ec2 server create  -I ami-7d8bdb4d -f t1.micro --ssh-user ubuntu  --identity-file ~/Desktop/gridfusion.pem --region us-west-2

### start EC2 instance with Chef / Chef Server
knife ec2 server create  -I ami-7d8bdb4d -f t1.micro --ssh-user ubuntu  --identity-file ~/Desktop/gridfusion.pem --region us-west-2 -r "role[cdi_tomcat_aws]"

### Chef Server Web
https://manage.chef.io/login

### SSH into EC2 instance
ssh -i ~/Desktop/gridfusion.pem ubuntu@ec2-54-68-233-4.us-west-2.compute.amazonaws.com

### Location of self created chef cookbooks
/Users/gridfusion/Desktop/programming/chef-repo/cookbooks/

Tomcat cookbook is in ~/.berkshelf. To change i.e. the port from 2808 to something else edit the default.rb in /Users/gridfusion/.berkshelf/cookbooks/tomcat-0.17.3/attributes

berks install : run it from above directory to install the local cookbooks in .berkshelf directory

berks upload –force : run to upload cookbooks from .berkshelf to chef server

## DOCKER
Docker networking help: https://docs.docker.com/engine/installation/mac/#container-port-redirection <br>
Show running docker containers: docker ps <br>
Show details of LAST container started: docker ps -l <br>
Show IP / Port mapping of container: docker port stupefied_brattain <br>
Show IP address of the VM: docker-machine ip default <br>
Run container and expose port 8080: docker run -itP --expose 8080 tomcat:8.0 <br>
Open shell for container: docker exec -i -t <container id> bash <br>

## Docker Ubuntu 
Run interactive container: `docker run ubuntu /bin/echo 'Hello world'`

## Docker run container as a daemon 
`docker run -d ubuntu /bin/sh -c "while true; do echo hello world; sleep 1; done" <br>`
Look at logs: `docker logs "containername"` <br>

## Port mapping 
`0.0.0.0:49155->5000/tcp` : means that container port 5000 is mapped to VM/Host port 49155

`docker run -d -p 80:5000 training/webapp python app.py` maps container port 5000 to port 80 on VM / Host 

`docker port nostalgic_morse 5000` shows what port 5000 is mapped to publicly 

`$ docker inspect nostalgic_morse` Inspect docker container 

`$ docker rm nostalgic_morse` Remove docker containes

`gridfusion@ubuntu:~$ docker search selenium` Search for docker images

## Creating your own image
Pulling a new image: `$ docker pull training/sinatra`

Run in interactive mode: `$ docker run -t -i training/sinatra /bin/bash`
**Take note of the container ID at this point. You will need it later for the commit**

Edit the image: `root@0b2616b0e5a8:/# gem install json`

Commit the changes: `$ docker commit -m "Added json gem" -a "Kate Smith" 0b2616b0e5a8 palotas/sinatra:v2`

When running `docker images` you should see the `palotas/sinatra:v2` image

Run the new image: `$ docker run -t -i palotas/sinatra:v2 /bin/bash`

## Create new image with DOCKERFILE
    # This is a comment
    FROM ubuntu:14.04
    MAINTAINER Michael Palotas <michael.palotas@gridfusion.net>  
    RUN apt-get update && apt-get install -y ruby ruby-dev
    RUN gem install sinatra
    RUN apt-get install -y wget
    
Build new docker image: `$ docker build -t palotas/sinatra:v2 .`

##Push new docker image to docker hub
make sure you are logged in: `docker login`

`$ docker push palotas/sinatra`






