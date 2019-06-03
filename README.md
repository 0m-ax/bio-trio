The project must be cloned from the GitHub repository and imported through Intellij.
The application will be automatically installed when the project is imported. In case the application is not properly installed by default, then the “install” Maven Lifecycle must be run, found by opening the Maven tab, under “spring-boot-vuejs/Lifecycle”.
 ![alt text](/README-images/spring-boot-vuejs.png)
 
Before running the application run the 1_structure.sql file in the sql folder. The 2_data file is not needed as these will be ran on starting the application.

In order for paypal payment to work replace see Category 8 in the Documentation

The MySQL database must be running on the default port and have the default user root with password root. If this is not the case change backend/src/main/resources/application.properties accordingly.

For the application to run, both the backend and frontend processes must be running. Both processes can be started from the Maven tab under “backend/Plugins/spring-boot/spring-boot:run” and respectively 
“frontend/Run Configurations/run frontend”.
 ![alt text](/README-images/backend-run.png)
 ![alt text](/README-images/frontend-run.png)
 
A default admin account has been created with the following details

email:admin@biotrio.com

password:admin
