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


