Assignment #10

Your job is to create an application that integrates with the Spoonacular API such that you can create daily or weekly meal plans. Please review the Spoonacular API endpoint for generating meals here: https://spoonacular.com/food-api/docs#Generate-Meal-Plan

Step 1

The first thing you will need to do is register to use the Spoonacular API (there is a free version that should get the job done) via https://spoonacular.com/food-api/console#Dashboard

Once you’ve registered, you’ll get an api key. Be sure to save that somewhere as you’ll be needing it.

Note: when sending requests to the Spoonacular API, you’ll need to add a query param called apiKey (with the appropriate api key value) to your requests in order for the requests to be successful.

Step 2

Create a web app using the start.spring.io generator. You’ll need to make sure you use Java 11 in the advanced section, and you’ll also need to add the Web dependency.

Once you download the ZIP file from start.spring.io, you’ll need to extract the contents of this file into a folder of your choosing.

Next, you’ll need to import this folder / project into Eclipse via the “Import -> Maven -> Existing Maven Project”. Choose the pom.xml file from your folder and import.

Step 3

With a fresh Spring Boot project ready to go, you’ll need to create a Controller that has the following endpoints:

@GetMapping("mealplanner/week")

public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions)

@GetMapping("mealplanner/day")

public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions)

The WeekResponse and DayResponse Java objects will be a representation of the JSON Strings that are sent to you from the Spoonacular API.

Again, refer to https://spoonacular.com/food-api/docs#Generate-Meal-Plan for more information on how to fetch data for meal plans.

Step 4

In order to test your application, I would recommend using Postman to send GET requests to these two endpoints with different query params to ensure that the filtering process is working properly (i.e. it’s limiting the number of calories per day, and limiting meals by the types of diets / exclusions)

Bonus Points

If you’re up for an additional challenge, you can extract the actual URL for the generate meal plan endpoint into your application.properties file.

So instead of hard-coding the API’s URL into your Java code, you can instead break the URL into parts and store that in a properties file like so:

spoonacular.urls.base=https://api.spoonacular.com

spoonacular.urls.mealplan=/mealplanner/generate