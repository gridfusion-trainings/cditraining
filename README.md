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
./sonar start </br>
mvn clean test -Dgroup=unit sonar:sonar </br>

### start EC2 environment
knife ec2 server create  -I ami-7d8bdb4d -f t1.micro --ssh-user ubuntu  --identity-file ~/Desktop/gridfusion.pem --region us-west-2

### start EC2 instance with Chef / Chef Server
knife ec2 server create  -I ami-7d8bdb4d -f t1.micro --ssh-user ubuntu  --identity-file ~/Desktop/gridfusion.pem --region us-west-2 -r "role[cdi_tomcat_aws]

### Chef Server Web
https://manage.chef.io/login

### SSH into EC2 instance
ssh -i ~/Desktop/gridfusion.pem ubuntu@ec2-54-68-233-4.us-west-2.compute.amazonaws.com

### Location of self created chef cookbooks
/Users/gridfusion/Desktop/programming/chef-repo/cookbooks/

berks install : run it from above directory to install the local cookbooks in .berkshelf directory

berks upload –force : run to upload cookbooks from .berkshelf to chef server


