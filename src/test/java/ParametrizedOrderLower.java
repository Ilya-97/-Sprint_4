import org.junit.Test;
    import org.junit.runner.RunWith;
    import org.junit.runners.Parameterized;
import ru.practicum.MainPageObject;
    import ru.practicum.OrderObj;
    import static org.hamcrest.CoreMatchers.containsString;
    import static org.hamcrest.MatcherAssert.assertThat;

    @RunWith(Parameterized.class)
    public class ParametrizedOrderLower extends TestMain{
        private final String name;
        private final String surname;
        private final String adress;
        private final String station;
        private final String phone;
        private final String date;
        private final String arenda;
        private final String colour;
        private final String comment;

        public ParametrizedOrderLower(String name, String surname, String adress, String station, String phone, String date, String arenda, String colour, String comment) {
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
    }
