import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.BeforeSuite;
import org.apache.commons.exec.CommandLine;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    public static WebDriver driver;
    @BeforeScenario
    public static void baslangic()
    {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-popup-blocking");  //pop-up bloklaması
        chromeOptions.addArguments("--disable-plugins"); //chrome pluginler , driver bazlı pluginler durdurulur
        chromeOptions.addArguments("--disable-plugins-discovery");   //flash dahil tüm pluginler durdurulur
        chromeOptions.addArguments("--disable-preconnect");   //google ın dns çözümlemesi nedeniyle oluşabilecek performans düşüklüğünü engeller
        chromeOptions.addArguments("--disable-notifications");   // bildirimleri engeller
        //driver.get("https://www.hepsiburada.com");
        driver.manage().window().maximize();
    }
    @AfterScenario
    public static void bitis(){
        driver.quit();
    }
}
