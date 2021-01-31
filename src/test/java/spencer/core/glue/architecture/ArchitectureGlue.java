package spencer.core.glue.architecture;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ArchitectureGlue {
	private String domainCorePackage;
	private String domainStructuralPackage;
	private String portPackage;
	private String adapterPackage;
	
		@Given("Spencer implements the Hexagonal Architecture")
		public void spencer_implements_the_hexagonal_architecture() {
		}

		@When("I see the main design from the highest level")
		public void i_see_the_main_design_from_the_highest_level() {
			try {
				domainCorePackage = Class.forName("spencer.domain.core.Core").getPackage().getName();
				domainStructuralPackage = Class.forName("spencer.domain.structural.Structural").getPackage().getName();
				portPackage = Class.forName("spencer.port.Port").getPackage().getName();
				adapterPackage = Class.forName("spencer.adapter.Adapter").getPackage().getName();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		@Then("I should find the following module distribution:")
		public void i_should_find_the_following_module_distribution() {
		}
		
		@Then("The domain core layer implemented in {string}")
		public void the_domain_core_layer_implemented_in(String string) {
			assertThat(domainCorePackage, equalTo(string));
		}
		
		@Then("The domain structural layer implemented in {string}")
		public void the_domain_structural_layer_implemented_in(String string) {
			assertThat(domainStructuralPackage, equalTo(string));
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
