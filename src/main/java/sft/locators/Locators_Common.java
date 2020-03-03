package sft.locators;

import sft.utils.Locator;

public class Locators_Common extends Locator
{
	public static Locator btn_appLauncher = new Locator(CSS,"nav button[class *= 'AppLauncher']");
	public static Locator btn_Sales =  new Locator(XPATH,"//div[contains(@class,'dragArea')]//a[text()='${appName}']");
	public static Locator appName = new Locator(CSS,"span[class*='appName']");
	public static Locator pageHeading = new Locator(XPATH,"//nav[@aria-label='Breadcrumbs']//span[text()='${page}']");
	public static Locator newForm = new Locator(CSS,"a[title='New']");
	public static Locator formTitle =new Locator(CSS,"article h2");
	public static Locator saveForm = new Locator(CSS,"button[title='Save']");
	public static Locator newFormBearer = new Locator(CSS,"h1 lightning-formatted-name");
	public static Locator tabBar = new Locator(CSS,"lightning-tab-bar [title='${tab}']");
	public static Locator formDetailsActionToggle = new Locator(CSS,"div[class*='actionsContainer'] div[class='uiMenu'] div[class='uiPopupTrigger'] a");
	public static Locator formDetailsActionToggleActions = new Locator(CSS,"div[role='menu'] a[title='${action}']");
	//div[role='application tablist'] li:nth-child(3)  a>span:nth-child(1)
}
