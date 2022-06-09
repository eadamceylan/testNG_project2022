package techproed.tests.excelautomation;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.DefaultPage;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtil;
import techproed.utilities.ReusableMethods;
import java.io.IOException;
import java.util.List;
import java.util.Map;
public class Day17_ExcelLogin {
    HomePage homePage;
    LoginPage loginPage;
    DefaultPage defaultPage;
    ExcelUtil excelUtil;
    //    We will store excel data in this list
    List<Map<String, String>> testData;
    public void login(){
//        going to the home page url
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
//        initiating pages
        homePage = new HomePage();
        loginPage = new LoginPage();
        defaultPage = new DefaultPage();
        try{
//            clinking on the homelogin button
//            homepage login is only visible at the first login
//            We should put this in try catch block, to catch the exception after 1st login
//            If I do not use this, then I will get NoSuchElementException after the first login
            homePage.homeLoginButton.click();
        }catch (Exception e){
//            e.printStackTrace();
        }
        try{
//            After the 1st login, I need to log out
//            In the first login logout is not then
//            So I need to use try catch to catch the exception in the 1st login
//            If I do not use this, then I will get NoSuchElementException after the first login
            defaultPage.userID.click();
            defaultPage.logOut.click();
            defaultPage.OK.click();
            homePage.homeLoginButton.click();
        }catch (Exception e){
        }
    }
    @Test
    public void customerLogin() throws IOException {
//        path of the excel sheet
        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
//        customer data sheet
        String customerSheet="customer_info";
//        Use ExcelUtil to
        excelUtil= new ExcelUtil(path,customerSheet);
//        getting the data and storing in the test-data variable
        testData=excelUtil.getDataList();
//        System.out.println(testData);
        for (Map<String, String> eachData:testData){
//            System.out.println(eachData);
            login();
            ReusableMethods.waitFor(2);
            loginPage.username.sendKeys(eachData.get("username"));
            ReusableMethods.waitFor(2);
            loginPage.password.sendKeys(eachData.get("password").substring(0,5));
            ReusableMethods.waitFor(2);
            loginPage.loginButton.click();
            ReusableMethods.waitFor(2);
//            Assertion
            Assert.assertTrue(defaultPage.userID.isDisplayed());
//            Take a screenshot
            ReusableMethods.getScreenshot("ManagerLoginTest");
        }
//
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
