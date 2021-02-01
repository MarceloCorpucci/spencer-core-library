package spencer.core;

public enum BrowserName {
	CHROME("chrome");

	private String name;

	public String getName() {
		return this.name;
	}

	private BrowserName(String name) {
		this.name = name;
	}
}
