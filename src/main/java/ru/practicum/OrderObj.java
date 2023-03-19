package ru.practicum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class OrderObj {
    public WebDriver driver;

    //Заголовок "Для кого самокат"
    private By orderHeader = By.xpath(".//div[@class = 'Order_Header__BZXOb' and text() = 'Для кого самокат']");
    //поле ввода имени
    private By inputName = By.xpath(".//input[@placeholder = '* Имя']");
    //поле ввода фамилии
    private By inputSurname = By.xpath(".//input[@placeholder = '* Фамилия']");
    //поле ввода адреса
    private By inputAdress = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    //поле ввода станции метро
    private By inputMetro = By.xpath(".//input[@placeholder = '* Станция метро']");
    //список станций метро
    private By stationList = By.className("select-search__select");
    //поле ввода телефона
    private By inputPhone = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    //поле даты доставки
    private By inputDate = By.xpath(".//input[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN']");
    //поле срока аренды
    private By inputArenda = By.xpath(".//div[@class = 'Dropdown-arrow-wrapper']/span[@class = 'Dropdown-arrow']");
    //чекбокс "черный жемчуг"
    //private By checkboxBlack = By.xpath(".//input[@id = 'black' and @type = 'checkbox']");
    //чекбокс "серая безысходность"
    //private By checkboxGray = By.xpath(".//input[@id = 'grey' and @type = 'checkbox']");
    //поле для комментария курьеру
    private By inputComment = By.xpath((".//input[@placeholder = 'Комментарий для курьера']"));
    //кнопка "Далее" на первом экране заказа
    private By firstNextButton = By.xpath(".//div[@class = 'Order_NextButton__1_rCA']/button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    //кнопка "Заказать" на втором экране
    private By orderFinishButton = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Заказать']");
    //кнопка "Да" подтверждения заказа во всплывающем окне
    private By orderFinishButtonConfirm = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Да']");
    //текст во всплывающем окне оформленного заказа
    private By orderCreatedPopUp = By.xpath("//div[text() = 'Заказ оформлен']");

    public OrderObj(WebDriver driver) {
        this.driver = driver;
    }

    //Метод заполнения первого экрана заказа
    public void setFirstTextFields(String name, String surname, String adress, String phone) {
        driver.findElement(inputName).sendKeys(name);
        driver.findElement(inputSurname).sendKeys(surname);
        driver.findElement(inputAdress).sendKeys(adress);
        driver.findElement(inputMetro).click();
        driver.findElement(stationList).click();

        driver.findElement(inputPhone).sendKeys(phone);
    }
    //Метод заполнения второго экрана заказа
    public void setSecondTextFields(String date, String arendaInput, String colour, String commentForCourier) {
        driver.findElement(inputDate).sendKeys(date);
        driver.findElement(inputArenda).click();
        driver.findElement(By.xpath(String.format(".//div[text() = '%s']", arendaInput))).click();
        driver.findElement(By.id(String.format("%s", colour))).click();
        driver.findElement(inputComment).sendKeys(commentForCourier);
    }

    //Клик на кнопку "Далее" на первой форме заполнения заказа
    public void clickNextButton() {
        driver.findElement(firstNextButton).click();
    }
    //Клик на кнопку "Заказать" на последнем экране
    public void clickFinishButton() {
        driver.findElement(orderFinishButton).click();
    }

    //Клик на кнопку "Да" подтверждения заказа во всплывающем окне
    public void clickApproveFinish () {
        driver.findElement(orderFinishButtonConfirm).click();
    }

    //Получение текста во всплывающем окне оформленного заказа
    public String confirmedOrderPopUp () {
        WebElement element = driver.findElement(orderCreatedPopUp);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        return driver.findElement(orderCreatedPopUp).getText();
    }













    }
