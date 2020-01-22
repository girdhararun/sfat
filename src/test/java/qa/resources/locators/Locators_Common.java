package qa.resources.locators;

import org.openqa.selenium.By;

import qa.utils.BaseAction;

public class Locators_Common
{
	public static By btn_appLauncher = By.cssSelector("nav button[class *= 'AppLauncher']");
	public static String btn_Sales = "//div[contains(@class,'dragArea')]//a[text()='${appName}']";
	public static By appName = By.cssSelector("span[class*='appName']");
	public static String tab = "a[title='${tab}']";
	public static String pageHeading = "//nav[@aria-label=\"Breadcrumbs\"]//span[text()='${page}']";
	public static By newForm = By.cssSelector("a[title='New']");
	public static By formTitle = By.cssSelector("article h2");
	public static By saveForm = By.cssSelector("button[title='Save']");
	public static By newFormBearer = By.cssSelector("div[class *= 'entityNameTitle']+div");
	public static By formDetails = By.xpath("//a[@class='tabHeader']/span[text()='Details']/..//self::a");
}
