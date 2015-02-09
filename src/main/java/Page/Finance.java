package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Finance extends Page {

    @FindBy(css = ".sn_menu li:nth-child(4) a")
    public WebElement nbuTab;

    @FindBy(xpath = "//table[contains(@class, 'nbu_rate')]//tr[td[2 and contains(text(), 'EUR')]]/td[4]")
    public WebElement euroValue;

    @FindBy(xpath = "//table[contains(@class, 'nbu_rate')]//tr[td[2 and contains(text(), 'USD')]]/td[4]")
    public WebElement usdValue;

    public void goToNbuTab() {
        nbuTab.click();
    }

    public String getUsdValue()
    {
        return this.usdValue.getText();
    }

    public String getEurValue()
    {
        return this.euroValue.getText();
    }

    public void get() {
        this.driver.get("http://finance.i.ua/");
    }
}