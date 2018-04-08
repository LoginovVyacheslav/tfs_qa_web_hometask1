import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public enum  BrowserFactory {
    chrome {
        public WebDriver create() {
            updateProperty("chrome");
            return new ChromeDriver();
        }
    },/*
    Edge {
        public WebDriver create() {
            updateProperty("Edge");
            return new EdgeDriver();
        }
    },*/
    firefox {
        public WebDriver create() {
            updateProperty("firefox");
            return new FirefoxDriver();
        }
    };

    public WebDriver create() {
        return null;
    }

    void updateProperty(String browserName) {
        System.out.println(String.format("\nstarting %s-browser......", browserName));
        if (System.getProperty("browser") == null) System.setProperty("browser", browserName);
    }
}
