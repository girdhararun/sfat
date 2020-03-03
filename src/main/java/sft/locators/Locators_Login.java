package sft.locators;

import sft.utils.Locator;

public class Locators_Login extends Locator
{
	public static Locator input_username = new Locator(ID,"username");
	public static Locator input_password = new Locator(ID,"password");
	public static Locator btn_login = new Locator(ID,"Login");
}
