FROM tomcat:7.0
USER root
RUN apt-get update
RUN apt-get install --yes vim

EXPOSE 8080

#download tomcat-users.xml file
ADD https://s3.amazonaws.com/e34/tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml
