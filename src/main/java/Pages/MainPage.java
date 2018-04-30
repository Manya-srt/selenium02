package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'bp-area header_more_nav')]")
    WebElement mainMenu;

    @FindBy(xpath = "//div[contains(@class,'header-container')]//li[5]//div[contains(@class,'alt-menu-collapser__hidder')]")
    WebElement subMenu;

    public MainPage(WebDriver driver){

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void selectMainMenu(String menuItem){
        mainMenu.findElement(By.xpath(".//span[contains(text(),'" + menuItem + "')]")).click();
    }

    public void selectSubMenu(String menuItem){
        subMenu.findElement(By.xpath(".//a[contains(text(),'" + menuItem + "')]")).click();
    }
}
