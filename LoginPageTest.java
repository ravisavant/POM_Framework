package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.Hompage;
import com.pages.LoginPage;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    Hompage homePage;

    public LoginPageTest() {
        super(); // loads properties
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }

    @Test
    public void loginPageTitleTest() {
        String title = loginPage.validatingLoginPageTitle();
        Assert.assertEquals(title, "OrangeHRM");
        //System.out.println(title);
    }

    @Test
    public void loginPageLogoTest() {
        Assert.assertTrue(loginPage.validateLoginPageLogo());
    }

    @Test
    public void loginTest() {
        homePage = loginPage.login(
            prop.getProperty("username"),
            prop.getProperty("password")
        );
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
