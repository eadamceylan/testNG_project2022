package techproed.tests.excelautomation;

import org.testng.annotations.Test;
import techproed.pages.DefaultPage;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtil;

import java.util.List;
import java.util.Map;

public class Day17_ExcelLoginReview {

    HomePage homePage;
    LoginPage loginPage;
    DefaultPage defaultPage;
    ExcelUtil excelUtil;

    //    we will store excel data in this list
    List<Map<String, String>> testData;

    public void login(){
//          Go to the url
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
//        initialize objects
        homePage = new HomePage();
        loginPage = new LoginPage();
        defaultPage = new DefaultPage();
        homePage.homeLoginButton.click();

    }


    @Test
    public void customerLogin(){
//       path of Excel file
        String path = ".\\src\\test\\java\\resources\\mysmoketestdata.xlsx";

//        customer data sheet from mysmoketest excel file
        String customerSheet = "customer_info";

//        use  excelUtil
        excelUtil = new ExcelUtil(path,customerSheet);

//        get and store the data from excel sheet
        testData = excelUtil.getDataList();

//        System.out.println(testData);



//        login();
    }



}