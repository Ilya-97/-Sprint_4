import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.practicum.MainPageObject;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class QuestionsAndAnswers extends TestMain{

        private WebDriver driver;
        @Test
        public void checkQA(){

                ChromeOptions options = new ChromeOptions();
                driver = new ChromeDriver(options);
                driver.get("https://qa-scooter.praktikum-services.ru/");
                new WebDriverWait(driver, 3)
                        .until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@class = 'Home_Header__iJKdX']")));




                MainPageObject objectFirst = new MainPageObject(driver);
                objectFirst.clickCookie();


                //Список вопросов
                String [] questions = {
                        "Сколько это стоит? И как оплатить?",
                        "Хочу сразу несколько самокатов! Так можно?",
                        "Как рассчитывается время аренды?",
                        "Можно ли заказать самокат прямо на сегодня?",
                        "Можно ли продлить заказ или вернуть самокат раньше?",
                        "Вы привозите зарядку вместе с самокатом?",
                        "Можно ли отменить заказ?",
                        "Я жизу за МКАДом, привезёте?"
                };

                //Список ответов
                String [] answers = {
                        "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                        "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                        "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                        "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                        "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                        "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                        "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                        "Да, обязательно. Всем самокатов! И Москве, и Московской области."
                };


                for (int i = 0; i < answers.length; i++){
                        assertThat(objectFirst.checkQuestionsText(i), containsString(questions[i]));
                        objectFirst.checkQuestionsAndAnswers(i);
                        assertThat(objectFirst.checkAnswersText(i), containsString(answers[i]));
                }

        }
        @After
        public void teardown() {
                // Закрой браузер
                driver.quit();
        }
}
