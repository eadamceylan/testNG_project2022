package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class HotelHomePage {

    public HotelHomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Log in']")
    public WebElement hotelHomeLoginButton;

    @FindBy(xpath = "//*[@class='form-control required']")
    public WebElement hotelEmailTextBox;

    @FindBy(xpath = "//*[@class='form-control required password']")
    public WebElement hotelPasswordTestBox;

    @FindBy(id = "btnSubmit")
    public WebElement hotelSecondLoginButton;

    @FindBy(xpath = "//span[@class='username username-hide-on-mobile']")
    public WebElement managerElement;

}

