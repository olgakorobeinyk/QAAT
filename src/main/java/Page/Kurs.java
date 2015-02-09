package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Kurs extends Page {
    @FindBy(css = ".menu_top_level2 li:nth-child(4) a")
    public WebElement megbankTab;

    @FindBy(xpath = "//table[@id='table']//tr[td[1]//a[contains(text(), 'USD')]]/td[3]//span")
    public WebElement usdCell;

    @FindBy(xpath = "//table[@id='table']//tr[td[1]//a[contains(text(), 'EUR')]]/td[3]//span")
    public WebElement eurCell;

    public void megbankTabOpen() {
        megbankTab.click();
    }

    public String getUsdCellValue() {
        return this.usdCell.getText();
    }

    public String getEurCellValue() {
        return this.eurCell.getText();
    }

    public void get() {
        this.driver.get("http://kurs.com.ua/");
    }
}