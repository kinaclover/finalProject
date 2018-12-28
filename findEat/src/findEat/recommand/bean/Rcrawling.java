package findEat.recommand.bean;

import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Rcrawling {
	private WebDriver driver;
	
	@Before(value = "")
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/driver/chromedriver"); // �ٿ���� ChromeDriver ��ġ�� �־��ݴϴ�.
        driver = new ChromeDriver(); // Driver ����
    }
}
