package UIFramework;

import Brosers.Add;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Screenshots.takeScreenShot;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by eric.li on 2017/3/24.
 */
public class Selenider  {
    WebDriver dr;
 public   Selenider(int driverType) {
     switch ( driverType ) {
         //启动火狐
         case 1:
             Configuration.browser = "marionette";
             break;
         //启动谷歌
         case 2:
             Configuration.browser = "chrome";
             break;
         //启动ie
         case 3:
             Configuration.browser = "ie";
             break;
         default:
             Configuration.browser = "chrome";

     }
 }
    public WebDriver getDriver() {
        dr=WebDriverRunner.getWebDriver ();
        return  dr;
 }
 public  String getdate() {
     String dates;
     Date date=new Date (  );
     SimpleDateFormat simpleDateFormat =new SimpleDateFormat ("yyyy-MM-dd-HH-mm-ss");
     dates=simpleDateFormat.format ( date );
    return  dates;
 }

public void screenshot() {
    String filename;
    sleep ( 1000 );
    Configuration.screenshots = Boolean.valueOf ( true );
    Configuration.savePageSource = Boolean.valueOf ( true );
     filename=getdate ();
    takeScreenShot ( filename);
}

public void swithtoframe(String frame){
     getDriver ().switchTo ().frame ( frame );
}



    public static void main(String args[]){
Selenider selenider=new Selenider (2);
        Add add=new Add();
        add.jiao(0,2);
        open("http://120.55.85.190:1090/");
        $(By.xpath ( ".//a[@href='/web?db=odoo10siheng_ding']" )).click ();
        $(By.xpath ( ".//*[@id='login']" )).sendKeys ( "admin" );
        $(By.xpath ( ".//*[@id='password']" )).sendKeys ( "admin" );
        $(".btn.btn-primary").submit ();
//        selenider.screenshot ();
        Configuration.holdBrowserOpen=Boolean.valueOf ( true );
//        sleep ( 3000 );
//        Configuration.holdBrowserOpen=Boolean.valueOf ( false );
//        ((JavascriptExecutor) selenider.getDriver ())
//                .executeScript("window.scrollTo(0,3000)");
//        sleep ( 100000);
//        $( By.linkText ( "外语" )).click ();

//        $( By.id ( "kw")).sendKeys ( "12306" );
//        $(By.id ( "su" )).click ();

//        sleep ( 10000 );
//        selenider.getDriver ().get ( "http://www.360.cn");
//        selenider.getDriver ().close ();
}
}
