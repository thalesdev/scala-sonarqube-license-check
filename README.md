# scala-sonarqube-license-check
Simple project to test license check sonarqube plugin for scala

1. create sonarqube project and set key configs and login in `sonar-project.properties`

2. to run sonarqube analyze:
```
sbt -v +coverage +test +coverageAggregate +scapegoat +sonarScan
```
