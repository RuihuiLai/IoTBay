## IoTBay
## UTS - ISD - AUTUMN 2021 - ASSIGNMENT 2

Author: Reyvaldo Yung Chung Lay

This is the read me file for assignment 2

The steps to use this Web Application.

* Download and install Netbeans 12 or greater.
* Download and install JDK 8  (Java SE Development Kit 8 as minimum Java requirement)
* Setup NetBeans
* Download the zip file from GitHub
* In Netbeans go to File > Import Project > From Zip...
* Navigate to the file that was downloaded previously and import it
* Create a new Database in Netbean
  * Go to the "Services" tab and expand "Databases"
  * Right click "Java DB" and click "Create Database..." and input the following information
    * Name: iotdb
    * User: iotuser
    * Password: admin
* Add information to the Database
  * Go back to "Projects" expand "IoTBay" expand "db" then open and run "tableCreation.sql"
  * Then open and run "insetMany.sql"
* Click on "Clean and Build Project" (Shift + F11) to Clean and Build Project
* Click on "Run Project" (F6) to start the website
* Browser will open the website on a local Glassfish server
