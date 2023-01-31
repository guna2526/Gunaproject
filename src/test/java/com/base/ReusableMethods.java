package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
public class ReusableMethods {
	public static  WebDriver driver;
	public static String getProjectLoc() {
		String path = System.getProperty("user.dir");
		return path;
	}
	
	public static void getDriver(String browserType) {
		switch(browserType) {
		case "chrome" :
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox" :
			WebDriverManager.firefoxdriver().setup();
			driver = new ChromeDriver();
			break;
		case "ie" :
			WebDriverManager.iedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge" :
			WebDriverManager.edgedriver().setup();
			driver = new ChromeDriver();
			break;
		default:
			break;
		}
	}
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException{
			Properties properties = new Properties();
			properties.load(new FileInputStream(getProjectLoc()+"\\Config\\config.properties"));
			String value =(String) properties.get(key);
			return value;
		
	
	}
	public static void enterUrl(String url) {
		driver.get(url);
	}
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}
	public void elementSendkeys(WebElement element,String data) {
		element.sendKeys(data);
	}
	public void elementSendkeysJS(WebElement element,String data) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].setAttribute('value','"+data+"')", element);
	}
	public void elementClickJS(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
	}
	public void getEnteredValueByJS(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("return arguments[0].getAttribute('value')", element);
	}
	public void scrollUporDownByJS(WebElement element,boolean append) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].scrollIntoView("+append+")", element);
	}
	public void elementClick(WebElement element) {
		element.click();
	}
	public void clear(WebElement element) {
		element.clear();
		
	}
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}
	public void closeCurrentWindows() {
		driver.close();
	}
	public static void closeAllWindows() {
		driver.quit();
	}
	public String enteredUrl() {
		String currentUrl = driver.getCurrentUrl();
	    return currentUrl;
	}
    public String elementGetAttribute(WebElement element) {
    	String attribute = element.getAttribute("value");
        return attribute;
    }
    public String elementGetAttribute(WebElement  element,String attributeName) {
    	String attribute = element.getAttribute(attributeName);
    	return attribute;
    }
    public WebElement findLocatorById(String attributeValue) {
    	WebElement element = driver.findElement(By.id(attributeValue));
    	return element;
    }
    public WebElement findLocatorByName(String attributeValue) {
    	WebElement element = driver.findElement(By.name(attributeValue));
    	return element;
    }
    public WebElement findLocatorByClass(String attributeValue) {
    	WebElement element = driver.findElement(By.className(attributeValue));
    	return element;
    }
    public WebElement findLocatorByXpath(String xpath) {
    	WebElement element = driver.findElement(By.xpath(xpath));
    	return element;
    }
    public void ddSelectOptionByText(WebElement element,String text) {
    	Select select = new Select(element);
    	select.selectByVisibleText(text);
    }
    public void ddSelectOptionByAttribute(WebElement element,String text) {
    	Select select = new Select(element);
    	select.selectByValue(text);
    }
    public void ddSelectOptionByIndex(WebElement element,int index) {
    	Select select = new Select(element);
        select.selectByIndex(index);	
    }
    public void alertOk() {
    	driver.switchTo().alert().accept();
    }
    public void alertCancel() {
    	driver.switchTo().alert().dismiss();
    }
    public void alertText(String data) {
    	driver.switchTo().alert().sendKeys(data);
    }
    public void switchToChildWindow(String data) {
    	driver.switchTo().window(data);
    }
    public void switchtoFrameByIndex(int index){
    	driver.switchTo().frame(index);
    }
    public void switchtoFrameByValue(String id) {
	driver.switchTo().frame(id);
    }
    public void switchtoFrameByElement(WebElement frameElement ) {
    driver.switchTo().frame(frameElement);
    }
