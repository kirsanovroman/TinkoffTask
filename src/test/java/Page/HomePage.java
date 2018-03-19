package Page;

import Elements.HeaderMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageClass {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Выбор элемента headerMenu
     * @param headerMenuItem
     * @return
     */
    @Override
    public PaymentsPage selectHeaderMenuItem(String headerMenuItem) {
        getElementByXpath("//li[@data-qa-file='MenuItem']//span[contains(text(),'" + headerMenuItem + "')]").click();
        return new PaymentsPage(driver);
    }

}
