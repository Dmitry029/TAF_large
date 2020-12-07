package com.jpetstore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

    @FindBy(css = "#WelcomeContent")
    WebElement greetingMessage;


    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public String getGreetingMessage(){
        return getTextFromElement(greetingMessage);
    }
}
