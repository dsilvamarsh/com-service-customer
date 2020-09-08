
echo hello marsh
mvn clean compile package
docker build -t dsilvamarsh/com-service-customer:1.0.0 .
docker run -p 80:8081 -e "JAVA_OPTS=-Xmx150m" dsilvamarsh/com-service-customer:1.0.0 


