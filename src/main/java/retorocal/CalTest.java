package retorocal;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static org.hamcrest.core.Is.is;

public class CalTest {
	private static String pixel = "Pixel_API_28";
	private static String deviceName = "NEXUS5X";
	private static String EMULATOR_NAME = "NEXUS";
	private static String UI_AUTO_NAME = "uiautomator2";
	private static boolean isRealDevice = false;
	private static boolean isApk = true;
	private static String apkName = "RetroCal.apk";
	private static String Browser = "Chrome";
	private static AndroidDriver<AndroidElement> driver = null;

	private static String one = "com.blackfruit.retrostylecalculator:id/oneButton";
	private static String two = "com.blackfruit.retrostylecalculator:id/twoButton";
	private static String three = "com.blackfruit.retrostylecalculator:id/threeButton";
	private static String four = "com.blackfruit.retrostylecalculator:id/fourButton";
	private static String five = "com.blackfruit.retrostylecalculator:id/fiveButton";
	private static String six = "com.blackfruit.retrostylecalculator:id/sixButton";
	private static String seven = "com.blackfruit.retrostylecalculator:id/sevenButton";
	private static String eight = "com.blackfruit.retrostylecalculator:id/eightButton";
	private static String nine = "com.blackfruit.retrostylecalculator:id/nineButton";
	private static String zero = "com.blackfruit.retrostylecalculator:id/zeroButton";
	private static String add = "com.blackfruit.retrostylecalculator:id/addButton";
	private static String sub = "com.blackfruit.retrostylecalculator:id/subtractButton";
	private static String mul = "com.blackfruit.retrostylecalculator:id/multiplyButton";
	private static String div = "com.blackfruit.retrostylecalculator:id/divideButton";
	private static String equal = "com.blackfruit.retrostylecalculator:id/equalButton";
	private static String decimal = "com.blackfruit.retrostylecalculator:id/decimal";
	private static String clear = "com.blackfruit.retrostylecalculator:id/clearButton";

	public static void main(String[] args) throws InterruptedException {
//		DriverFactory driverFactory = new DriverFactory();

		try {

			driver = DriverFactory.create(deviceName, EMULATOR_NAME, UI_AUTO_NAME, isRealDevice, isApk, apkName);
			// testAddition(driver);
			// testSubtraction(driver);
			// testDivision(driver);
			// testMultiplication(driver);
			// testMixed(driver);
			// testNumberbuttons(driver);
			// testToastMessage(driver);
			testSoundOnOff(driver);

		} catch (MalformedURLException s) {
			System.out.println(" This path is wrong with error :" + s.getLocalizedMessage());
			// } catch (InterruptedException e) {
			// System.out.println(e.getLocalizedMessage());
		}
	}

	private static void testSoundOnOff(AndroidDriver<AndroidElement> driver) {

		driver.findElementByXPath("//android.widget.Switch [@text = 'ON']").click();

		driver.findElementByXPath("//android.widget.Switch [@text = 'OFF']").click();

//sound on
		driver.findElementById(one).click();
		driver.findElementById(two).click();
		driver.findElementById(three).click();
		driver.findElementById(four).click();
		driver.findElementById(five).click();
		driver.findElementById(six).click();
		driver.findElementById(clear).click();

//sound off	
		driver.findElementByXPath("//android.widget.Switch [@text = 'ON']").click();
		driver.findElementById(one).click();
		driver.findElementById(two).click();
		driver.findElementById(three).click();
		driver.findElementById(four).click();
		driver.findElementById(five).click();
		driver.findElementById(six).click();

		try {
			Thread.sleep(5000);

		} catch (InterruptedException e) {

			e.printStackTrace();

		}
		driver.quit();

	}

