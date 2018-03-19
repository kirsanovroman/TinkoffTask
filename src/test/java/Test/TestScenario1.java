package Test;

import Page.HomePage;
import Page.PayForServicePage;
import Page.PaymentsPage;
import Page.PublicServicePage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class TestScenario1 extends BaseTestClass {

    public void testScenario1() throws InterruptedException {
        /*
        Пререквизиты для выполнения тестовых наборов
         */
        getTinkoffHomePage("https://www.tinkoff.ru/");
        HomePage homePage = new HomePage(driver);
        PaymentsPage paymentsPage = homePage.selectHeaderMenuItem("Платежи");
        PublicServicePage publicService=paymentsPage.selectUIMenuItem("ЖКХ");
        String nameOfService=publicService.getTitleOfPublicService(1);
        PayForServicePage payForServicePage = publicService.selectPublicService(nameOfService);
        Thread.sleep(3000);
        String pageSource = payForServicePage.getTinkoffPageSource();
        payForServicePage.selectTab("Оплатить ЖКУ в Москве");


        /*
        Проверка невалидных значений для поля "За какой период оплачиваете коммунальные услуги"
         */
        String fieldName="За какой период оплачиваете коммунальные услуги";
        //Тест-кейс 2.1
        payForServicePage.inputValue("142017",fieldName);
        Assert.assertEquals(payForServicePage.getErrorDescription(fieldName),"Поле заполнено некорректно");
        //Тест-кейс 2.2
        payForServicePage.inputValue("11",fieldName);
        Assert.assertEquals(payForServicePage.getErrorDescription(fieldName),"Поле заполнено некорректно");
        //Тест-кейс 2.3
        payForServicePage.inputValue("11903",fieldName);
        Assert.assertEquals(payForServicePage.getErrorDescription(fieldName),"Поле заполнено некорректно");
        //Тест-кейс 2.4
        payForServicePage.inputValue(" ",fieldName);
        Assert.assertEquals(payForServicePage.getErrorDescription(fieldName),"Поле обязательное");


        /*
        Проверка невалидных значений для поля "Код плательщика за ЖКУ в Москве"
         */
        fieldName="Код плательщика за ЖКУ в Москве";
        //Тест-кейс 1.1
        payForServicePage.inputValue(" ",fieldName);
        Assert.assertEquals(payForServicePage.getErrorDescription(fieldName),"Поле обязательное");
        //Тест-кейс 1.2
        payForServicePage.inputValue("1",fieldName);
        Assert.assertEquals(payForServicePage.getErrorDescription(fieldName),"Поле неправильно заполнено");
        //Тест-кейс 1.3
        payForServicePage.inputValue("123456789",fieldName);
        Assert.assertEquals(payForServicePage.getErrorDescription(fieldName),"Поле неправильно заполнено");


        /*
        Проверка невалидных значений для поля "Сумма платежа"
         */
        fieldName="Сумма платежа";
        //Тест-кейс 3.1
        payForServicePage.inputValueInSpecialField(" ",fieldName);
        Assert.assertEquals(payForServicePage.getErrorDescription(fieldName),"Поле обязательное");
        //Тест-кейс 3.2
        payForServicePage.inputValueInSpecialField("**()/",fieldName);
        Assert.assertEquals(payForServicePage.getErrorDescription(fieldName),"Поле заполнено неверно");
        //Тест-кейс 3.3
        payForServicePage.inputValueInSpecialField("-30",fieldName);
        Assert.assertEquals(payForServicePage.getErrorDescription(fieldName),"Поле заполнено неверно");
        //Тест-кейс 3.4
        payForServicePage.inputValueInSpecialField("9,9949",fieldName);
        Assert.assertEquals(payForServicePage.getErrorDescription(fieldName),"Минимальная сумма перевода — 10 \u20BD");
        //Тест-кейс 3.4
        payForServicePage.inputValueInSpecialField("15000,005",fieldName);
        Assert.assertEquals(payForServicePage.getErrorDescription(fieldName),"Максимальная сумма перевода — 15 000 \u20BD");


        /*
         Проверка номера строки искомого поставщика в выпадающем списке в строке быстрого поиска
         Тест-кейс 4
         */
        payForServicePage.selectHeaderMenuItem("Платежи");
        paymentsPage.searchInput(nameOfService);
        Assert.assertEquals(paymentsPage.checkFirstItemInDropDownList(),nameOfService);


        /*
        Проверка соответствия страницы оплаты ЖКХ
        Тест-кейс 5
         */
        PayForServicePage payForServicePage1= paymentsPage.selectInDropDown(nameOfService);
        Thread.sleep(3000);
        String pageSource2 = payForServicePage1.getTinkoffPageSource();
        Assert.assertNotEquals(pageSource,pageSource2);


        /*
        Проверка отсутствия искомого поставщика в списке поставщиков для региона
        Тест-кейс 6
         */
        payForServicePage.selectHeaderMenuItem("Платежи");
        paymentsPage.selectUIMenuItem("ЖКХ");
        publicService.changeCurrentRegion("г. Санкт-Петербург");
        Thread.sleep(3000);
        Assert.assertFalse(publicService.checkPresenceOfPublicServiceOnPage(nameOfService),"Ошибка!Элемент присутствует");
    }
}
