package techproed.tests.dataprovider;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.DefaultPage;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtil;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

public class Day18_DataProvider3 {
    HomePage homePage;
    LoginPage loginPage;
    DefaultPage defaultPage;
    @DataProvider(name = "customer-login-data" )
    public Object [][] dataProviderMethod(){
//        This method will read the data from Excel sheet mysmoketest
//        path of excel sheet
        String path = ".\\src\\test\\java\\resources\\mysmoketestdata.xlsx";
//        Sheet name
        String customerSheet = "customer_info";
//        Read the data from excel
        ExcelUtil excelUtil = new ExcelUtil(path,customerSheet);
        Object [][] customerCredentials = excelUtil.getDataArrayWithoutFirstRow();
        return customerCredentials;
    }
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
    @Test (dataProvider =  "customer-login-data" )
    public void customerLogin(String username, String password) throws IOException {
        login();
        ReusableMethods.waitFor(1);
        loginPage.username.sendKeys(username);
        ReusableMethods.waitFor(1);
        loginPage.password.sendKeys(password.substring(0,5));
        ReusableMethods.waitFor(1);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(1);

        Assert.assertTrue(defaultPage.userID.isDisplayed());

        ReusableMethods.getScreenshot("LoginWithDataProvider");
    }
}
