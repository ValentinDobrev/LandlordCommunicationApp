# Landlord Communication

A mobile solution to accommodate interactions between landlords and their tenants.

A graduation project for the Telerik Academy Alpha Java+Android track 2018. 

Project assigned by Experian. 

## Team members

Valentin Dobrev - https://github.com/ValentinDobrev

Nikola Bunis - https://github.com/NikolaBunis

Svetoslav Ishev - https://github.com/svetoslavishev

## Description

This is a full stack development exercise. The project includes a web back end, providing a RESTful API and a relational database layer. The user interface is handled by a native Android application front end, communicating via HTTP.

## Functionality

### Login as a landlord or tenant

<img src="https://github.com/ValentinDobrev/LandlordCommunicationApp/blob/master/screenshots/LoginDefault.png" width="350">    <img src="https://github.com/ValentinDobrev/LandlordCommunicationApp/blob/master/screenshots/LoginValidation.png" width="350">


### Review the residences you rent to tenants or rent from landlords respectively

<img src="https://github.com/ValentinDobrev/LandlordCommunicationApp/blob/master/screenshots/MainMenu.png" width="350">  <img src="https://github.com/ValentinDobrev/LandlordCommunicationApp/blob/master/screenshots/ResidencesList.png" width="350">

### Review your residence info, pay your rent as a tenant, communicate with both landlords and tenants

<img src="https://github.com/ValentinDobrev/LandlordCommunicationApp/blob/master/screenshots/ResidenceOverviewTenantTop.png" width="350">   <img src="https://github.com/ValentinDobrev/LandlordCommunicationApp/blob/master/screenshots/ResidenceOverviewLandlordTop.png" width="350">

<img src="https://github.com/ValentinDobrev/LandlordCommunicationApp/blob/master/screenshots/ResidenceOverviewTenantBottom.png" width="350">   <img src="https://github.com/ValentinDobrev/LandlordCommunicationApp/blob/master/screenshots/ResidenceOverviewLandlordBottom.png" width="350">
  
### Exchange valuable information with the residence landlord and ALL tenants

<img src="https://github.com/ValentinDobrev/LandlordCommunicationApp/blob/master/screenshots/ChatEmpty.png" width="350">   <img src="https://github.com/ValentinDobrev/LandlordCommunicationApp/blob/master/screenshots/ChatDemo.png" width="350">

### Utilise useful template messages and attach pictures you take with your phone's camera

<img src="https://github.com/ValentinDobrev/LandlordCommunicationApp/blob/master/screenshots/ChatTemplates.png" width="350">   <img src="https://github.com/ValentinDobrev/LandlordCommunicationApp/blob/master/screenshots/ChatPictureSend.png" width="350">

<img src="https://github.com/ValentinDobrev/LandlordCommunicationApp/blob/master/screenshots/ChatPictureReview.png" width="350">   <img src="https://github.com/ValentinDobrev/LandlordCommunicationApp/blob/master/screenshots/ChatKeyboard.png" width="350">


### Lookup and rate other users, both landlords and tenants

<img src="https://github.com/ValentinDobrev/LandlordCommunicationApp/blob/master/screenshots/AllUsers.png" width="350">  <img src="https://github.com/ValentinDobrev/LandlordCommunicationApp/blob/master/screenshots/UserDetails.png" width="350">

<img src="https://github.com/ValentinDobrev/LandlordCommunicationApp/blob/master/screenshots/UserRatingBar.png" width="350">   <img src="https://github.com/ValentinDobrev/LandlordCommunicationApp/blob/master/screenshots/UserRatingUpdated.png" width="350">

## Deployment overview

The project is in an initial state, it can be deployed utilising the IDEs used for its development and a standard MariaDB installation.

### Required software
 * Java 8 JDK:
 - OpenJDK:
 https://openjdk.java.net/install/index.html
 or
 - Oracle:
 https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
 * Android Studio: https://developer.android.com/studio/
 * IntelliJ IDEA: https://www.jetbrains.com/idea/
 * MariaDB: https://mariadb.org/download/

