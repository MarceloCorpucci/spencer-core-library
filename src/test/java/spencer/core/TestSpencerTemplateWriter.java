package spencer.core;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import spencer.adapter.io.SpencerConsoleWriter;
import spencer.core.creator.EnumEntityBuilder;
import spencer.port.io.SpencerTemplateWriter;


public class TestSpencerTemplateWriter {

	@Test
	public void createBasicEnumEntity() {
		EnumEntityBuilder builder;
		SpencerTemplateWriter writer;
		String expectedOutput = "public enum BrowserName {\n" + 
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
		
		builder = new EnumEntityBuilder.Create()
										.createEnumEntity("BrowserName")
										.withConstant("CHROME")
										.withValue("chrome")
										.withAttribute("name")
										.build();
		
		writer = new SpencerConsoleWriter(builder);
		
		StringBuilder out = writer.writeEnum();
		writer.getOutput(out.toString());
		
		assertThat(out.toString(), equalTo(expectedOutput));
	}
	
	@Test
	public void createEnumEntityWithSeveralConstants() {
		EnumEntityBuilder builder;
		SpencerTemplateWriter writer;
		String expectedOutput = "public enum BrowserName {\n" + 
								"	FIREFOX(\"firefox\"),\n" + 
								"	INTERNET_EXPLORER(\"internet_explorer\"),\n" + 
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
		
		builder = new EnumEntityBuilder.Create()
										.createEnumEntity("BrowserName")
										.withConstant("FIREFOX")
										.withValue("firefox")
										.withConstant("INTERNET_EXPLORER")
										.withValue("internet_explorer")
										.withConstant("CHROME")
										.withValue("chrome")
										.withAttribute("name")
										.build();
		
		writer = new SpencerConsoleWriter(builder);
		
		StringBuilder out = writer.writeEnum();
		writer.getOutput(out.toString());
		
		assertThat(out.toString(), equalTo(expectedOutput));
	}
}
