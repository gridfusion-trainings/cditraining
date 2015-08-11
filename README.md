# CDI Training 

### Run tests with Maven
Unit tests: mvn test -Dgroup=unit
Integration tests: mvn test -Dgroup=integration
E2E tests: mvn test -Dgroup=end2end

Run in specific environments: mvn test -Dgroup=end2end -Denv=QA / PRODUCTION / VAGRANT
