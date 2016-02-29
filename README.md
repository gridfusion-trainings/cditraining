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
Run interactive container: docker run ubuntu /bin/echo 'Hello world'

## Docker run container as a daemon 
docker run -d ubuntu /bin/sh -c "while true; do echo hello world; sleep 1; done" <br>
Look at logs: docker logs "containername"





