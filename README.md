# NetflixConductor
  how to install conductor

# Installing

# Requirements

1. Database: Dynomite
2. Indexing Backend: Elasticsearch 5.x
3. Servlet Container: Tomcat, Jetty, or similar running JDK 1.8 or higher

# Use the pre-configured Docker image

# clone sample java program

  https://github.com/prasanjeetdas/NetflixConductor.git
 
# this program file contains:
  
  * docker-compose.yml file
  * DockerFile

# changes you need to make:

  * change the location of Docker file in "docker-compose.yml" based on you system location
  * changes has to be made for both server and UI.

# in order to get the images and containers for the conductor

  run the command from where your Docker-compose.yml is there "in our case we have it  file named docker"
  
  command: docker-compose build

# After the docker images are built, run the following command to start the containers

  command: docker-compose up
 
 ** you can check the images and containers in docker desktop 
 
 # to get executable jar file

  * if you are getting error "jar file is not valid or no mainfest attributes"
  * in order to get valid jar file 
  * run command: mvn clean install (you will get your jar file in target folder)

# you may facing compailer version error:
  
  https://www.baeldung.com/java-lang-unsupportedclassversion
  
# you can check through  docker desktop weather all the containers are running without exited automatically.
