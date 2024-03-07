
# Requirements
- jdk8
- maven
- docker
- 

## Command line
`mvn clean install`

`docker build . -t wildfly-tests:latest`

`docker run -p 8080:8080 --name wildfly-error wildfly-tests:latest`