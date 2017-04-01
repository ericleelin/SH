package UIFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by eric.li on 2017/3/24.
 */
public class Browser {
    WebDriver dr;
    public Browser(int driverType) {
        switch ( driverType ) {
            case 1:
                setUpChrome ( );
                break;
            case 2:
                setUpFirefox ( );
                break;
            case 3:
                setUpIE ( );
                break;
            default:
                setUpChrome ( );
        }
    }
    public  void setUpChrome(){
        System.setProperty ( "webdriver.chrome.driver", "C://Program Files//Java//jdk1.8.0_121\\bin//chromedriver.exe");
        dr=new ChromeDriver (  );
        dr.manage ().window ().maximize ();
        dr.get ( "http://www.baidu.com" );
        dr.findElement ( By.id ( "kw" ) ).sendKeys ( "12306" );

    }
    public  void setUpFirefox(){
        System.setProperty ( "webdriver.gecko.driver", "C:\\Program Files\\Java\\jdk1.8.0_121\\bin\\geckdriver.exe");
        dr=new FirefoxDriver (  );
        dr.manage ().window ().maximize ();
    }
    public  void setUpIE(){
        System.setProperty ( "webdriver.ie.driver", "C:\\Program Files\\Java\\jdk1.8.0_121\\bin\\IEDriverServer.exe");
        dr=new InternetExplorerDriver (  );
        dr.manage ().window ().maximize ();
    }



    public static void main( String[] args ) {
        Browser browser=new Browser (1);
    }
}
