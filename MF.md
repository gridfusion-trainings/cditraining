# Practical Part 

- show code coverage test 
- show config of Publish Coverage Report
- 80 / 40 / 40 percent (-> if less than 40% line coverage then next step is not triggered)
- run test with >40% coverage 
- remove unit tests: CalculatorTests.java, commit and push 
- rerun code coverage test -> test fails 
- add unit tests again, cimmit, push 

- enable unittests job 
- trigger codecoverage job (which triggers unittest job)
- unit test fails at first try 


- AMAZON
- go to console 
- show AMI 
- launch instance 
- attach static IP 
- connect via SSH 
- docker run -d --name aws-prod -p 9998:8080 palotas/tomcat7-cdi
- check that container is up: http://ec2-3-120-160-174.eu-central-1.compute.amazonaws.com:9998



- show sonarqube (maybe plugin?) 