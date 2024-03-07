FROM bitnami/wildfly:26.1.3
COPY target/wildfly-tests.war /opt/bitnami/wildfly/standalone/deployments
ENV WILDFLY_PASSWORD Test1234