package spencer.core.glue;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import spencer.adapter.io.SpencerConsoleWriter;
import spencer.adapter.io.SpencerFileWriter;
import spencer.domain.core.creator.EnumEntityBuilder;
import spencer.port.io.SpencerTemplateWriter;

public class EntityBuilderGlue {
	private EnumEntityBuilder builder;
	private String enumName;
	private String name;
	private String value;
	private String attribute;
	private SpencerTemplateWriter writer;
	private String expectedOutput;
	private String path;
	private String aPackage;
	
	
	@Given("I decided to create the Enum Entity {string} with the following values")
	public void i_decided_to_create_an_enum_entity_with_the_following_values(String string) {
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
		
		this.enumName = string;
	}

	@Given("A constant {string}")
	public void name(String string) {
		this.name = string;
	}

	@Given("A constant value {string}")
	public void value(String string) {
		this.value = string;
	}

	@Given("An attribute {string}")
	public void attribute(String string) {
		this.attribute = string;
	}

	@When("I invoke the EntityBuilder")
	public void i_invoke_the_entity_builder() {
		builder = new EnumEntityBuilder.Create()
				.createEnumEntity(enumName)
				.withConstant(name)
				.withValue(value)
				.withAttribute(attribute)
				.build();
	}
	
	@When("the ConsoleWriter")
	public void the_consolewriter() {
		writer = new SpencerConsoleWriter(builder);
	}
	
	@When("the FileWriter using the path {string} and the package {string}")
	public void the_filewriter_using_path_and_package(String string, String string2) {
		writer = new SpencerFileWriter(builder);
		this.path = string;
		this.aPackage = string2;
	}

	@Then("I should get the Enum code in command line")
	public void i_should_get_the_enum_code_in_command_line() {
		StringBuilder anEnum = writer.writeEnum();
		String[] output = new String[1];
		output[0] = anEnum.toString();
		writer.getOutput(output);
		
		assertThat(anEnum.toString(), equalTo(expectedOutput));
	}
	
	@Then("I should get the Enum code in a file")
	public void i_should_get_the_enum_code_in_a_file() {
		StringBuilder anEnum = writer.writeEnum();
		String[] output = new String[3];
		output[0] = anEnum.toString();
		output[1] = path;
		output[2] = aPackage;	
		writer.getOutput(output);
		
		assertThat(anEnum.toString(), equalTo(expectedOutput));	
	}

}
