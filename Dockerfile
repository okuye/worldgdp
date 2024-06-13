# Use the official Tomcat base image
FROM tomcat:9.0

# Copy the WAR file to the webapps directory of Tomcat
COPY target/worldgdp.war /usr/local/tomcat/webapps/

# Expose the Tomcat port
EXPOSE 8080

# Run Tomcat
CMD ["catalina.sh", "run"]
