package Elements;

import Page.PaymentsPage;
import org.openqa.selenium.WebDriver;

public class HeaderMenu extends BaseElementsClass {
    WebDriver driver;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    /**
     * Выбор элемента headerMenu
     * @param headerMenuItem
     * @return
     */
    public void selectHeaderMenuItem(String headerMenuItem) {
        getElementByXpath("//li[@data-qa-file='HeaderMenuItem']//span[contains(text(),'" + headerMenuItem + "')]").click();
    }

}
