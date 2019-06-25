# Practical Part 

- show code coverage test 
- show config of Publish Coverage Report
- unit test fails at first try 
- 80 / 40 / 40 percent (-> if less than 40% line coverage then next step is not triggered)
- run test with >40% coverage --> unit test still fails 
- fix test and push 
- build is green 

- enable unittests job 
- trigger codecoverage job (which triggers unittest job)


- AMAZON
- go to console 
- show AMI 
- launch instance 
- attach static IP 
- connect via SSH 
- docker run -d --name aws-prod -p 9998:8080 palotas/tomcat7-cdi
- check that container is up: http://ec2-3-120-160-174.eu-central-1.compute.amazonaws.com:9998



- show sonarqube (maybe plugin?) 