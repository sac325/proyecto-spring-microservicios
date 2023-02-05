mvn clean install -f "D:\archivos\aws\proyecto-spring-microservicios\springboot-servicio-configuracion-service\pom.xml" -Dmaven.test.skip=true
mvn clean install -f "D:\archivos\aws\proyecto-spring-microservicios\springboot-servicio-eureka\pom.xml" -Dmaven.test.skip=true
mvn clean install -f "D:\archivos\aws\proyecto-spring-microservicios\springboot-servicio-gateway-server\pom.xml" -Dmaven.test.skip=true
mvn clean install -f "D:\archivos\aws\proyecto-spring-microservicios\springboot-servicio-equipos\pom.xml" -Dmaven.test.skip=true
mvn clean install -f "D:\archivos\aws\proyecto-spring-microservicios\springboot-servicio-oauth\pom.xml" -Dmaven.test.skip=true
mvn clean install -f "D:\archivos\aws\proyecto-spring-microservicios\springboot-servicio-usuarios\pom.xml" -Dmaven.test.skip=true

java -jar "D:\archivos\aws\proyecto-spring-microservicios\springboot-servicio-configuracion-service\target\springboot-servicio-configuracion-service-0.0.1-SNAPSHOT.jar"
java -jar "D:\archivos\aws\proyecto-spring-microservicios\springboot-servicio-eureka\target\springboot-servicio-eureka-0.0.1-SNAPSHOT.jar"
java -jar "D:\archivos\aws\proyecto-spring-microservicios\springboot-servicio-gateway-server\target\springboot-servicio-gateway-server-0.0.1-SNAPSHOT.jar"
java -jar "D:\archivos\aws\proyecto-spring-microservicios\springboot-servicio-equipos\target\springboot-servicio-equipos-0.0.1-SNAPSHOT.jar"
java -jar "D:\archivos\aws\proyecto-spring-microservicios\springboot-servicio-oauth\target\springboot-servicio-oauth-0.0.1-SNAPSHOT.jar"
java -jar "D:\archivos\aws\proyecto-spring-microservicios\springboot-servicio-usuarios\target\springboot-servicio-usuarios-0.0.1-SNAPSHOT.jar"
