package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

 public abstract class BaseElementsClass  {
    public final WebDriver driver;
    public BaseElementsClass(WebDriver driver){
        this.driver=driver;
     }


     /**
      * Получение элемента по xPath
      * @param xPath
      * @return
      */
    public WebElement getElementByXpath(String xPath) {
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
        return dynamicElement;
    }
}