//    public void implicitWait(Duration duration) {
//    driver.manage().timeouts().implicitlyWait(duration)	;
//    }
    public WebElement getFirstSelectOption(WebElement element) {
    Select select = new Select(element);	
     WebElement selectedOption = select.getFirstSelectedOption();
    return selectedOption;
    }
    public List<WebElement> getAllSelectOption(WebElement element) {
        Select select = new Select(element);	
          List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
        return allSelectedOptions;
        }
    public List<WebElement> getOption(WebElement element) {
        Select select = new Select(element);	
        List<WebElement> options = select.getOptions();
		return options;
    }
    public boolean verifyIsMuliple(WebElement element) {
        Select select = new Select(element);	
        boolean multiple = select.isMultiple();
		return multiple;
    }
    public void deselectByIndex(WebElement element,int index) {
        Select select = new Select(element);
        select.deselectByIndex(index);
    }
    public void deselectByText(WebElement element,String text) {
        Select select = new Select(element);
        select.deselectByVisibleText(text);
    }
    public void deselectByValue(WebElement element,String value) {
        Select select = new Select(element);
        select.deselectByValue(value);
    }
    public void deselectAll(WebElement element) {
        Select select = new Select(element);
        select.deselectAll();
    }
    public String getParentWindow() {
    	String windowHandle = driver.getWindowHandle();
		return windowHandle;
    }
    public Set<String> getAllWindows() {
    	 Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
    }
    public void textboxClear(WebElement element) {
    	element.clear();
    }
    public void refresh() {
    	driver.navigate().refresh();
    }
    public void navigateForward() {
    	driver.navigate().forward();
    }
    public void navigatebackward() {
    	driver.navigate().back();
    }
    public void moveToElement(WebElement target) {
    	Actions actions = new Actions(driver);
    	actions.moveToElement(target).perform();
    }
    public void dragAndDrop(WebElement source,WebElement target) {
    	Actions actions = new Actions(driver);
    	actions.dragAndDrop(source, target).perform();
    }
    public void doubleClick(WebElement target) {
    	Actions actions = new Actions(driver);
    	actions.doubleClick(target).perform();
    }
    public void rightClick(WebElement target) {
    	Actions actions = new Actions(driver);
    	actions.contextClick(target);
    }
    public byte[] screenshot() {
    	TakesScreenshot ts =(TakesScreenshot) driver;
    	 byte[] bs = ts.getScreenshotAs(OutputType.BYTES);
    	return bs;
    	
    }
    public File takesScreenshot(String pathname ) throws IOException {
    	TakesScreenshot ts =(TakesScreenshot) driver;
    	File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
    	File file = new File(pathname);
    	FileUtils.copyFile(screenshotAs, file);
		return screenshotAs;
     }
    public boolean createFolder(String path) {
    	File file = new File(path);
    	boolean mkdir = file.mkdir();
		return mkdir;
    }
    public boolean createInnerFolder(String path) {
    	File file = new File(path);
    	boolean mkdirs = file.mkdirs();
		return mkdirs;
    }
    public void copyFile(File srcFile,File destFile ) throws IOException {
    	FileUtils.copyFile(srcFile, destFile);
    }
    public void writeNewFile(File file,CharSequence data ,boolean append) throws IOException {
      FileUtils.write(file, data, append);
    }
    public List<String> readlines(File file) throws IOException {
    	List<String> readLines = FileUtils.readLines(file);
		return readLines;
    }
    public WebDriver getToParentframe() {
    	WebDriver parentFrame = driver.switchTo().parentFrame();
		return parentFrame;
    }
    public void launchBrowser(String text,String text1) {
    	 System.setProperty(text, text1);
    }
    public void sleep(long millis) throws InterruptedException {
    	Thread.sleep(millis);
    }
    public List<WebElement> webtable(String tagName){
    	List<WebElement> findElements = driver.findElements(By.tagName(tagName));
		return findElements;
    }
    public boolean createNewFile(String path) throws IOException {
    	File file = new File(path);
    	boolean createNewFile = file.createNewFile();
		return createNewFile;
    	}
    public boolean canReadAFile(String path) throws IOException {
    	File file = new File(path);
    	 boolean canRead = file.canRead();
		return canRead;
    	}
    public boolean canExecuteAFile(String path) throws IOException {
    	File file = new File(path);
    	  boolean canExecute = file.canExecute();
		return canExecute;
    	}
    public boolean canWriteAFile(String path) throws IOException {
    	File file = new File(path);
    	  boolean canWrite = file.canWrite();
		return canWrite;
    	}
    public boolean isFile(String path) throws IOException {
    	File file = new File(path);
    	boolean file2 = file.isFile();
		return file2;
    }
    public boolean isDirectory(String path) throws IOException {
    	File file = new File(path);
    	 boolean directory = file.isDirectory();
		return directory;
    }
   
    public String getDataFromCell(String sheetName,int rownum,int cellnum ) throws IOException {
    	String res = "";
    	File list = new File("C:\\Users\\Selva\\eclipse-workspace\\Student\\Excel\\hotelbooking.xlsx");
    	FileInputStream stream = new FileInputStream(list);
		Workbook workbook = new XSSFWorkbook(stream);
Sheet sheet = workbook.getSheet(sheetName);
    	Row row = sheet.getRow(rownum);
    Cell cell = row.getCell(cellnum);
    CellType type = cell.getCellType();
    switch(type) {
    case STRING:
    	res=cell.getStringCellValue();
    	break;
    case NUMERIC:
    	if(DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
			res = dateformat.format(dateCellValue);
    }
    	else {
			double d = cell.getNumericCellValue();
            long check = Math.round(d);
if(d==check) {
	res = String.valueOf(check);
}
else {
	res = String.valueOf(d);
	
}
}
    default:
   break;
    }
    return res;
    }
    
    public void updateData(String sheetName,int rownum,int cellnum,String olddata,String newdata ) throws IOException {
    File list = new File("C:\\Users\\Selva\\eclipse-workspace\\Student\\Excel\\hotelbooking.xlsx");
    	FileInputStream stream = new FileInputStream(list);
		Workbook workbook = new XSSFWorkbook(stream);
    Sheet sheet = workbook.getSheet(sheetName);
    	Row row = sheet.getRow(rownum);
    Cell cell = row.getCell(cellnum);
    String value = cell.getStringCellValue();
    if(value.equals(olddata)) {
    	cell.setCellValue(newdata);
    }
	FileOutputStream out = new FileOutputStream(list);
	workbook.write(out);
	}
    
  public void insertData(String sheetName,int rownum,int cellnum,String data) throws IOException {
    File list = new File("C:\\Users\\Selva\\eclipse-workspace\\Student\\Excel\\hotelbooking.xlsx");
    	FileInputStream stream = new FileInputStream(list);
		Workbook workbook = new XSSFWorkbook(stream);
        Sheet sheet = workbook.getSheet(sheetName);
    	Row row = sheet.getRow(rownum);
    Cell cell = row.createCell(cellnum);
    cell.setCellValue(data);
    FileOutputStream out = new FileOutputStream(list);
	workbook.write(out);
  }
    
} 
    
    
    
    
    

