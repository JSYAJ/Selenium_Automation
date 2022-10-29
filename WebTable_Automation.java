package Basic_Concepts;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC03 {

	WebDriver D;
	String url = "http://10.82.180.36/Common/Login.aspx";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\jignesh.yadav\\Downloads\\chromedriver_win32\\chromedriver.exe");
		D = new ChromeDriver();
		D.get(url);
		D.manage().window().maximize();

	}

	@After
	public void tearDown() throws Exception {
		D.close();
		D.quit();
	}

	@Test
	public void test() {

		D.findElement(By.id("body_txtUserID")).sendKeys("donhere");
		D.findElement(By.name("ctl00$body$txtPassword")).sendKeys("don@123");
		D.findElement(By.className("buttonStyle")).click();

		String title = D.getTitle();
		System.out.println(title);

		WebElement acc_det_table = D.findElement(By.id("body_cph_MyAccount_gvAccountDetails"));

		List<WebElement> rows = acc_det_table.findElements(By.tagName("tr"));
		System.out.println("No. of row is " + rows.size());

		
		for (WebElement row : rows) {
		 
		  List<WebElement> cols=row.findElements(By.tagName("td")); for (WebElement col
		  : cols) { System.out.println("Colume values is : "+col.getText()); } }
		
		 D.findElement(By.id("lbLoginOut")).click();

	}

}
