package sft.locators;

import sft.utils.Locator;

public class Locators_Get extends Locator
{
	public static Locator getFormDetailsUI = new Locator(XPATH,
"//div[contains(@class, 'forcePageBlockSectionView')]//div[contains(@class, 'forcePageBlockSectionRow')]//div[contains(@class, 'forcePageBlockItem')]//div[contains(@class,'label')]/span[text()='${fieldName}']/../../div[last()]/span");

	public static Locator getEmail_ReferenceDetailUI = new Locator(XPATH,getFormDetailsUI.value+"//a");
}
