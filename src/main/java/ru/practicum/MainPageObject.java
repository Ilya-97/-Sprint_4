    package ru.practicum;

    import org.openqa.selenium.By;
    import org.openqa.selenium.JavascriptExecutor;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    public class MainPageObject {
        public WebDriver driver;

        //локатор кнопки "да все привыкли"
        private By cookieButton = By.className("App_CookieButton__3cvqF");

        //локатор верхней кнопки "Заказать"
        private By orderUpper = By.xpath(".//div[@class = 'Header_Nav__AGCXC']/button[@class = 'Button_Button__ra12g']");

        //локатор нижней кнопки "Заказать"
        private By orderLower = By.xpath(".//div[@class = 'Home_FinishButton__1_cWm']/button[@class = 'Button_Button__ra12g Button_UltraBig__UU3Lp']");

        public MainPageObject(WebDriver driver){
            this.driver = driver;
        }

        //нажатие на кнопку "да все привыкли"
        public void clickCookie(){
            WebElement element = driver.findElement(cookieButton);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.findElement(cookieButton).click();
        }

        //Нажатие на верхнюю кнопку "Заказать"
        public void clickOrderUpper(){
            driver.findElement(orderUpper).click();
        }
        //Нажатие на нижнюю кнопку "Заказать"
        public void clickOrderLower(){
            WebElement element = driver.findElement(orderUpper);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.findElement(orderUpper).click();
        }

        //поиск и проверка открытия вопросов и ответов
        public void checkQuestionsAndAnswers(int rowCount){
            WebElement element =   driver.findElement(By.id(String.format("accordion__heading-%d", rowCount)));
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.findElement(By.id(String.format("accordion__heading-%d", rowCount))).click();
        }
        //поиск и проверка текста в заголовке вопросов
        public String checkQuestionsText(int rowCount){
            return driver.findElement(By.id(String.format("accordion__heading-%d", rowCount))).getText();
        }
        //поиск и проверка текста выпадающих ответов
        public String checkAnswersText(String text){
            return driver.findElement(By.xpath(String.format(".//p[text() = '%s']", text))).getText();
        }


    }
