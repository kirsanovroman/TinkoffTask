package Page;

import Elements.HeaderMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class BasePageClass {
    protected final WebDriver driver;

    protected BasePageClass(WebDriver driver) {
        this.driver=driver;
    }

//    public WebElement getElementByXpath(String locatorName) {
//        return  driver.findElement(By.xpath(locatorName));
//
//    }


    /**
     * Получение элемента по xPath
     * @param xPath
     * @return
     */
    public WebElement getElementByXpath(String xPath) {
        WebElement dynamicElement = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
        return dynamicElement;
    }

    /**
     * Выбор элемента headerMenu
     * @param headerMenuItem
     * @return
     */
    public PaymentsPage selectHeaderMenuItem(String headerMenuItem) {
        HeaderMenu headerMenu = new HeaderMenu(driver);
        headerMenu.selectHeaderMenuItem(headerMenuItem);
        return new PaymentsPage(driver);
    }

    /**
     * Получить строковое представление HTML страницы
     */
    public String getTinkoffPageSource() {
        return driver.getPageSource();
    }

}
