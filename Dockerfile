From openjdk:17
copy ./target/*.jar continuous-integration.jar
CMD ["java","-jar","continuous-integration.jar"]
ENTRYPOINT ["java","-jar","/continuous-integration.jar"]
