# formula-one
This is a sample task on using the Formula one open API

# This is a simple Rest API with 2 end points exposed :
	/averageTime - This is fetching the average time of pit stops for the passed year
	URL to access the service: http://localhost:8080/v1/averageTime?year=2018&threshold=25
	
	/mostVictorious - This is fetching the top ten most victorious in grand prix for the given year range
	URL to access the service :http://localhost:8080/v1/mostVictorious?initailYear=2010&finalYear=2012
	
# Note the project clone can be taken from the -  https://github.com/danish0505/formula-one.git
  After taking the clone you can import the project in any IDE(eclipse/STS) and run this as simple spring boot application
  once server is started you can access the above two end point.	
