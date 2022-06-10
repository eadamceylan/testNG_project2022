package techproed.tests.dataprovider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.DefaultPage;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

public class Day18_DataProvider2 {
    HomePage homePage;
    LoginPage loginPage;
    DefaultPage defaultPage;
    @DataProvider(name = "customer-login-data" )
    public Object [][] dataProviderMethod(){
        Object [][] customerCredential = {
                {"customer@bluerentalcars.com","12345"},
                {"customer1@bluerentalcars.com","12346"},
                {"customer2@bluerentalcars.com","12347"},
                {"customer3@bluerentalcars.com","12348"}
        };
        return customerCredential;
    }

    /*
    Data provider is similar to getting data from Excel.
    The difference is that we do not need to use any loop,
    it gets automatically
    */
    public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        homePage = new HomePage();
        loginPage = new LoginPage();
        defaultPage = new DefaultPage();
        try {
            homePage.homeLoginButton.click();
        } catch (Exception e){
        }
        try {
            defaultPage.userID.click();
            defaultPage.logOut.click();
            defaultPage.OK.click();
            homePage.homeLoginButton.click();
        } catch (Exception e){
        }
    }
    @Test (dataProvider = "customer-login-data" )
    public void customerLogin(String username, String password) throws IOException {
        login();
        ReusableMethods.waitFor(1);
        loginPage.username.sendKeys(username);
        ReusableMethods.waitFor(1);
        loginPage.password.sendKeys(password);
        ReusableMethods.waitFor(1);
        loginPage.loginButton.click();
// Assertion
        Assert.assertTrue(defaultPage.userID.isDisplayed());

        ReusableMethods.getScreenshot("ManagerLoginTest");
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}