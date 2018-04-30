package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsurancePage extends BasePage {

    @FindBy(xpath = "//div[@class='sbrf-rich-outer']/*[contains(text(),'Страхование путешественников')]")
    public WebElement title;

    @FindBy(xpath = "//a//img[contains(@src,'banner-zashita-traveler')]")
    public static WebElement appbutton;

    @FindBy(xpath = "//div[contains(text(),'Минимальная')]")
    public static WebElement summa;

    @FindBy(xpath = "//span[contains(text(),'Оформить')]")
    public static WebElement button;

    public InsurancePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        Wait<WebDriver> wait = new WebDriverWait(driver,10, 1000);
        wait.until(ExpectedConditions.visibilityOf(title));
    }


}


