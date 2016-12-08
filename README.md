Shopping Cart Exercise
======================

###1. Assumptions made
1. The solution has been coded as a service. A unit test has been provided to test the service
2. The idea is that this would be called via a REST Api which would hit a controller (not coded).
3. The controller would then delegate to this service.
4. The prices for the products are held in a JSON file called itemsAndPrices.json

###2. Technologies used
* Junit 4.1.1
* Jackson 2.3.3
* Maven 3
* Apache commons-exec 1.3


###3. To import this project into Eclipse IDE
1. ```$ mvn eclipse:eclipse```
2. Import into Eclipse via **existing projects into workspace** option.
3. Use the pom.xml file in the root of the hmrc directory
3. Done.

