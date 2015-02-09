package Page;

import org.openqa.selenium.WebDriver;

public abstract class Page implements PageI{
    protected WebDriver driver;
    public String URL;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}