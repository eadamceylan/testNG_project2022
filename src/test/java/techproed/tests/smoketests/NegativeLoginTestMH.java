package techproed.tests.smoketests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.HotelHomePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class NegativeLoginTestMH {

    HotelHomePage hotelHomePage = new HotelHomePage();

    @Test
    public void NegativeLoginTest(){


    //    Bir test method olustur positiveLoginTest()
//    https://www.hotelmycamp.com/ adresine git
      Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));
//    login butonuna bas
      hotelHomePage.hotelHomeLoginButton.click();
//    test data username: manager ,
        hotelHomePage.hotelEmailTextBox.sendKeys(ConfigReader.getProperty("hotelInvalidUsername"));
//    test data password : Manager1!
        hotelHomePage.hotelPasswordTestBox.sendKeys(ConfigReader.getProperty("hotelInvalidPassword"));
//    Login butonuna bas
        hotelHomePage.hotelSecondLoginButton.click();
    //    Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(hotelHomePage.hotelSecondLoginButton.isDisplayed());
}
   }