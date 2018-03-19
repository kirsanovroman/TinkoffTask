package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class PublicServicePage extends BasePageClass {
    public PublicServicePage(WebDriver driver) {
        super(driver);
    }

    /**
     *Получить загаловок поставщика услуг по номеру в списке
     * @param numberOfServiceInList
     * @return
     */
    public String getTitleOfPublicService(int numberOfServiceInList) {
        return getElementByXpath("//ul[@data-qa-file='UIScrollList']/li["+numberOfServiceInList+"]/span[2]//span").getText();
    }

    /**
     * Выбрать поставщика услуг из списка
     * @param title
     * @return
     */
    public PayForServicePage selectPublicService(String title) {
        getElementByXpath("//span[contains(text(),'" + title + "')]").click();
        return new PayForServicePage(driver);
    }

    /**
     * Проверка региона
     * @param region
     * @return
     */
    public boolean checkCurrentRegion(String region) {
        return false;
    }

    /**
     * Смена региона
     * @param newRegion
     */
    public void changeCurrentRegion(String newRegion) {
        getElementByXpath("//div[contains(text(),'ЖКХ')]/span/span/span").click();
        getElementByXpath("//div[@data-qa-file='UIRegions']//span[text()='"+newRegion+"']").click();
    }

    /**
     * Проверка наличия поставщика услуг на странице выбора поставщика услуг
     * @param publicService
     * @return
     */
    public boolean checkPresenceOfPublicServiceOnPage(String publicService) {
        try {
            driver.findElement(By.xpath("//span[contains(text(),'" + publicService + "')]"));
//            System.out.println("//span[contains(text(),'" + publicService + "')]");
            return true;
        } catch (NoSuchElementException e) {
//            System.out.println("//span[contains(text(),'" + publicService + "')]");
            return false;
        }

    }
}

