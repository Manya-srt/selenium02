package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlanckPage extends BasePage {
    @FindBy(xpath = "//span [contains(text(),'Оформление')]" )
    public WebElement blanck;

    @FindBy(name = "insured0_surname")
    public static WebElement insured0surname;

    @FindBy(name = "insured0_name")
    public static WebElement insured0name;

    @FindBy(name = "insured0_birthDate")
    public static WebElement insured0birthdate;

    @FindBy(name = "surname")
    public static WebElement surname;

    @FindBy(name = "name")
    public static WebElement name;

    @FindBy(name = "middlename")
    public static WebElement middlename;

    @FindBy(name = "birthDate")
    public static WebElement birthDate;

    @FindBy(name = "female")
    public static WebElement female;

    @FindBy(name = "passport_series")
    public static WebElement passportseries;

    @FindBy(name = "passport_number")
    public static WebElement passportnumber;

    @FindBy(name = "issueDate")
    public static WebElement issuedate;

    @FindBy(name = "issuePlace")
    public static WebElement issueplace;

    @FindBy(xpath = "//span[contains(text(),'Продолжить')]" )
    public static WebElement buttonclick;

    @FindBy(xpath = "//div [text()='Заполнены не все обязательные поля']" )
    public WebElement alertText;

    public BlanckPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver,10, 1000);
        wait.until(ExpectedConditions.visibilityOf(blanck));
        wait.until(ExpectedConditions.visibilityOf(buttonclick));
    }

       public static void fillField(String fieldName, String value){
        switch (fieldName){
            case "InsuredSurname": fillField(insured0surname, value);
                break;
            case "InsuredName": fillField(insured0name, value);
                break;
            case "InsuredBirthdate": fillField(insured0birthdate, value);
                break;
            case "Surname": fillField(surname, value);
                break;
            case "Name": fillField(name, value);
                break;
            case "Middlename": fillField(middlename, value);
                break;
            case "BirthDate": fillField(birthDate, value);
                break;
            case "Female": fillField(female, value);
                break;
            case "PassportSeries": fillField(passportseries, value);
                break;
            case "PassportNumber": fillField(passportnumber, value);
                break;
            case "IssueDate": fillField(issuedate, value);
                break;
            case "IssuePlace": fillField(issueplace, value);
                break;
            default: throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }
}
