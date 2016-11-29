import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class HWAuto_2_Roman_Nesmachniy {

    public static void main(String[] args) {

        // 1. LOGON !!!

        WebDriver driver = new FirefoxDriver(); // Open Firefox.
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //Implicit waiting setting = 20 seconds.
        String URL = "http://80.92.229.236:81"; // Poker URL.
        driver.get(URL + "/auth/login"); // Open Poker.

        WebElement usernameInput = driver.findElement(By.id("username")); // Find username input.
        usernameInput.sendKeys("admin"); // Set username.

        WebElement passwordInput = driver.findElement(By.id("password")); // Find password input.
        passwordInput.sendKeys("123"); // Set password.

        driver.findElement(By.id("logIn")).click(); // Find login button + click it.

        String actualTitle = driver.getTitle(); //Get the title of the page "URL + "/auth/login"".
        String expectedTitle = "Players"; // Expected title.

        assertText(actualTitle, expectedTitle); // Make assertions.

        // 2. USER CREATION !!!

        driver.findElement(By.xpath("//div[@id='datagrid_actionpanel__723a925886']/a[2]")).click(); //Find InsertButton + click it.

        WebElement randomUser = driver.findElement(By.id("ff14642ac1c__us_login")); //Find us_login.
        WebElement randomEmail = driver.findElement(By.id("ff14642ac1c__us_email")); //Find us_email.
        Random randomGenerator = new Random(); //Creating an object instance Random (randomGenerator - variable; Random - type).
        int randomInt = randomGenerator.nextInt(1000); //generates a random integer number starting from 0 to 999.
        randomUser.sendKeys("R"+randomInt+"O"+ randomInt+"M"); //Generate user.
        randomEmail.sendKeys("R"+randomInt+"O"+ randomInt+"M"+"@test.com"); //Generate email.

        WebElement us_passwordInput = driver.findElement(By.id("ff14642ac1c__us_password")); //Find us_password.
        us_passwordInput.sendKeys("123456"); // Set us_password.

        WebElement confirm_passwordInput = driver.findElement(By.id("ff14642ac1c__confirm_password")); //Find confirm_password.
        confirm_passwordInput.sendKeys("123456"); //Set confirm_password.

        WebElement fnameInput = driver.findElement(By.id("ff14642ac1c__us_fname")); //Find first name.
        fnameInput.sendKeys("Ivan"); //Set first name.

        WebElement lnameInput = driver.findElement(By.id("ff14642ac1c__us_lname")); //Find last name.
        lnameInput.sendKeys("Ivanov"); //Set last name.

        WebElement cityInput = driver.findElement(By.id("ff14642ac1c__us_city")); //Find city.
        cityInput.sendKeys("Kharkov"); //Set city.

        driver.findElement(By.xpath(".//option[@label='UKRAINE']")).click(); //Search "UKRAINE" in the drop daun menu + click it.

        WebElement addressInput = driver.findElement(By.id("ff14642ac1c__us_address")); //Find address.
        addressInput.sendKeys("Mira 1"); //Set address.

        WebElement phoneInput = driver.findElement(By.id("ff14642ac1c__us_phone")); //Find phone.
        phoneInput.sendKeys("+38057211111"); //Set phone.

        driver.findElement(By.xpath("//input[@name='button_save']")).click(); //Find "Save" Button + click it.

        // 3. VERIFY THAT THE USER IS RETURNED TO THE PAGE WITH A PLAYERS LIST.

        assertText(actualTitle, expectedTitle); // Make assertions.

        // 4. 5. SEARCH CREATED PLAYER (BY USERNAME) + OPENING PLAYER EDIT FORMS !!!

        WebElement userloginField = driver.findElement(By.id("723a925886__login")); //Find userlogin.
        String userlogin = "R"+randomInt+"O"+ randomInt+"M"; //Classified string variable "userlogin".
        userloginField.sendKeys(userlogin); // Value assignment.
        driver.findElement(By.xpath("//input[@value='Search']")).click(); //Find "Search" button + click it.
        driver.findElement(By.xpath(".//tr[.//a[text()='" + userlogin + "']]//img[@alt='Edit']")).click(); //Find "Edit" button (near the required user + click it.

        // 6. FIELDS CONTENTS CHECKING !!!

        System.out.println("------------ Test 1: ------------");
        WebElement emailField = driver.findElement(By.xpath(".//input[contains(@id,'us_email')]")); //Find email.
        String actualEmailValue = emailField.getAttribute("value"); // get actual attribute EmailValue.
        assertString(actualEmailValue, "R"+randomInt+"O"+ randomInt+"M"+"@test.com"); // Make assertions.

        WebElement fnameField = driver.findElement(By.xpath("//input[@id='ff14642ac1c__us_fname']")); //Find first name.
        String actualfnameValue = fnameField.getAttribute("value"); // get actual attribute fnameValue.
        assertString(actualfnameValue, "Ivan"); // Make assertions.

        WebElement lnameField = driver.findElement(By.xpath("//input[@id='ff14642ac1c__us_lname']")); //Find last name.
        String actuallnameValue = lnameField.getAttribute("value"); // get actual attribute lnameValue.
        assertString(actuallnameValue, "Ivanov"); // Make assertions.

        WebElement cityField = driver.findElement(By.xpath("//input[@id='ff14642ac1c__us_city']")); //Find citi.
        String actualcityValue = cityField.getAttribute("value"); // get actual attribute cityValue.
        assertString(actualcityValue, "Kharkov"); // Make assertions.

        WebElement addressField = driver.findElement(By.xpath("//textarea[@id='ff14642ac1c__us_address']")); //Find address.
        String actualaddressValue = addressField.getAttribute("value"); // get actual attribute addressValue.
        assertString(actualaddressValue, "Mira 1"); // Make assertions.

        WebElement phoneField = driver.findElement(By.xpath("//input[@id='ff14642ac1c__us_phone']")); //Find phone.
        String actualphoneValue = phoneField.getAttribute("value"); // get actual attribute phoneValue.
        assertString(actualphoneValue, "+38057211111"); // Make assertions.

        // 7. FIELD CONTENTS CHANGING !!!

        WebElement RanMailInput = driver.findElement(By.id("ff14642ac1c__us_email")); //Find RanMailInput.
        RanMailInput.clear(); // Clear field.
        RanMailInput.sendKeys("N"+randomInt+"R"+ randomInt+"V"+"@test.com"); //Enter generated data.

        WebElement FnameInput = driver.findElement(By.id("ff14642ac1c__us_fname")); //Find FnameInput.
        FnameInput.clear(); // Clear field.
        FnameInput.sendKeys("Roman"); //Data enter.

        WebElement LnameInput = driver.findElement(By.id("ff14642ac1c__us_lname")); //Find LnameInput.
        LnameInput.clear(); // Clear field.
        LnameInput.sendKeys("Romanov"); //Data enter.

        WebElement CityInput = driver.findElement(By.id("ff14642ac1c__us_city")); //Find CityInput.
        CityInput.clear(); // Clear field.
        CityInput.sendKeys("Toronto"); //Data enter.

        WebElement AddressInput = driver.findElement(By.id("ff14642ac1c__us_address")); //Find AddressInput.
        AddressInput.clear(); // Clear field.
        AddressInput.sendKeys("Ranocheclose 1"); //Data enter.

        WebElement PhoneInput = driver.findElement(By.id("ff14642ac1c__us_phone")); //Find PhoneInput.
        PhoneInput.clear(); // Clear field.
        PhoneInput.sendKeys("+16479811111"); //Data enter.

        driver.findElement(By.xpath("//input[@name='button_save']")).click(); //Find SaveButton + click it.

        System.out.println("---------------------------------");

        assertText(actualTitle, expectedTitle); // Make assertions.

        // 8. FORM OPENING. CHANGES CHECKING !!!

        WebElement usloginField = driver.findElement(By.id("723a925886__login")); // Find usloginField.
        usloginField.clear(); //Clear field.
        String uslogin = "R"+randomInt+"O"+ randomInt+"M"; //Assigning a string variable values.
        usloginField.sendKeys(uslogin); // Entering the value of the variable in the field.
        driver.findElement(By.xpath("//input[@value='Search']")).click(); //Find "Search" button + click it.
        driver.findElement(By.xpath(".//tr[.//a[text()='" + uslogin + "']]//img[@alt='Edit']")).click(); //Find "Edit" button (near the required user) + click it.

        System.out.println("------------ Test 2: ------------");
        WebElement EmField = driver.findElement(By.xpath(".//input[contains(@id,'us_email')]")); // Find EmField.
        String actualEmValue = EmField.getAttribute("value"); // get actual attribute EmValue.
        assertString(actualEmValue, "N"+randomInt+"R"+ randomInt+"V"+"@test.com"); // Make assertions.

        WebElement fnamField = driver.findElement(By.xpath("//input[@id='ff14642ac1c__us_fname']")); // Find fnamField.
        String actualfnamValue = fnamField.getAttribute("value"); // get actual attribute fnamValue.
        assertString(actualfnamValue, "Roman"); // Make assertions.

        WebElement lnamField = driver.findElement(By.xpath("//input[@id='ff14642ac1c__us_lname']")); // Find lnamField.
        String actuallnamValue = lnamField.getAttribute("value"); // get actual attribute lnamValue.
        assertString(actuallnamValue, "Romanov"); // Make assertions.

        WebElement citField = driver.findElement(By.xpath("//input[@id='ff14642ac1c__us_city']")); // Find citField.
        String actualcitValue = citField.getAttribute("value"); // get actual attribute citValue.
        assertString(actualcitValue, "Toronto"); // Make assertions.

        WebElement addresField = driver.findElement(By.xpath("//textarea[@id='ff14642ac1c__us_address']")); // Find addresField.
        String actualaddresValue = addresField.getAttribute("value");  // get actual attribute addresValue.
        assertString(actualaddresValue, "Ranocheclose 1"); // Make assertions.

        WebElement phonField = driver.findElement(By.xpath("//input[@id='ff14642ac1c__us_phone']")); // Find phonField.
        String actualphonValue = phonField.getAttribute("value"); // get actual attribute phonValue.
        assertString(actualphonValue, "+16479811111"); // Make assertions.

        driver. close(); // Page close.
        driver. quit(); // Browser close.
    }

    public static void assertString(String actualResult, String expectedResult) {
        if (expectedResult.equals(actualResult)){
            System.out.println("Passed");
        }else {
            System.err.println("Faild. Expected:" + expectedResult + ". Actual: " +actualResult);
        }
    }
    public static void assertText(String actualValue, String expectedValue) {
        if(actualValue.equals(expectedValue)) {
            System.out.println("Passed - assertText.");
        } else {
            System.err.println("Failed. Expected text is "
                    + expectedValue + ", but Actual title is " + actualValue);
        }
    }
}
