FROM tomcat:latest

LABEL maintainer="divyatrehan8@gmail.com"

ADD target/RomanConvertor-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/
ADD tomcat-config/server.xml /usr/local/tomcat/conf/
ADD tomcat-config/context.xml /usr/local/tomcat/conf/

EXPOSE 8080

CMD ["catalina.sh", "run"]



