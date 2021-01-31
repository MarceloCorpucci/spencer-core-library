package spencer.adapter.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import spencer.core.creator.EnumEntityBuilder;
import spencer.port.io.SpencerTemplateWriter;

public class SpencerFileWriter extends SpencerTemplateWriter {
	private static final String NEW_LINE = System.lineSeparator();
	private Path path;
	
	public SpencerFileWriter(EnumEntityBuilder builder) {
		super(builder);
	}

	@Override
	public void getOutput(String out) {
		path = Paths.get(System.getProperty("user.dir") + "/src/main/java/spencer/core/io/" + this.builder.getEnumName() + ".java").toAbsolutePath();
		
		try {
			String content = "package spencer.core.io;\n\n" + out + NEW_LINE;
	    	Files.write(path, content.getBytes(StandardCharsets.UTF_8));

       } catch (IOException e) {
           System.err.format("IOException: %s%n", e);
       }
	}

}
