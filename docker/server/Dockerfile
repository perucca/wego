# Use an official Python runtime as a parent image
FROM  maven:3.5.4-jdk-8-alpine


# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
ADD . /app

# Install any needed packages specified in requirements.txt
RUN mvn clean package 

# Make port 80 available to the world outside this container
EXPOSE 8080

# Define environment variable
#ENV NAME World

# Run app.py when the container launches
CMD ["java", "-jar","target/wego-0.0.1-SNAPSHOT.jar"]