	// ToastMessage
	private static void testToastMessage(AndroidDriver<AndroidElement> driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElementById(one).click();
		driver.findElementById(one).click();
		driver.findElementById(one).click();
		driver.findElementById(one).click();
		driver.findElementById(one).click();
		driver.findElementById(one).click();
		driver.findElementById(one).click();
		driver.findElementById(one).click();
		driver.findElementById(one).click();
		driver.findElementById(one).click();
		driver.findElementById(one).click();
		driver.findElementById(one).click();
		driver.findElementById(one).click();
		driver.findElementById(one).click();
		driver.findElementById(one).click();
		driver.findElementById(one).click();

		String toastMessage = driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
		System.out.println("Error Message: " + toastMessage);
		Assert.assertEquals("Value too big,resetting all the values", toastMessage);

		try {
			Thread.sleep(5000);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		driver.quit();

	}

	private static void testNumberbuttons(AndroidDriver<AndroidElement> driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("*****************************************************************");

//0-9 buttons
		driver.findElementById(clear).click();
		driver.findElementById(one).click();
		driver.findElementById(two).click();
		driver.findElementById(three).click();
		driver.findElementById(four).click();
		driver.findElementById(five).click();
		driver.findElementById(six).click();
		driver.findElementById(seven).click();
		driver.findElementById(eight).click();
		driver.findElementById(nine).click();
		driver.findElementById(zero).click();
		driver.findElementById(clear).click();

// " / " (division) button	
		driver.findElementById(two).click();
		driver.findElementById(div).click();
		driver.findElementById(two).click();
		driver.findElementById(equal).click();
		String sum = driver.findElement(By.xpath("//*[@ text = '1.0']")).getText();
		System.out.println("First Question: 2 / 2 = 1");
		System.out.println("Total: " + sum);

//"*" (Multiplication) button
		driver.findElementById(clear).click();
		driver.findElementById(two).click();
		driver.findElementById(mul).click();
		driver.findElementById(two).click();
		driver.findElementById(equal).click();
		String sum1 = driver.findElement(By.xpath("//*[@ text = '4']")).getText();
		System.out.println("Second Question: 2 x 2 = 4");
		System.out.println("Total: " + sum1);

//"-" (subtraction) button		
		driver.findElementById(clear).click();
		driver.findElementById(two).click();
		driver.findElementById(sub).click();
		driver.findElementById(two).click();
		driver.findElementById(equal).click();
		String sum2 = driver.findElement(By.xpath("//*[@ text = '0.0']")).getText();
		System.out.println("Second Question: 2 - 2 = 0");
		System.out.println("Total: " + sum2);

//"+" (addition) button		
		driver.findElementById(clear).click();
		driver.findElementById(two).click();
		driver.findElementById(add).click();
		driver.findElementById(two).click();
		driver.findElementById(equal).click();
		String sum3 = driver.findElement(By.xpath("//*[@ text = '4.0']")).getText();
		System.out.println("Third Question: 2 + 2 = 4");
		System.out.println("Total: " + sum3);

//""." (decimal) button		
		driver.findElementById(clear).click();
		driver.findElementById(two).click();
		driver.findElementById(decimal).click();
		driver.findElementById(two).click();
		driver.findElementById(add).click();
		driver.findElementById(two).click();
		driver.findElementById(decimal).click();
		driver.findElementById(two).click();
		driver.findElementById(equal).click();
		String sum4 = driver.findElement(By.xpath("//*[@ text = '4.4']")).getText();
		System.out.println("Fourth Question: 2.2 + 2.2 = 4.4");
		System.out.println("Total: " + sum4);

//"max" button input		
		driver.findElementById(one).click();
		driver.findElementById(one).click();
		driver.findElementById(one).click();
		driver.findElementById(one).click();
		driver.findElementById(one).click();
		driver.findElementById(one).click();
		driver.findElementById(one).click();
		driver.findElementById(one).click();
		driver.findElementById(one).click();
		driver.findElementById(one).click();
		driver.findElementById(one).click();
		driver.findElementById(one).click();
		driver.findElementById(one).click();
		driver.findElementById(one).click();
		driver.findElementById(one).click();
		driver.findElementById(one).click();

		driver.findElementById(nine).click();
		driver.findElementById(nine).click();
		driver.findElementById(nine).click();
		driver.findElementById(nine).click();
		driver.findElementById(nine).click();
		driver.findElementById(nine).click();
		driver.findElementById(nine).click();
		driver.findElementById(nine).click();
		driver.findElementById(nine).click();
		driver.findElementById(nine).click();
		driver.findElementById(nine).click();
		driver.findElementById(nine).click();
		driver.findElementById(nine).click();
		driver.findElementById(nine).click();
		driver.findElementById(nine).click();
		driver.findElementById(nine).click();

//"=" (equal) button
		driver.findElementById(clear).click();
		driver.findElementById(zero).click();
		driver.findElementById(add).click();
		driver.findElementById(zero).click();
		driver.findElementById(equal).click();
		String total = driver.findElement(By.xpath("//*[@ text = '0.0']")).getText();
		System.out.println("Fifth Question: 0+0=0");
		System.out.println("Total: " + total);

//"c" (clear) button
		driver.findElementById(clear).click();
		driver.findElementById(zero).click();
		driver.findElementById(add).click();
		driver.findElementById(one).click();
		driver.findElementById(equal).click();
		String total1 = driver.findElement(By.xpath("//*[@ text = '1.0']")).getText();
		System.out.println("Sixth Question: 0+1=1");
		System.out.println("Total1: " + total1);

//"0" input		
		driver.findElementById(clear).click();
		driver.findElementById(zero).click();
		driver.findElementById(add).click();
		driver.findElementById(two).click();
		driver.findElementById(equal).click();
		String total2 = driver.findElement(By.xpath("//*[@ text = '2.0']")).getText();
		System.out.println("Seventh Question: 0+2=2");
		System.out.println("Total2: " + total2);

		driver.findElementById(clear).click();
		driver.findElementById(zero).click();
		driver.findElementById(add).click();
		driver.findElementById(three).click();
		driver.findElementById(equal).click();
		String total3 = driver.findElement(By.xpath("//*[@ text = '3.0']")).getText();
		System.out.println("Eighth Question: 0+3=3");
		System.out.println("Total3: " + total3);

		driver.findElementById(clear).click();
		driver.findElementById(zero).click();
		driver.findElementById(add).click();
		driver.findElementById(four).click();
		driver.findElementById(equal).click();
		String total4 = driver.findElement(By.xpath("//*[@ text = '4.0']")).getText();
		System.out.println("Nineth Question: 0+4=4");
		System.out.println("Total4: " + total4);

		driver.findElementById(clear).click();
		driver.findElementById(zero).click();
		driver.findElementById(add).click();
		driver.findElementById(equal).click();
		driver.findElementById("com.blackfruit.retrostylecalculator:id/fiveButton").click();
		String total5 = driver.findElement(By.xpath("//*[@ text = '5']")).getText();
		System.out.println("Tenth Question: 0+5=5");
		System.out.println("Total5: " + total5);

		driver.findElementById(clear).click();
		driver.findElementById(zero).click();
		driver.findElementById(add).click();
		driver.findElementById(six).click();
		driver.findElementById(equal).click();
		String total6 = driver.findElement(By.xpath("//*[@ text = '6.0']")).getText();
		System.out.println("Eleventh Question: 0+6=6");
		System.out.println("Total6: " + total6);

		driver.findElementById(clear).click();
		driver.findElementById(zero).click();
		driver.findElementById(add).click();
		driver.findElementById(seven).click();
		driver.findElementById(equal).click();
		String total7 = driver.findElement(By.xpath("//*[@ text = '7.0']")).getText();
		System.out.println("Twelves Question: 0+7=7");
		System.out.println("Total7: " + total7);

		driver.findElementById(clear).click();
		driver.findElementById(zero).click();
		driver.findElementById(add).click();
		driver.findElementById(eight).click();
		driver.findElementById(equal).click();
		String total8 = driver.findElement(By.xpath("//*[@ text = '8.0']")).getText();
		System.out.println("Thirteenth Question: 0+8=8");
		System.out.println("Total8: " + total8);

		driver.findElementById(clear).click();
		driver.findElementById(zero).click();
		driver.findElementById(add).click();
		driver.findElementById(nine).click();
		driver.findElementById(equal).click();
		String total9 = driver.findElement(By.xpath("//*[@ text = '9.0']")).getText();
		System.out.println("Fourteenth Question: 0+9=9");
		System.out.println("Total9: " + total9);
		driver.findElementById("com.blackfruit.retrostylecalculator:id/clearButton").click();
		try {
			Thread.sleep(5000);

		} catch (InterruptedException e) {

			e.printStackTrace();

		}
		driver.quit();

	}

//BIDMAS test
	private static void testMixed(AndroidDriver<AndroidElement> driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("*****************************************************************");

		driver.findElementById(clear).click();
		driver.findElementById(five).click();
		driver.findElementById(add).click();
		driver.findElementById(nine).click();
		driver.findElementById(div).click();
		driver.findElementById(two).click();
		driver.findElementById(seven).click();
		driver.findElementById(equal).click();

		String total11 = driver.findElement(By.xpath("//*[@ text = '0.0']")).getText();
		System.out.println("First Question: 5+9/2-7=2.5");
		System.out.println("Total11: " + total11);
		String numberAsString11 = total11;
		double number11 = Double.valueOf(numberAsString11);
		Assert.assertEquals(2.5, number11, 0);
		if (number11 == 2.5) {
			System.out.println("This total is correct!");

		} else {
			System.out.println("This total is NOT correct!");
		}
		try {
			Thread.sleep(5000);

		} catch (InterruptedException e) {

			e.printStackTrace();

		}
		driver.quit();
	}

//Multiplication
	private static void testMultiplication(AndroidDriver<AndroidElement> driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElementById(clear).click();
		driver.findElementById(seven).click();
		driver.findElementById(mul).click();
		driver.findElementById(five).click();
		driver.findElementById(equal).click();
		String total8 = driver.findElement(By.xpath("//*[@ text = '35']")).getText();
		System.out.println("First Question: 7 x 5 = 35");
		System.out.println("Total8: " + total8);
		String numberAsString8 = total8;
		double number8 = Double.valueOf(numberAsString8);
		Assert.assertEquals(35, number8, 0);
		if (number8 == 35) {
			System.out.println("This total is correct!");

		} else {
			System.out.println("This total is NOT correct!");
		}

		System.out.println("*****************************************************************");

		driver.findElementById(clear).click();
		driver.findElementById(one).click();
		driver.findElementById(six).click();
		driver.findElementById(mul).click();
		driver.findElementById(three).click();
		driver.findElementById(six).click();
		driver.findElementById(equal).click();
		String total9 = driver.findElement(By.xpath("//*[@ text = '576']")).getText();
		System.out.println("Second Question: 16 x 36 = 576");
		System.out.println("Total9: " + total9);
		String numberAsString9 = total9;
		double number9 = Double.valueOf(numberAsString9);
		Assert.assertEquals(576, number9, 0);

		if (number9 == 576) {
			System.out.println("This total is correct!");

		} else {
			System.out.println("This total is NOT correct!");
		}
		System.out.println("*****************************************************************");

		driver.findElementById(clear).click();
		driver.findElementById(five).click();
		driver.findElementById(seven).click();
		driver.findElementById(mul).click();
		driver.findElementById(zero).click();
		driver.findElementById(equal).click();
		String total10 = driver.findElement(By.xpath("//*[@ text = '0']")).getText();
		System.out.println("Third Question: 57/0 = Infinity");
		System.out.println("Total10: " + total10);
		// String numberAsString10 = total10;
		// double number10 = Double.valueOf(numberAsString10);
		Assert.assertEquals("Infinity", total10, 0);
		if (total10 == "Infinity") {
			System.out.println("This total is correct!");

		} else {
			System.out.println("This total is NOT correct!");
		}
		System.out.println("*****************************************************************");
	}

//Division
	private static void testDivision(AndroidDriver<AndroidElement> driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElementById(clear).click();
		driver.findElementById(six).click();
		driver.findElementById(div).click();
		driver.findElementById(three).click();
		driver.findElementById(equal).click();
		String total10 = driver.findElement(By.xpath("//*[@ text = '2.0']")).getText();
		System.out.println("First Question: 6/3 = 2.0");
		System.out.println("Total10: " + total10);
		String numberAsString10 = total10;
		double number10 = Double.valueOf(numberAsString10);
		Assert.assertEquals(2.0, number10, 0);

		if (number10 == 2.0) {
			System.out.println("This total is correct!");

		} else {
			System.out.println("This total is NOT correct!");
		}
		System.out.println("*****************************************************************");

		driver.findElementById(clear).click();
		driver.findElementById(eight).click();
		driver.findElementById(div).click();
		driver.findElementById(four).click();
		driver.findElementById(three).click();
		driver.findElementById(equal).click();
		String total6 = driver.findElement(By.xpath("//*[@ text = '2.0']")).getText();
		System.out.println("Second Question: 86/43 = 2.0");
		System.out.println("Total6: " + total6);
		String numberAsString6 = total6;
		double number6 = Double.valueOf(numberAsString6);
		Assert.assertEquals(2.0, number6, 0);
		if (number6 == 2.0) {
			System.out.println("This total is correct!");

		} else {
			System.out.println("This total is NOT correct!");
		}
		System.out.println("*****************************************************************");

		driver.findElementById(clear).click();
		driver.findElementById(three).click();
		driver.findElementById(six).click();
		driver.findElementById(div).click();
		driver.findElementById(zero).click();
		driver.findElementById(equal).click();
		String total7 = driver.findElement(By.xpath("//*[@ text = 'Infinity']")).getText();
		System.out.println(total7);
		System.out.println("Third Question: 36/0 = Infinity");
		System.out.println("Total7: " + total7);
		// String numberAsString7 = total7;
		// double number7 = Double.valueOf(numberAsString7);
		Assert.assertEquals("Infinity", total7, 0);

		if (total7.equals("Infinity")) {
			System.out.println("This total is correct!");

		} else {
			System.out.println("This total is NOT correct!");
		}
		System.out.println("*****************************************************************");
		try {
			Thread.sleep(5000);

		} catch (InterruptedException e) {

			e.printStackTrace();

		}
		driver.quit();
	}

///Subtraction
	private static void testSubtraction(AndroidDriver<AndroidElement> driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElementById(clear).click();
		driver.findElementById(five).click();
		driver.findElementById(sub).click();
		driver.findElementById(nine).click();
		driver.findElementById(equal).click();
		String total3 = driver.findElement(By.xpath("//*[@ text = '-4.0']")).getText();
		System.out.println("First Question: 5 - 9 = -4.0");
		System.out.println("Total3: " + total3);
		String numberAsString3 = total3;
		double number3 = Double.valueOf(numberAsString3);
		Assert.assertEquals(-4.0, number3, 0);

		if (number3 == -4.0) {
			System.out.println("This total is correct!");

		} else {
			System.out.println("This total is NOT correct!");
		}
		System.out.println("*****************************************************************");

		driver.findElementById(clear).click();
		driver.findElementById(three).click();
		driver.findElementById(six).click();
		driver.findElementById(sub).click();
		driver.findElementById(eight).click();
		driver.findElementById(four).click();
		driver.findElementById(equal).click();
		String total4 = driver.findElement(By.xpath("//*[@ text = '-48.0']")).getText();
		System.out.println("Second Question: 36 - 84 = -48.0");
		System.out.println("Total4: " + total4);
		String numberAsString4 = total4;
		double number4 = Double.valueOf(numberAsString4);
		Assert.assertEquals(48.0, number4, 0);

		if (number4 == -48.0) {
			System.out.println("This total is correct!");

		} else {
			System.out.println("This total is NOT correct!");
		}
		System.out.println("*****************************************************************");
		try {
			Thread.sleep(5000);

		} catch (InterruptedException e) {

			e.printStackTrace();

		}
		driver.quit();
	}

//Addition
	private static void testAddition(AndroidDriver<AndroidElement> driver2) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElementById(clear).click();
		driver.findElementById(three).click();
		driver.findElementById(add).click();
		driver.findElementById(equal).click();

		String total1 = driver.findElement(By.xpath("//*[@ text = '9.0']")).getText();
		System.out.println("First Question: 3 + 6 = 9");
		System.out.println("Total1: " + total1);
		String numberAsString = total1;
		double number = Double.valueOf(numberAsString);
		Assert.assertEquals(9.0, number, 0);

		if (number == 9.0) {
			System.out.println("This total is correct!");

		} else {
			System.out.println("This total is NOT correct!");
		}
		System.out.println("*****************************************************************");

		driver.findElementById(clear).click();
		driver.findElementById(five).click();
		driver.findElementById(six).click();
		driver.findElementById(add).click();
		driver.findElementById(four).click();
		driver.findElementById(nine).click();
		driver.findElementById(equal).click();
		String total2 = driver.findElement(By.xpath("//*[@ text = '105.0']")).getText();
		System.out.println("Second Question: 56 + 49 = 105.0");
		System.out.println("Total2: " + total2);
		String numberAsString2 = total2;
		double number2 = Double.valueOf(numberAsString2);
		// Assert.assertEquals(105.0, number2);
		if (number2 == 105.0) {
			System.out.println("This total is correct!");

		} else {
			System.out.println("This total is NOT correct!");
		}

		System.out.println("*****************************************************************");
		try {
			Thread.sleep(5000);

		} catch (InterruptedException e) {

			e.printStackTrace();

		}
		driver.quit();
	}
}
