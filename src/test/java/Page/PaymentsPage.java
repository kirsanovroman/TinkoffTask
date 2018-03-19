package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentsPage extends BasePageClass {
    public PaymentsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Выбор категории платежа
     * @param item
     * @return
     */
    public PublicServicePage selectUIMenuItem(String item) {
        getElementByXpath("//li[@data-qa-file='UIMenuItemProvider']//a[@title='" + item + "']").click();
        return new PublicServicePage(driver);
    }

    /**
     * Поиск поставщика услуг
     * @param value
     */
    public void searchInput(String value) {
        getElementByXpath("//input[@data-qa-file='SearchInput']").sendKeys(value);
    }

    /**
     * Выбор поставщика услуг из выпадающего списка
     * @param item
     * @return
     */
    public PayForServicePage selectInDropDown(String item) {
        getElementByXpath("//div[contains(text(),'"+item+"')]").click();
        return new PayForServicePage(driver);
    }

    /**
     * Проверка первого элемента в выпадающем списке
     */
    public String checkFirstItemInDropDownList() {
       return getElementByXpath("//div[@data-qa-file='SuggestBlock'][1]//div[@data-qa-file='GridColumn'][1]/div/div[1]/div[1]").getText();
    }
}
