package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class LoginPage extends TestBase {

    @FindBy(name = "username")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;

    @FindBy(xpath = "//div[contains(@class,'orangehrm-login-branding')]")
    WebElement logo;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public String validatingLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean validateLoginPageLogo() {
        return logo.isDisplayed();
    }

    public Hompage login(String un, String pwd) {
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();
        return new Hompage();
    }
}