### Required hardware
 * A half decent computer with enough RAM (8 to 12 GB should be sufficient)
 * An android phone or tablet (optional)
 * Massive amounts of patience and nerves of steel if you intend to fork, expand or modify :)
 
 ### Deployment instructions
   
  1. Install the Java 8 JDK version for your OS.
  
  2. Install MariaDB and deploy the initialisation scripts int the following order:
   * https://github.com/ValentinDobrev/LandlordCommunicationApp/tree/master/db/databaseScript
   * https://github.com/ValentinDobrev/LandlordCommunicationApp/tree/master/db/dataRecordsScript
  
  3. Create a user account with rights to the landlordcommunication schema:
   - user name: thing
   - password: neshto
  
  4. Install IntelliJ IDEA  and import project from the following directory:
  https://github.com/ValentinDobrev/LandlordCommunicationApp/tree/master/web
  
  5. Sync Gradle dependencies and run the web application
  
  6. Install Android Studio and import project from the following directory:
  https://github.com/ValentinDobrev/LandlordCommunicationApp/tree/master/app
  
  7. Sync Gradle dependencies and create a new virtual device from Tools -> AVD Manager
  (Android 8.0 API 26 recommended for being most stable as of November 2018. Thanks, Google!)
  
  8. Add your machine's local IP address to the Constants.BASE_SERVER_URL variable
  
  9. Run the application on the newly created Android virtual device
  
  10. (Optional) Enable developer options on a real Android device, connect it via USB, run the project on it by selecting it in the "Select Deployment Target" menu (it must be recognised by your OS before it's recognised by Android Studio)
   

## Technology stack

 ### Main
    
* Front end: Android https://www.android.com/
* Back end: Spring Framework https://spring.io/
* Database: MariaDB https://mariadb.org/

#### Utility libraries

##### Android
* ReactiveX: http://reactivex.io/
* OkHttp: http://square.github.io/okhttp/
* Gson: https://github.com/google/gson
* Material Drawer: https://github.com/mikepenz/MaterialDrawer
* Butter Knife: https://jakewharton.github.io/butterknife/
* Dagger: https://google.github.io/dagger/
* Android Saripaar: https://github.com/ragunathjawahar/android-saripaar
* Android Support Card View: https://developer.android.com/topic/libraries/support-library/
* FAB Clans button: https://github.com/Clans/FloatingActionButton
* Firebase Cloud Messaging: https://firebase.google.com/docs/cloud-messaging/
* Mockito: https://site.mockito.org/

##### Spring
* Hibernate: http://hibernate.org/
* Mockito: https://site.mockito.org/
* Spring Boot built in libs <3

## Design Principles

We followed our objective to apply the MVP pattern to the front end code. We applied dependency injection in both front end and back end and generally tried to follow the SOLID principles and RESTful philosophies.

## RESTful API

Title : Show All Users.
URL : /users 
Method : GET
URL Params : Not required
Response Codes: Success (200 OK), Bad Request (400), Unauthorized (401)

Title : Show User with ID.
URL : /users/{id}
Method : GET
URL Params : Required: id=[integer]
Response Codes: Success (200 OK), Bad Request (400), Unauthorized (401)

Title : Update User.
URL : /users/{id}
Method : PUT
URL Params : Required: id=[integer]
Response Codes: Success (200 OK), Bad Request (400), Unauthorized (401)

Title : Delete User.
URL : /users/{id}
Method : DELETE
URL Params : Required: id=[integer]
Response Codes: Success (200 OK), Bad Request (400), Unauthorized (401)

Title : Show All Residences.
URL : /residences
Method : GET
URL Params : Not required
Response Codes: Success (200 OK), Bad Request (400), Unauthorized (401)

Title : Show Residence with ID.
URL : /residences/{id}
Method : GET
URL Params : Required: id=[integer]
Response Codes: Success (200 OK), Bad Request (400), Unauthorized (401)

Title : Show Rating with ID.
URL : /rating/{id}
Method : GET
URL Params : Required: id=[integer]
Response Codes: Success (200 OK), Bad Request (400), Unauthorized (401)

Title : Add new Rating.
URL : /rating/
Method : POST
URL Params : Required: id=[integer]
Response Codes: Success (200 OK), Bad Request (400), Unauthorized (401)

Title : Add new Message.
URL : /messages/
Method : POST
URL Params : Required: id=[integer]
Response Codes: Success (200 OK), Bad Request (400), Unauthorized (401)

Title : Delete Message.
URL : /messages/{id}
Method : DELETE
URL Params : Required: id=[integer]
Response Codes: Success (200 OK), Bad Request (400), Unauthorized (401)

## Honourable mentions

@mikepenz for the awesome, easy to use, yet beutifully customisable drawer!
https://mikepenz.com/
https://github.com/mikepenz

@ragunathjawahar for transforming validation from a cumbersome chore into a creative endeavor!
https://github.com/ragunathjawahar



#### Repository URL
https://github.com/ValentinDobrev/LandlordCommunicationApp
