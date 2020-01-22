package qa.resources.locators;

import org.openqa.selenium.By;

import qa.utils.BaseAction;

public class Locators_Common extends Locator
{
	public static Locator btn_appLauncher = new Locator(CSS,"nav button[class *= 'AppLauncher']");
	public static Locator btn_Sales =  new Locator(XPATH,"//div[contains(@class,'dragArea')]//a[text()='${appName}']");
	public static Locator appName = new Locator(CSS,"span[class*='appName']");
	public static Locator tab = new Locator(CSS,"a[title='${tab}']");
	public static Locator pageHeading = new Locator(XPATH,"//nav[@aria-label=\"Breadcrumbs\"]//span[text()='${page}']");
	public static Locator newForm = new Locator(CSS,"a[title='New']");
	public static Locator formTitle =new Locator(CSS,"article h2");
	public static Locator saveForm = new Locator(CSS,"button[title='Save']");
	public static Locator newFormBearer = new Locator(CSS,"div[class *= 'entityNameTitle']+div");
	public static Locator formDetails = new Locator(XPATH,"//a[@class='tabHeader']/span[text()='Details']/..//self::a");
}