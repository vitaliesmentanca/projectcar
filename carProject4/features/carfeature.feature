#----------------------------------
# Empty Cucumber .feature file
#----------------------------------
  Feature: Cars Search 
Scenario: Search 
Given user is on HomePage
When title is Cars
And user enter data Makes and Models 
And user click on Search button
And user is on Search Result Page
Then user close the browserr chrome       

   