
FROM mcr.microsoft.com/openjdk/jdk:21-ubuntu

# Set working directory
WORKDIR /app

COPY build/libs/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/app/demo-0.0.1-SNAPSHOT.jar"]


# Copy application files (adjust as needed)
#COPY . /app

# Default command (adjust as needed)
#CMD ["java", "-version"]