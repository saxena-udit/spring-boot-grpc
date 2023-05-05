# spring-boot-grpc-sample
This is sample spring boot project using grpc and spring web. 

It has Student grpc server and one web interface for exposing rest apis

### Running it locally
1. Build the project using `mvn clean install`
2. Run the project web server in IDE or using `mvn -pl web -am spring-boot:run` command
3. Run the project student server in IDE or using `mvn -pl student -am spring-boot:run` command 
4. Open URL http://localhost:8080/swagger-ui/index.html
5. You can see the swagger UI for the rest apis
6. You can also test the grpc apis using grpcurl or bloomrpc


