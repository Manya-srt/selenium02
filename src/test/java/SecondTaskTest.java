import Pages.BlanckPage;
import Pages.InsurancePage;
import Pages.MainPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class SecondTaskTest extends BaseTest {

    @Test
    public void InsuranceTest() throws Exception{
        driver.get(baseUrl);

        // Нажать на – Застраховать себя и имущество
        // Выбрать – Страхование путешественников
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Застраховать себя");
        mainPage.selectSubMenu("Страхование путешественников");

        //Проверить наличие на странице заголовка – Страхование путешественников
        InsurancePage insurancePage = new InsurancePage(driver);
        String actualTitle = insurancePage.title.getText();
        String expectedTitle = "Страхование путешественников";
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
        // Нажать на – Оформить Онлайн
        InsurancePage.appbutton.click();

        //Переключение экрана
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        // На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная
        InsurancePage.summa.click();
        //Нажать Оформить
        InsurancePage.button.click();

        // На вкладке Оформить заполнить поля:
        BlanckPage appPage = new BlanckPage(driver);
        BlanckPage.fillField("InsuredSurname","Smirnova");
        BlanckPage.fillField("InsuredName","Anna");
        BlanckPage.fillField("InsuredBirthdate","12.11.1990");
        BlanckPage.fillField("Surname","Смирнова");
        BlanckPage.fillField("Name","Олеся");
        BlanckPage.fillField("Middlename","Петровна");
        driver.findElement(By.name("birthDate")).click();
        BlanckPage.fillField("BirthDate","13.05.1987");
        driver.findElement(By.name("female")).click();
        BlanckPage.fillField("PassportSeries","5204");
        BlanckPage.fillField("PassportNumber","424578");
        BlanckPage.fillField("IssueDate","02.06.2014");
        BlanckPage.fillField("IssuePlace","ОУФМС России по г. Новосибирск");

        //Проверить, что все поля заполнены правильно
        Assert.assertEquals("Smirnova",BlanckPage.insured0surname.getAttribute("value"));
        Assert.assertEquals("Anna",BlanckPage.insured0name.getAttribute("value"));
        Assert.assertEquals("12.11.1990",BlanckPage.insured0birthdate.getAttribute("value"));
        Assert.assertEquals("Смирнова",BlanckPage.surname.getAttribute("value"));
        Assert.assertEquals("Олеся",BlanckPage.name.getAttribute("value"));
        Assert.assertEquals("Петровна",BlanckPage.middlename.getAttribute("value"));
        Assert.assertEquals("13.05.1987",BlanckPage.birthDate.getAttribute("value"));
        Assert.assertEquals("1",driver.findElement(By.name("female")).getAttribute("value"));
        Assert.assertEquals("5204",BlanckPage.passportseries.getAttribute("value"));
        Assert.assertEquals("424578",BlanckPage.passportnumber.getAttribute("value"));
        Assert.assertEquals("02.06.2014",BlanckPage.issuedate.getAttribute("value"));
        Assert.assertEquals("ОУФМС России по г. Новосибирск",BlanckPage.issueplace.getAttribute("value"));

        // Нажать продолжить
        BlanckPage.buttonclick.click();

        // Проверить, что появилось сообщение - Заполнены не все обязательные поля
        Wait<WebDriver> wait = new WebDriverWait(driver,10, 1000);
        WebElement alertText = driver.findElement(By.xpath("//div[text()='Заполнены не все обязательные поля']"));
        Assert.assertEquals("Заполнены не все обязательные поля",alertText.getText());
    }
}