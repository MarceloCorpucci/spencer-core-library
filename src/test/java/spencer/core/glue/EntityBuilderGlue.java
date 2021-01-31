package spencer.core.glue;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import spencer.adapter.io.SpencerConsoleWriter;
import spencer.domain.core.creator.EnumEntityBuilder;
import spencer.port.io.SpencerTemplateWriter;

public class EntityBuilderGlue {
	private EnumEntityBuilder builder;
	private String enumName;
	private String name;
	private String value;
	private String attribute;
	private SpencerTemplateWriter writer;
	String expectedOutput;
	
//	@Given("I decided to create an Enum Entity {enumName} with the following values")
	public void i_decided_to_create_an_enum_entity_with_the_following_values(String enumName) {
		expectedOutput = "public enum BrowserName {\n" + 
							"	CHROME(\"chrome\");\n" + 
							"\n" + 
							"	private String name;\n" + 
							"\n" + 
							"	public String getName() {\n" + 
							"		return this.name;\n" + 
							"	}\n" + 
							"\n" + 
							"	private BrowserName(String name) {\n" + 
							"		this.name = name;\n" + 
							"	}\n" + 
							"}";
		
		this.enumName = enumName;
	}

//	@Given("name {aName}")
	public void name(String aName) {
		this.name = aName;
	}

//	@Given("value {value}")
	public void value(String value) {
		this.value = value;
	}

//	@Given("attribute {anAttribute}")
	public void attribute(String anAttribute) {
		this.attribute = anAttribute;
	}

//	@When("I invoke the EntityBuilder object")
	public void i_invoke_the_entity_builder_object() {
		builder = new EnumEntityBuilder.Create()
				.createEnumEntity(enumName)
				.withConstant(name)
				.withValue(value)
				.withAttribute(attribute)
				.build();
	}

//	@Then("I should get the Enum code in command line")
	public void i_should_get_the_enum_code_in_command_line() {
		writer = new SpencerConsoleWriter(builder);
		
		StringBuilder out = writer.writeEnum();
		
		assertThat(out.toString(), equalTo(expectedOutput));
	}

}
