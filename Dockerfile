From openjdk:8
copy ./target/health-mgmt-system-0.0.1-SNAPSHOT.jar health-mgmt-system-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","health-mgmt-system-0.0.1-SNAPSHOT.jar"]