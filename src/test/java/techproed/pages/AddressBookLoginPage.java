package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class AddressBookLoginPage {

    public AddressBookLoginPage(){
//        PageFactory is used for initializing the page object
//        Each page class should have this class
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id = "session_email")
    public WebElement username;

    @FindBy(id="session_password")
    public WebElement password;

    @FindBy(xpath = "//input[@name='commit']")
    public WebElement loginButton;




}
