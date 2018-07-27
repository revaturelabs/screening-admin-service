# screening-admin-service

# Setting up your development environment.

These instructions are meant to work for the 1805 batch at revature.

## Setup instructions

Set the following env variables in eclipse or in your operating
system. If you set them in your operating system, you will need to
restart eclipse for the new changes to take place.

CALIBER_CONFIG_SERVER_URL=Contact ops team for this url.
CALIBER_EUREKA_SERVER_URL=http://localhost:8761

RESTART ECLIPSE!!!!

### Install spring tools
  1. In the menu bar, select Help > Eclipse Marketplace
  2. In the find box, type "spring tools" and push enter
  3. Install the second option "Spring Tools (aka Spring IDE and Spring Tool Suite)"
  4. This process takes about 15 minutes, make sure to follow the prompts.

### Setting up eureka
  1. Open up caliber-meta/caliber-eureka in eclipse.
  2. Right click caliber-eureka > Run As > Spring Boot App

Now you have a working instance of Eureaka assuming no errors. If you
have issues finding the config server, verify that your environment
variables are set correctly and restart eclipse. Ask an ops member if
problems persist.
