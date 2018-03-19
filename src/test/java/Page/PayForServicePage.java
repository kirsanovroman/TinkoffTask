package Page;

import Elements.HeaderMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PayForServicePage extends BasePageClass {
    public PayForServicePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Выбор вкладки на странице оплаты коммунальных платежей
     * @param nameOfTab
     */
    public void selectTab(String nameOfTab) {
        getElementByXpath("//ul[@data-qa-file='Tabs']//span[contains(text(),'"+nameOfTab+"')]").click();
    }

    /**
     * Ввод значения в поле
     */
    public void inputValue(String value,String nameField) {
        WebElement webElement=getElementByXpath("//div[@data-qa-file='UIPageFrame']//span[span[contains(text(),'"+nameField+"')]]//preceding-sibling::input");
        webElement.clear();
        webElement.sendKeys(value+Keys.ENTER);
    }

    /**
     * Ввод значения в специализированное поле
     */
    public void inputValueInSpecialField(String value,String nameField) {
        WebElement webElement=getElementByXpath("//div[@data-qa-file='UIPageFrame']//label[span[contains(text(),'"+nameField+"')]]//input");
        webElement.clear();
        webElement.sendKeys(value+Keys.ENTER);
    }

    /**
     * Получить описание ошибки при вводе для поля
     * @param nameField
     * @return
     */
    public String getErrorDescription(String nameField) {
        return getElementByXpath("//div[.//span[contains(text(),'" + nameField + "')]]/following-sibling::div[@data-qa-file='UIFormRowError']").getText();
    }


}
