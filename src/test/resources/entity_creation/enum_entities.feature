Feature: Enum Entity Creation
	As a user of Spencer
	I want to create Domain Enum Entities programmatically
	So I will count with an easy way to manage harness code

	Background: Entity to create
		Given I decided to create the Enum Entity "BrowserName" with the following values
		* A constant "CHROME"
		* A constant value "chrome"   
		* An attribute "name"
			
	Scenario: User creates a Domain Enum Entity - Console output
		When I invoke the EntityBuilder 
		And the ConsoleWriter
		Then I should get the Enum code in command line
		
	Scenario: User creates a Domain Enum Entity - File output
		When I invoke the EntityBuilder
		And the FileWriter using the path "src/test/java" and the package "spencer.core"
		Then I should get the Enum code in a file
		

		   