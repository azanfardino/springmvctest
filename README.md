springmvctest
======

The project is a simple web application based on Spring MVC. 

It offers a UI to find places (location, airport, etc.) typing a text to search.

On the back side the application delegates the searching to a public REST API that responds in Json.

Than Json is unmarshalled and the result is returned to a JSP view that make rendering in HTML.

Also it is possible to download the result in CSV format.


There are two controllers: PlaceSearchController and CsvController. They use a PlaceService to fill the model.

In PlaceService is injected a concrete factory that creates the instances of a family of classes (Abstract Factory Pattern).

The frameworks and technologies used are:

- Apache's HttpClient (used to connect to REST API) 

- Google's Gson (used to convert Json to Objects).

- SuperCSV (used to write Objects in a CSV file)

- Apache Tiles (as template framework)

- Log4J (for logging)

- Apache Maven (for building)


==================

Configuration

Internet proxy - 
If you need to use an Internet proxy change dispatcher-servlet.xml uncommenting the following lines
and setting your proxy details:

<bean id="placeService" class="mytest.spring.service.PlaceService">
	     <constructor-arg ref="abstractFactoryImpl" />
	     <constructor-arg value="http://api.goeuro.com/api/v2/position/suggest/en/" />
	 
	     <!-- uncomment this 
	         
	     <constructor-arg value="proxyhost" />
	     <constructor-arg value="8080" />
	     
	     -->
</bean> 









