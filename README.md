# CDI Training 

### Run tests with Maven
Unit tests: mvn test -Dgroup=unit

Integration tests: mvn test -Dgroup=integration

E2E tests: mvn test -Dgroup=end2end

Run in specific environments: 

mvn test -Dgroup=end2end -Denv=QA / PRODUCTION / VAGRANT

### Cobertura code coverage
mvn clean test cobertura:cobertura -Dgroup=unit 

### SONAR
cd /home/gridfusion/SeleniumTraining/sonar-3.7.4/bin/linux-x86-32 </br>
./sonar start </br>
mvn clean test -Dgroup=unit sonar:sonar 


