package Selenium;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumExceptions {
	// Global variable declared
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
	
		SeleniumExceptions seleniumExceptions = new SeleniumExceptions();
		seleniumExceptions.Nosuchelementexception();
		seleniumExceptions.NoSuchWindowException();
		seleniumExceptions.NoSuchFrameException();
		seleniumExceptions.NoAlertPresentException();
		seleniumExceptions.InvalidSelectorException();
		seleniumExceptions.ElementNotVisibleException();
		seleniumExceptions.ElementNotSelectableException();
		seleniumExceptions.TimeoutException();
		seleniumExceptions.NoSuchSessionException();
		seleniumExceptions.StaleElementReferenceException();
	}

	//org.openqa.selenium.nosuchelementexception handle:
	public void Nosuchelementexception() throws InterruptedException {
		// browser for set the driver and path
		System.setProperty("webdriver.gecko.driver","D:\\Projects\\Java\\new\\Democlass\\drivers\\geckodriver.exe");
		//browser initialization
		driver = new FirefoxDriver();
		//maximize browser
		driver.manage().window().maximize();
		// cookies delete
		driver.manage().deleteAllCookies();
		//time given for page load.
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//implicit wait initialization
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//by using get command go to url path.
		driver.get("https://www.actitime.com/free-online-trial");

		driver.findElement(By.id("first-name")).sendKeys("Vuma");
		Thread.sleep(5000);

		driver.findElement(By.id("first-namel")).click();
	}

	//org.openqa.selenium.NoSuchWindowException
	public void NoSuchWindowException() throws InterruptedException {
		// browser for set the driver and path
		System.setProperty("webdriver.gecko.driver","D:\\Projects\\Java\\new\\Democlass\\drivers\\geckodriver.exe");
		//browser initialization
		driver = new FirefoxDriver();
		//maximize browser
		driver.manage().window().maximize();
		// cookies delete
		driver.manage().deleteAllCookies();
		//time given for page load.
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//implicit wait initialization
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//by using get command go to url path.
		driver.get("https://4movierulz.mu/the-conjuring-the-devil-made-me-do-it-2021-hdrip-full-movie-watch-online-free/");

		String fristwindow = driver.getWindowHandle();

		driver.findElement(By.linkText("The Conjuring: The Devil Made Me Do It (2021) Full Movie Watch Online Free *Rip File*")).click();

		Set<String> windows= driver.getWindowHandles();

		Iterator<String> itr = windows.iterator();

		while(itr.hasNext()) {
			String window = itr.next();
			driver.switchTo().window("ji");//instaed of window - ji 

			if(driver.getTitle().equals("")) {
				driver.close();
			}
		}
		driver.switchTo().window(fristwindow);
	}

	//org.openqa.selenium.NoSuchFrameException
	public void NoSuchFrameException() {
		// browser for set the driver and path
		System.setProperty("webdriver.gecko.driver","D:\\Projects\\Java\\new\\Democlass\\drivers\\geckodriver.exe");
		//browser initialization
		driver = new FirefoxDriver();
		//maximize browser
		driver.manage().window().maximize();
		// cookies delete
		driver.manage().deleteAllCookies();
		//time given for page load.
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//implicit wait initialization
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//by using get command go to url path.
		driver.get("http://demo.guru99.com/test/guru99home/");

		//Atual frame in this page
		//driver.switchTo().frame("a077aa5e");

		//insted of that frame, am using name of the frame="ji" 

		driver.switchTo().frame("ji");
	}

	//org.openqa.selenium.NoAlertPresentException
	public void NoAlertPresentException() {
		// browser for set the driver and path
		System.setProperty("webdriver.gecko.driver","D:\\Projects\\Java\\new\\Democlass\\drivers\\geckodriver.exe");
		//browser initialization
		driver = new FirefoxDriver();
		//maximize browser
		driver.manage().window().maximize();
		// cookies delete
		driver.manage().deleteAllCookies();
		//time given for page load.
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//implicit wait initialization
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//by using get command go to url path.
		driver.get("https://www.google.com/");

		WebElement about = driver.findElement(By.partialLinkText("About"));
		try {
			driver.switchTo().alert().accept();
		}
		catch(org.openqa.selenium.NoAlertPresentException e) {
			System.out.println("No Alert Present Exception");
		}
		about.click();
	}

	//org.openqa.selenium.InvalidSelectorException
	public void InvalidSelectorException() {
		// browser for set the driver and path
		System.setProperty("webdriver.gecko.driver","D:\\Projects\\Java\\new\\Democlass\\drivers\\geckodriver.exe");
		//browser initialization
		driver = new FirefoxDriver();
		//maximize browser
		driver.manage().window().maximize();
		// cookies delete
		driver.manage().deleteAllCookies();
		//time given for page load.
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//implicit wait initialization
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//by using get command go to url path.
		driver.get("https://www.google.com/");
		
		// for exception, I wrote extra "]" than it(execption) will be console part
		driver.findElement(By.xpath("//*[@name='txtUsername']]")).sendKeys("Admin");
	}
	
	//org.openqa.selenium.ElementNotVisibleException
	public void ElementNotVisibleException() {
		// browser for set the driver and path
		System.setProperty("webdriver.gecko.driver","D:\\Projects\\Java\\new\\Democlass\\drivers\\geckodriver.exe");
		//browser initialization
		driver = new FirefoxDriver();
		//maximize browser
		driver.manage().window().maximize();
		// cookies delete
		driver.manage().deleteAllCookies();
		//time given for page load.
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//implicit wait initialization
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//by using get command go to url path.
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
		
		// below locator is dublicate and radio button is hidden
		driver.findElement(By.id("male")).click();
		
		//if coordinate have than particular radio button have x and y coodinate values
		//if in this page coordinate doesnot have than x and y (0,0). it means radio button hidden.  
		//int x = driver.findElement(By.id("male")).getLocation().getX();
		//int y = driver.findElement(By.id("male")).getLocation().getY();
		//System.out.println("X coordinate "+x);
		//System.out.println("Y coordinate "+y);
		
		//we find radio button coordinate values
		//List<WebElement> radio = driver.findElements(By.id("male"));
		//int count = radio.size();
		//for(int i=0;i<count;i++) {
		//	WebElement ele = radio.get(i);
		//	int x = ele.getLocation().getX();
		//	//int x = radio.get(i).getLocation().getX();
		//	if(x!=0) {
		//		ele.click();
		//		break;
		//	}
		//}
	}
	
	//org.openqa.selenium.ElementNotSelectableException
	public void ElementNotSelectableException() {
		// browser for set the driver and path
		System.setProperty("webdriver.gecko.driver","D:\\Projects\\Java\\new\\Democlass\\drivers\\geckodriver.exe");
		//browser initialization
		driver = new FirefoxDriver();
		//maximize browser
		driver.manage().window().maximize();
		// cookies delete
		driver.manage().deleteAllCookies();
		//time given for page load.
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//implicit wait initialization
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//by using get command go to url path.
		driver.get("https://login.yahoo.com/?.src=ym&lang=en-IN&done=https%3A%2F%2Fin.mail.yahoo.com%2F%3Fguce_referrer%3DaHR0cHM6Ly93d3cuZ29vZ2xlLmNvbS8%26guce_referrer_sig%3DAQAAALWYIK0Z9oJllP_oskyJglsYKbAUM7Dx5tlD-sg2Dc6GE6hj8StFcmJs-ZWqFmIb2PNdjoJ3VBhtxdE9-pLD1lc-XzvCJn-KHrOUWaP27blOsAeZ3T5Il_1rgAnEx4Xi2GYBKIF87bS6TTO4EIQG3M_FjESNcVpeyXUj5HiPMrrH");
		
		//Elemenet is not selectable in this particular locator
		driver.findElement(By.id("persistent")).click();
		//By using actions class it will be resloved
	}
	
	//org.openqa.selenium.TimeoutException
	public void TimeoutException() {
		// browser for set the driver and path
		System.setProperty("webdriver.gecko.driver","D:\\Projects\\Java\\new\\Democlass\\drivers\\geckodriver.exe");
		//browser initialization
		driver = new FirefoxDriver();
		//maximize browser
		driver.manage().window().maximize();
		// cookies delete
		driver.manage().deleteAllCookies();
		//time given for page load.
		//insted of 30 sec i gave to 2 sec it couldnt be page load than exception will be occurs
		Timeouts time = driver.manage().timeouts();
		time.pageLoadTimeout(2, TimeUnit.SECONDS);
		//implicit wait initialization
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//by using get command go to url path.
		driver.get("https://www.spicejet.com/");
		
		
	}
	
	//org.openqa.selenium.NoSuchSessionException
	public void NoSuchSessionException() {
		// browser for set the driver and path
		System.setProperty("webdriver.gecko.driver","D:\\Projects\\Java\\new\\Democlass\\drivers\\geckodriver.exe");
		//browser initialization
		driver = new FirefoxDriver();
		//maximize browser
		driver.manage().window().maximize();
		// cookies delete
		driver.manage().deleteAllCookies();
		//time given for page load.
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//implicit wait initialization
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//by using get command go to url path.
		driver.get("https://www.spicejet.com/");
		
		//NoSuchSessionException for in aurruments
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
		driver.quit();
		driver.close();
	}
	
	//org.openqa.selenium.StaleElementReferenceException
	public void StaleElementReferenceException() {
		// browser for set the driver and path
		System.setProperty("webdriver.gecko.driver","D:\\Projects\\Java\\new\\Democlass\\drivers\\geckodriver.exe");
		//browser initialization
		driver = new FirefoxDriver();
		//maximize browser
		driver.manage().window().maximize();
		// cookies delete
		driver.manage().deleteAllCookies();
		//time given for page load.
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//implicit wait initialization
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//by using get command go to url path.
		driver.get("https://letskodeit.com/");
		
		WebElement ele = driver.findElement(By.id("woocommerce-product-search-field-0"));
		
		driver.get(driver.getCurrentUrl());
		ele.click();
		
		
	}
}
