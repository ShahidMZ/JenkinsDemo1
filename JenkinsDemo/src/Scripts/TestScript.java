package Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestScript
{
	static WebDriver driver;
	
	@Test
	public void Test1()
	{
		System.out.println("Execution");
		
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080/petstoreWeb/");
		
		driver.findElement(By.id("enter")).click();
		driver.findElement(By.cssSelector("a[href*='/petstoreWeb/shop/viewCategory.do?catId=FISH']")).click();
		driver.findElement(By.cssSelector("a[href*='/petstoreWeb/shop/viewProduct.do?productId=FI-FW-01']")).click();
		driver.findElement(By.cssSelector("a[href*='/petstoreWeb/shop/addItemToCart.do?workingItemId=EST-4']")).click();
		driver.findElement(By.cssSelector("a[href*='/petstoreWeb/shop/checkout.do']")).click();
		driver.findElement(By.cssSelector("a[href*='/petstoreWeb/checkout/createNewOrder.do']")).click();
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		
		Select select = new Select(driver.findElement(By.name("wlw-select_key:{actionForm.order.cardType}")));
		select.selectByVisibleText("MasterCard");
		
		driver.findElement(By.name("{actionForm.order.creditCard}")).sendKeys("1234567890");
		driver.findElement(By.name("{actionForm.order.exprDate}")).sendKeys("12/2022");
		driver.findElement(By.name("wlw-radio_button_group_key:{actionForm.order.billingAddress}")).click();
		driver.findElement(By.name("wlw-radio_button_group_key:{actionForm.order.shippingAddress}")).click();
		driver.findElement(By.cssSelector("a[href*='/petstoreWeb/checkout/viewConfirm.do']")).click();
		driver.findElement(By.cssSelector("a[href*='/petstoreWeb/checkout/confirm.do']")).click();
		driver.findElement(By.cssSelector("a[href*='/petstoreWeb/checkout/viewOrders.do']")).click();
		driver.findElement(By.cssSelector("a[href*='/petstoreWeb/account/edit/rootSharedFlow.globalShop.do']")).click();
	}
}
