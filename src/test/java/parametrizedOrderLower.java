import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.practicum.MainPageObject;
import ru.practicum.OrderObj;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class parametrizedOrderLower extends TestMain{
    private final String name;
    private final String surname;
    private final String adress;
    private final String station;
    private final String phone;
    private final String date;
    private final String arenda;
    private final String colour;
    private final String comment;


    public parametrizedOrderLower(String name, String surname, String adress, String station, String phone, String date, String arenda, String colour, String comment) {
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.station = station;
        this.phone = phone;
        this.date = date;
        this.arenda = arenda;
        this.colour = colour;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getData(){
        return new Object[][]{
                {"Игорь", "Иванов", "Москва", "Университет", "89351400202", "25.03.2023", "сутки", "grey", "Тестовый комментарий для курьера"},
                {"Зинаида", "Марковна", "Москва", "Выхино", "89031400171", "24.03.2023", "двое суток", "black", "╭━━━╮┈┈╱╲┈┈┈╱╲\n" +
                        "┃╭━━╯┈┈▏▔▔▔▔▔▏\n" +
                        "┃╰━━━━━▏╭▆┊╭▆▕\n" +
                        "╰┫╯╯╯╯╯▏╰╯▼╰╯▕\n" +
                        "┈┃╯╯╯╯╯▏╰━┻━╯▕\n" +
                        "┈╰┓┏┳━┓┏┳┳━━━━╯\n" +
                        "┈┈┃┃┃┈┃┃┃┃┈┈┈┈\n" +
                        "┈┈┗┻┛┈┗┛┗┛┈┈┈┈"},

        };
    }

    @Test
    public void ParametrizedCheckTest(){

        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[text() ='Заказать']")));

        MainPageObject mainPageObject = new MainPageObject(driver);
        mainPageObject.clickOrderLower();
        OrderObj orderObj = new OrderObj(driver);
        orderObj.setFirstTextFields(name, surname, adress, phone);
        orderObj.clickNextButton();
        orderObj.setSecondTextFields(date, arenda, colour, comment);
        orderObj.clickFinishButton();
        orderObj.clickApproveFinish();
        assertThat(orderObj.confirmedOrderPopUp(), containsString("Номер заказа"));
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
