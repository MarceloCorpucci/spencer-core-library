package spencer.adapter.io;

import spencer.domain.core.creator.EnumEntityBuilder;
import spencer.port.io.SpencerTemplateWriter;

public class SpencerConsoleWriter extends SpencerTemplateWriter {
	public String out;
	
	public SpencerConsoleWriter(EnumEntityBuilder builder) {
		super(builder);
	}

	@Override
	public void getOutput(String[] out) {
		System.out.println(out[0]);
	}

}
