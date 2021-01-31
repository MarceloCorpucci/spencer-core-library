package spencer.core.glue.architecture;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ArchitectureGlue {
	private String corePackage;
	private String portPackage;
	private String adapterPackage;
	
		@Given("Spencer implements the Hexagonal Architecture")
		public void spencer_implements_the_hexagonal_architecture() {
		}

		@When("I see the main design from the highest level")
		public void i_see_the_main_design_from_the_highest_level() {
			try {
				corePackage = Class.forName("spencer.core.Core").getPackage().getName();
				portPackage = Class.forName("spencer.port.Port").getPackage().getName();
				adapterPackage = Class.forName("spencer.adapter.Adapter").getPackage().getName();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		@Then("I should find the following module distribution:")
		public void i_should_find_the_following_module_distribution() {
		}
		
		@Then("The core layer implemented in {string}")
		public void the_core_layer_implemented_in(String string) {
			assertThat(corePackage, equalTo(string));
		}
		
		@Then("The port layer implemented in {string}")
		public void the_port_layer_implemented_in(String string) {
			assertThat(portPackage, equalTo(string));
		}
		
		@Then("The adapter layer implemented in {string}")
		public void the_adapter_layer_implemented_in(String string) {
			assertThat(adapterPackage, equalTo(string));
		}



}
