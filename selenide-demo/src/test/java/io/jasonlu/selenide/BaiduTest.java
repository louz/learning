package io.jasonlu.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class BaiduTest {
    @Test
    public void testBaiduSearch() {
        /*
             默认启用了WebDriverManager，会自动下载指定浏览器对应的driver
             如果需要显式指定driver的话，需要进行以下设置：

             Configuration.driverManagerEnabled = false;
             System.setProperty("webdriver.gecko.driver", "/path/to/driver");

             详见WebDriverManager的主页说明https://github.com/bonigarcia/webdrivermanager/
             PS：可根据driver的名称搜索各个driver的下载页
        */

                Configuration.browser = "chrome";  // 默认是firefox
        Configuration.baseUrl = "http://www.baidu.com";
//        Configuration.headless = true;

        Configuration.remote = 
        open("/");
        $("#kw").setValue("selenide");
        $("#su").click();

        // 断言
        $$("h3 > a").shouldHave(size(9));

        // 可以获取到WebDriver实例，然后可以操作进行各种底层的操作
        Cookie cookie = new Cookie("key", "value");
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
    }

}
