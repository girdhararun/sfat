package sft.locators;

import sft.utils.Locator;

public class Locators_Login extends Locator
{
	public static Locator input_username = new Locator(CSS,"input[id='username']");
	public static Locator input_password = new Locator(CSS,"input[id='password']");
	public static Locator btn_login = new Locator(CSS,"input[id='Login']");
}
