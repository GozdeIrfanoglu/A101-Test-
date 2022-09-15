package A101Tests;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.Random;



public class A101_Product_To_Cart  {


    public static void main(String[] args) {
try {
    System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.a101.com.tr/");

//Çerezleri kabul et

    WebElement cookie =driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll" ));
    cookie.click();

//Giysi ve Aksesuar bölümüne gir

    Thread.sleep(1000);
    WebElement clothe=driver.findElement(By.xpath("//body/section/section[1]/div/div/div/div[1]/div/div/ul/li[4]"));
    Actions action=new Actions(driver);
    action.moveToElement(clothe).perform();

//Dizaltı Çorap bölümüne gir

    Thread.sleep(1000);
    WebElement sock=driver.findElement(By.linkText("Dizaltı Çorap"));
    action.moveToElement(sock).perform();
    sock.click();

//Siyah Çorap seçildiğini göster ve seç

    Thread.sleep(2000);
    WebElement black=driver.findElement(By.cssSelector("[value='SİYAH']"));
    black.click();

    Thread.sleep(1000);
    WebElement blackSock = driver.findElement(By.xpath("//body/section/section[4]/div[3]/div[2]/div/div[2]/div[2]/div/ul/li[1]/article/div/div[2]/div[2]"));
    blackSock.click();
    WebElement alert=driver.findElement((By.xpath("//body/section/section[3]/div[2]/nav/ol/li[5]/span")));
    System.out.println(alert.getText());


//Siyah Dizaltı Çorabı sepete ekle, sepeti görüntüle ve sepeti onayla

    WebElement addCart=driver.findElement(By.xpath("/html/body/section/section[3]/div[2]/div[1]/div/div[3]/div[2]/div[1]/button"));
    addCart.click();

    Thread.sleep(1000);
    WebElement viewCart=driver.findElement(By.cssSelector("#js-modal-basket > div.right-side > a.go-to-shop"));
    viewCart.click();
    WebElement confirmCart=driver.findElement((By.xpath("/html/body/section/div[1]/div[2]/div/div[2]/div/a")));
    confirmCart.click();

//Üye olmadan devam et ve E mail ile devam et

    WebElement whitoutMembership=driver.findElement(By.xpath("/html/body/section/div[1]/div/div[1]/div[1]/div[2]/a"));
    whitoutMembership.click();

    Thread.sleep(1000);
    WebElement email=driver.findElement(By.xpath("/html/body/section/div[1]/div/div[2]/div/div/form/div[1]/input"));
    email.click();
    Random rnd=new Random();
    int rndInt =rnd.nextInt(1000);
    email.sendKeys("username"+rndInt+"@gmail.com");
    WebElement continu=driver.findElement(By.xpath("/html/body/section/div[1]/div/div[2]/div/div/form/button"));
    continu.click();

//Yeni adres oluşturma

    Thread.sleep(1000);
    WebElement newAddress=driver.findElement(By.xpath("/html/body/section/section/div/div[2]/div/div[1]/div/div[1]/div[2]/ul[2]/li/a"));
    newAddress.click();
    WebElement addressTitle=driver.findElement(By.xpath("//*[@id=\"js-orders-modal-container\"]/div/div[2]/form/div[2]/div/div/label/input"));
    addressTitle.click();
    addressTitle.sendKeys("EV");

    Thread.sleep(1000);
    WebElement name=driver.findElement(By.xpath("//*[@id=\"js-orders-modal-container\"]/div/div[2]/form/div[3]/div[1]/div/label/input"));
    name.sendKeys("Ayşe");

    Thread.sleep(2000);
    WebElement lastName=driver.findElement(By.xpath("//*[@id=\"js-orders-modal-container\"]/div/div[2]/form/div[3]/div[2]/div/label/input"));
    lastName.sendKeys("Ay");

    Thread.sleep(2000);
    WebElement phone = driver.findElement(By.xpath("//*[@id='js-orders-modal-container']/div/div[2]/form/div[4]/div/div/label/input"));
    String randomNumber= RandomStringUtils.randomNumeric(3);
    phone.sendKeys("05987890"+randomNumber);

    Thread.sleep(3000);
    WebElement city=driver.findElement(By.xpath("//*[@id=\"js-orders-modal-container\"]/div/div[2]/form/div[5]/div[1]/div/label/div/select"));
    city.click();
    action.moveToElement(city).perform();
    Select comboCity=new Select(city);
    int dropDownValuesCount1 =driver.findElements(By.xpath("//*[@id=\"js-orders-modal-container\"]/div/div[2]/form/div[5]/div[1]/div/label/div/select/option")).size();
    int index1=rnd.nextInt(dropDownValuesCount1);
    comboCity.selectByIndex(index1);

    Thread.sleep(3000);
    WebElement district=driver.findElement(By.xpath("//*[@id=\"js-orders-modal-container\"]/div/div[2]/form/div[5]/div[2]/div/label/div/select"));
    district.click();
    action.moveToElement(district).perform();
    Select comboDistrict=new Select(district);
    int dropDownValuesCount2 =driver.findElements(By.xpath("//*[@id=\"js-orders-modal-container\"]/div/div[2]/form/div[5]/div[2]/div/label/div/select/option")).size();
    int index2=rnd.nextInt(dropDownValuesCount2);
    comboDistrict.selectByIndex(index2);

    Thread.sleep(3000);
    WebElement neighbourhood=driver.findElement(By.xpath("//*[@id=\"js-orders-modal-container\"]/div/div[2]/form/div[6]/label/div/select"));
    neighbourhood.click();

    Select comboNeighbourhood=new Select(neighbourhood);
    int dropDownValuesCount3 =driver.findElements(By.xpath("//*[@id=\"js-orders-modal-container\"]/div/div[2]/form/div[6]/label/div/select/option")).size();
    int index3=rnd.nextInt(dropDownValuesCount3);
    comboNeighbourhood.selectByIndex(index3);

    Thread.sleep(2000);
    WebElement addressDescription=driver.findElement(By.xpath("//*[@id=\"js-orders-modal-container\"]/div/div[2]/form/div[7]/label/textarea"));
    addressDescription.click();
    addressDescription.sendKeys("çiçek sokak 1 no");

    WebElement addressSave=driver.findElement(By.xpath("//*[@id=\"js-orders-modal-container\"]/div/div[2]/form/button[1]"));
    addressSave.click();

//Kargo seçimi ve kaydı

    Thread.sleep(3000);
    WebElement cargo=driver.findElement(By.xpath("//body/section/section/div/div[2]/div/div[1]/div/div[2]/form/div[2]/div[2]/ul/li[1]/label/div[2]/div"));
    cargo.isSelected();
    cargo.click();

    Thread.sleep(2000);
    WebElement cargoSave=driver.findElement(By.xpath("//body/section/section/div/div[2]/div/div[1]/div/div[2]/form/div[2]/button"));
    cargoSave.click();

//Ödeme ekranınanda olduğunu göster

    Thread.sleep(1000);
    WebElement alert2 = driver.findElement(By.cssSelector(".payment-tab-masterpass"));
    System.out.println(alert2.getText());

}   catch (Exception a101){
    a101.printStackTrace();
}





    }

}
