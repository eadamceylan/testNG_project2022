package techproed.tests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;
public class Day17_JSUtilsTest {
    @Test
    public void jsUtilsTest(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
//        Scrolling into about us element
        JSUtils.scrollIntoViewJS(Driver.getDriver().findElement(By.xpath("//a[.='About Us']")));
//        scrolling all the way up
        JSUtils.scrollAllUpByJS();
//        flash
        JSUtils.flash(Driver.getDriver().findElement(By.partialLinkText("Login")));

        Driver.closeDriver();
    }
}