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

    @DataProvider(name = "customer-login-data")
    public Object[][] dataProviderMethod(){
        Object[][] customerCredentials ={
                {"customer@bluerentalcars.com","12345"},
                {"customer1@bluerentalcars.com","12346"},
                {"customer2@bluerentalcars.com","12347"},
                {"customer3@bluerentalcars.com","12348"}
        };
        return customerCredentials;
    }

    /*Data provider is similar to getting data from excel
    * The main difference is Data Provider loops through the data automatically
    * */
    HomePage homePage;
    LoginPage loginPage;
    DefaultPage defaultPage;
    public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        homePage = new HomePage();
        loginPage = new LoginPage();
        defaultPage = new DefaultPage();

        try{
            homePage.homeLoginButton.click();
        }catch (Exception e){
        }

        try{
            defaultPage.userID.click();
            defaultPage.logOut.click();
            defaultPage.OK.click();
            homePage.homeLoginButton.click();
        }catch (Exception e){

        }
    }
//FLOW OF THE DATA 2d method returns the data -> : DataProvider looks for hte test method whose name iscustomer-login-data
//    -> Finds the Test method -> Passes the data to the test methods' parameter in order -> use that parameters in the test method
    @Test(dataProvider = "customer-login-data")
    public void customerLogin(String userName, String password) throws IOException {
        login();
        ReusableMethods.waitFor(1);
//        I want to get username with data provider
        loginPage.username.sendKeys(userName);
        ReusableMethods.waitFor(1);
//        I want to get password with data provider
        loginPage.password.sendKeys(password);
        ReusableMethods.waitFor(1);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(defaultPage.userID.isDisplayed());
        ReusableMethods.getScreenshot("ManagerLoginTest");
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }



}
