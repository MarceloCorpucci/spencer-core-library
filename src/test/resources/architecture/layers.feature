Feature: Spencer layers
	
	This feature is intended to describe the architectural style of this library,
	using concrete examples and executable specifications.
	
	Spencer core was ment to offer a modular distribution of all his features, 
	so the elected style was the Ports and Adapters architecture, also known 
	as Hexagonal Architecture. 
	
	Of course other alternatives can do the job in the exact same way, however the aldeady mentioned 
	option is not very often to find.
	
	Scenario: Main description
		Given Spencer implements the Hexagonal Architecture
		When I see the main design from the highest level
		Then I should find the following module distribution:
			* The domain core layer implemented in "spencer.domain.core"
			* The domain structural layer implemented in "spencer.domain.structural"
			* The port layer implemented in "spencer.port"
			* The adapter layer implemented in "spencer.adapter"
