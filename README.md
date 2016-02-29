# CDI Training 

### Run tests with Maven
Unit tests: mvn test -Dgroup=unit</br>
Integration tests: mvn test -Dgroup=integration </br>
E2E tests: mvn test -Dgroup=end2end </br>

####Run in specific environments: 
mvn test -Dgroup=end2end -Denv=QA / PRODUCTION / VAGRANT

### Cobertura code coverage
mvn clean test cobertura:cobertura -Dgroup=unit,integration (--> this will run both groups of tests)

### SONAR
cd /home/gridfusion/SeleniumTraining/sonar-3.7.4/bin/linux-x86-32 </br>
./sonar.sh start </br>
mvn clean test -Dgroup=unit sonar:sonar </br>

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




