# RomanConvertor

This repository houses the web application [REST Service] for converting an integer to a roman number.

The project is built using maven and java. It generates a .war which can deployed on any web container.
I am using apache-tomcat-9.0.50. Below are the steps to setup and deploy the app.

## Setup / How to build and run:

Prerequisites
1) Apache Maven 3.6.3 or higher [https://maven.apache.org/install.html]
2) Java 8
3) apache-tomcat-9.0.50 [https://tomcat.apache.org/download-90.cgi#9.0.50]

Deployment Steps
1) Download the 'master' branch of the repo [https://github.com/dttrehan/RomanConvertor.git]
2) cd RomanConvertor/
3) 'mvn clean package' to compile
4) Copy the generated RomanConvertor/target/RomanConvertor-0.0.1-SNAPSHOT.war to apache-tomcat-9.0.50/webapps/
5) Update ContextPath in conf/context.xml to "<Context path="/">"
6) Add the following to conf/server.xml to 
<Host> .....
<Context docBase="RomanConvertor-0.0.1-SNAPSHOT" path="/"/>
</Host>
7) context.xml and server.xml are available in this repo at RomanConvertor/tomcat-config/
8) start tomcat ; cd apache-tomcat-9.0.50/bin ; ./catalina run
9) Open a browser and hit http://localhost:8080/romannumeral?query=1
10) Change query=<XXX> to test with more inputs

## Engineering and testing methodology.

This is a simple web service developed in **java and jersey framework** for RESTful web services. 
Jersey is an open source , production quality, framework for developing RESTful Web Services in Java that provides support for JAX-RS APIs.
The service take an integer as an input and returns a json output which is either a roman number 
or an exception if the input number is out of range.
A 'RomanNumeralResource' class exposes the web service , works with http,  supports GET method and produces json output. The actual logic for the conversion
resides in IntegerToRomanConvertor class.
I have used **Maven 3.6.3** as the build and code management system. Maven an open source software project management and comprehension tool.

### Other things to note : 

* Junits are available at RomanConvertor/src/test/java and get executed when we compile the source.The application uses **junit4** libraries to execute tests.
* logs are generated at /tmp/roman_numeral.log for monitoring and debugging. I have used **Apache log4j2** API to implement logging.
* The service also logs the time in milliseconds to process each request in the same log file. The log files rollover after a maximum size of 1MB.
* The service handles concurrent requests with a maximum of 200 which is what tomcat container can take by default.
* To scale out further, 
	 * multiple instances of tomcat can be deployed with a load balancer
	 * or the application can be built on cloud using AWS Apigateway, AWS lambda and cloudwatch.
	 
* Docker Image : I am not a docker pro but I have tried to build an image for my application. Below are the steps to run
	* Prerequisites : Install Docker
	* docker image location : https://hub.docker.com/r/divyatrehan/romanapp
	* docker pull divyatrehan/romanapp
	* docker run -p 8080:8080 divyatrehan/romanapp
	* Open a browser and hit http://localhost:8080/romannumeral?query=1
Other ways to test
	* cURL  : Open a terminal and hit curl -s http://localhost:8080/romannumeral?query=1
	* Install open source app 'Postman' and configure a new GET Request with the same URL.
	
