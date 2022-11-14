import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class Hepsiburada extends BaseTest{

    @Step("Hepsiburada Anasayfa ac")
    public void homePage()throws InterruptedException{
        driver.get("https://www.hepsiburada.com");
        Thread.sleep(1000);
    }

    @Step("<ClassName> li elemente tıkla")
    public void click(String ClassName) throws InterruptedException {
        driver.findElement(By.className(ClassName)).click();
        Thread.sleep(1000);
    }

    @Step("<xpath> xpath li elemente  tıkla")
    public void clickXpath(String xpath) throws InterruptedException {
        driver.findElement(By.xpath(xpath)).click();
        Thread.sleep(1000);
    }

    @Step("<ClassName> li elemente <key> degerini yaz")
    public void setByValue(String ClassName, String key)throws InterruptedException{
        driver.findElement(By.className(ClassName)).sendKeys(key);
        Thread.sleep(1000);
    }

    @Step("<css> li listeden bir ürün sec")
    public void chooseProduct(String css) throws InterruptedException{
        Random random = new Random();
        List<WebElement> products = driver.findElements(By.cssSelector(css)); //listeye attık
        int index = random.nextInt(products.size());
        products.get(index).click();
        Thread.sleep(1000);
    }

    @Step("yeni sekmeye geçiş")
    public void chromeFocusLastTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    @Step("<css> elementine git ve tıkla")
    public void goToComments(String css) throws InterruptedException{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.cssSelector(css)));
        driver.findElement(By.cssSelector(css)).click();
        Thread.sleep(1000);
    }


    //public By wwwe = By.cssSelector(".thumbsUp");
    //@Step("ilk yoruma git ve evet butonuna tıkla") => POM modelinde yapsaydık stepleri bu şeilde verecektik
    @Step("<css> li listeden <number> numaralı ürünü seç")
    public void goToFirstComment(String css, Integer x) throws InterruptedException{
        Random random = new Random();
        List<WebElement> products = driver.findElements(By.cssSelector(css));
        //int index = random.nextInt(products.size());
        products.get(x).click();
        Thread.sleep(200);
    }


    @Step("<xpath> li element <text> text değerini içeriyor mu")
    public void textPathControl(String id,String text) throws InterruptedException{
        Assert.assertTrue("Element bulunamadı", driver.findElement(By.xpath(id)).getText().equals(text));
        Thread.sleep(1000);
    }


}
