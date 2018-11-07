# Use an official Python runtime as a parent image
FROM  maven:3.5.4-jdk-8-alpine


# Set the working directory to /app
WORKDIR /app

ADD pom.xml /app

RUN ["/usr/local/bin/mvn-entrypoint.sh", "mvn", "verify", "clean", "--fail-never"]


# Copy the current directory contents into the container at /app
ADD . /app

# Install any needed packages specified in requirements.txt
RUN mvn clean package 

# Make port 8080 available to the world outside this container
EXPOSE 8080


# Run app.py when the container launches
CMD ["java", "-Dspring.profiles.active=prod", "-jar","target/wego-0.0.1-SNAPSHOT.jar"]
