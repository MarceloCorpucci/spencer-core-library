package spencer.port.io;

import spencer.domain.core.creator.EnumEntityBuilder;

public abstract class SpencerTemplateWriter {
	private StringBuilder output;
	protected EnumEntityBuilder builder;
	
	public SpencerTemplateWriter(EnumEntityBuilder builder) {
		this.builder = builder;
		this.output = new StringBuilder();
	}
	
	public StringBuilder writeEnum() {
		output.append("public enum " + builder.getEnumName() + " {\n");
		
		for(int i = 0; i < builder.getConstantNames().size(); i++) {
			
			if(builder.getValueNames().size() != 0) {
				output.append("\t" + builder.getConstantNames().get(i) + "(\"" + builder.getValueNames().get(i) + "\")");
						
			} else {
				output.append(builder.getConstantNames().get(i));
			}
			
			if(builder.getConstantNames().size() == 1) {
				output.append(";\n\n");
			
			} else {
				
				if(i == builder.getConstantNames().size() - 1) {
				output.append(";\n\n");
				
				} else {
				output.append(",\n");
				}
			}	
		}
		
		if(builder.getAttributeName() != null) {
			output.append("\tprivate String " + builder.getAttributeName() + ";\n\n");
			output.append("\tpublic String get" + builder.getAttributeName().substring(0, 1).toUpperCase() + builder.getAttributeName().substring(1) + "() {\n");
			output.append("\t\treturn this." + builder.getAttributeName() + ";\n");
			output.append("\t}\n\n");
			
			output.append("\tprivate " + builder.getEnumName() + "(String " + builder.getAttributeName() + ") {\n");
			output.append("\t\tthis." + builder.getAttributeName() + " = " + builder.getAttributeName() + ";\n");
			output.append("\t}\n" + "}");
		}
		
		return output;
	}
	
	public abstract void getOutput(String out);
}
