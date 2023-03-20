
    import org.junit.After;
    import org.junit.Before;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.chrome.ChromeOptions;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;

    public class TestMain {
        WebDriver driver;
        @Before
        public void startUp(){
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            driver.get("https://qa-scooter.praktikum-services.ru/");
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[text() ='Заказать']")));
        }

        @After
        public void teardown() {
            // Закрой браузер
            driver.quit();
        }
    }
