package spencer.domain.core.creator;

import java.util.ArrayList;
import java.util.List;

public class EnumEntityBuilder {
	private String enumName;
	private List<String> constantNames;
	private List<String> valueNames;
	private String attributeName;

	public static class Create {
		private String enumName;
		private List<String> constantNames;
		private List<String> valueNames;
		private String attributeName;
		
		public Create() {
			this.constantNames = new ArrayList<String>();
			this.valueNames = new ArrayList<String>();
		}
		
		public Create createEnumEntity(String enumName) {
			this.enumName = enumName;
			return this;
		}
	
		public Create withConstant(String constantName) {
			this.constantNames.add(constantName);
			return this;
		}
	
		public Create withValue(String valueName) {
			this.valueNames.add(valueName);
			return this;
		}
	
		public Create withAttribute(String attributeName) {
			this.attributeName = attributeName;
			return this;
		}
	
		public EnumEntityBuilder build() {
			return new EnumEntityBuilder(this);
		}
	}
	
	private EnumEntityBuilder(Create builder) {
		this.enumName = builder.enumName;
		this.constantNames = builder.constantNames;
		this.valueNames = builder.valueNames;
		this.attributeName = builder.attributeName;
	}
	
	public String getEnumName() {
		return enumName;
	}

	public List<String> getConstantNames() {
		return constantNames;
	}

	public List<String> getValueNames() {
		return valueNames;
	}

	public String getAttributeName() {
		return attributeName;
	}

}
