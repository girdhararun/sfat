package qa.resources.locators;

public class Locator 
{
	protected static final String CSS = "css";
	protected static final String XPATH = "xpath";
	protected static final String ID = "id";
	public String type;
	public String value;
	public Locator() {}
	public Locator(String type, String locator)
	{
		this.type = type.toLowerCase();
		this.value = locator;
	}
}
