package authentication_Scenarios.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
    public JavascriptExecutor jse ;
    public Select select ;
    public Actions action ;

    protected WebDriver driver; //working with element , this will deal actuilly with elments
    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this); //working with pom and is a paramter pass to bagepase
    }
    public void clickOnButton(WebElement button)
    {
        button.click();

    }
    public void setValueOnField(WebElement textfield,String value)
    {
        textfield.sendKeys(value);

    }
    public void scrollToBottom()

    {
        jse.executeScript("scrollBy(0,2500)");
    }

    public void clearText(WebElement element)
    {
        element.clear();
    }

}
