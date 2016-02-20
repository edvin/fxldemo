# Maven QuickStart Demo Application for FXLauncher

This example showcases how to configure [FXLauncher](https://github.com/edvin/fxlauncher) in your
Maven application to provide automatic updates optionally in combination with native installers.

Please see [pom.xml](/pom.xml) for complete documentation.

**Note**: There is nothing Maven spesific about FXLauncher, and these operations should be easy to perform in any build system.
	There is also a [Gradle version](https://github.com/edvin/fxldemo-gradle) of this project. 

## Operations

The following operations are supported by the example:

1. Compile project jar to app.dir
2. Copy dependencies to app.dir
3. Generate app.xml manifest
4. Create native installer
5. Upload artifacts to auto update repository

### Configuration

Copy the deployment descriptor and customize the following properties:

```xml
<properties>
	<!-- Application Name -->
	<app.filename>${project.name}</app.filename>

	<!-- The JavaFX Application class name -->
	<app.mainClass>no.tornado.FxlDemo</app.mainClass>

	<!-- The app and launcher will be assembled in this folder -->
	<app.dir>${project.build.directory}/app</app.dir>

	<!-- Native installers will be build in this folder -->
	<app.installerdir>${project.build.directory}/installer</app.installerdir>

	<!-- Base URL where you will host the application artifacts -->
	<app.url>http://fxsamples.tornado.no/demo/</app.url>

	<!-- Optional scp target for application artifacts hosted at the above url -->
	<app.deploy.target>w48839@fxldemo.tornado.no:fxldemo</app.deploy.target>
</properties>
```

### Maven targets
 
#### Generate the application

	mvn clean package
	
#### Deploy the application artifacts to your webserver
	
	mvn exec:exec@deploy-app
	
#### Build a native installer
	
	mvn install

### Prebuilt installers

See http://fxldemo.tornado.no for a prebuilt version of this application, including native installers
for Windows, MacOSX and Linux.