import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class FKartAutomate {

	static WebDriver driver;
	public static void main(String[] args) {
		
		FKartAutomate auto = new FKartAutomate();
		
		auto.launchBrowser();
		auto.launchWeb();
		auto.searchProd();
		auto.searchFilter();

	}
	
	// method browser
	public void launchBrowser(){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Select the Browser: 1.Chrome (ch) 2. Microsoft Edge (ME) ");
		String browser = sc.next();
		
		
		//STEP 1:- Selection of browser
		if(browser.equalsIgnoreCase("CH")){
			System.out.println("ExplorerDriver execution on Windows!!");
			/* Defining the property webdriver.ie.driver */
			System.setProperty("webdriver.ie.driver", "E:\\Cognizant\\JAR & Driver Folders\\IEDriverServer.exe");
			/* Instantiate the edge Driver Class */
			driver = new InternetExplorerDriver();
			
			driver.get("https://www.google.com/");
			System.out.println("Window opened sucessfully");
	
			driver.close();
			System.out.println("Window closed sucessfully");
		}
		else if(browser.equalsIgnoreCase("ME")){
			System.out.println("EdgeDriver execution on Windows!!");
			/* Defining the property webdriver.edge.driver */ //E:\Cognizant\JAR & Driver Folders
			System.setProperty("webdriver.edge.driver", "E:\\Cognizant\\JAR & Driver Folders\\msedgedriver.exe");
			/* Instantiate the EDGE Driver Class */
			driver = new EdgeDriver();
		}
		else{
			
			System.out.println("Incorrect selection of browser.");
			driver.close();
		}
	}
		// Method for website launch
	public void launchWeb(){
			
			// STEP 2 :- Open the online shopping website.
			driver.get("https://www.flipkart.com/");
			System.out.println("Window opened successfully");
				
			//STEP 3:- Close the Pop-up window.
			WebElement close = driver.findElement(By.xpath("/html/body/div[2]/div/div/button"));
			close.click();
			System.out.println("Pop up Window closed successfully");
		}
	// method to search the product
	public void searchProd(){
		
		// STEP 4:-
		// Enter 'mobile' in search bar.
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("mobiles");
		search.sendKeys(Keys.ENTER);
		System.out.println("Enter name successfully");
					
		// Click on search icon.
		//WebElement searchClick = driver.findElement(By.className("L0Z3Pu"));
		//searchClick.click();
		//System.out.println("clicked search button successfully");
	}

	// method for filter the search product
	public void searchFilter(){
		
		driver.findElement(By.xpath("//div[@class='_3uDYxP']//select[@class='_2YxCDZ']")).click();
		System.out.println("drop-downselected");
	}
		


	
}

