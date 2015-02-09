package tests;


import Page.Finance;
import Page.Kurs;
import model.Compare;
import model.File;
import model.Worksheet;
import org.junit.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import model.PageFactory;

import java.util.concurrent.TimeUnit;


public class FirstTest {
    private FirefoxDriver driver;

    @BeforeClass
    public static void beforeRun() {
        File file = new File();
        file.remove();
        file.create();
    }

    @Before
    public void openBrowser() {
        this.driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void closeBrowser() {
        this.driver.quit();
        this.driver = null;
    }

    @Test
    public void usdTest() {
        Worksheet worksheet = new Worksheet();
        Finance financePage = PageFactory.initElements(this.driver, Finance.class);
        financePage.get();
        financePage.goToNbuTab();
        String usdFinanceValue = financePage.getUsdValue();

        Kurs kurs = PageFactory.initElements(this.driver, Kurs.class);
        kurs.get();
        kurs.megbankTabOpen();
        String usdKursValue = kurs.getUsdCellValue();


        boolean res = new Compare(usdFinanceValue, usdKursValue).getResult();
        worksheet.setFinanceUsd(usdFinanceValue)
                .setKursUsd(usdKursValue)
                .setResultUsd(res)
                .save();

        Assert.assertTrue( "Difference more then 30% for USD", res);

    }

    @Test
    public void eurTest() {
        Worksheet worksheet = new Worksheet();

        Finance financePage = PageFactory.initElements(this.driver, Finance.class);
        financePage.get();
        financePage.goToNbuTab();
        String usdFinanceValue = financePage.getEurValue();

        Kurs kurs = PageFactory.initElements(this.driver, Kurs.class);
        kurs.get();
        kurs.megbankTabOpen();
        String usdKursValue = kurs.getEurCellValue();

        boolean res = new Compare(usdFinanceValue, usdKursValue).getResult();
        worksheet.setFinanceEur(usdFinanceValue).setKursEur(usdKursValue).setResultEur(res).save();
        Assert.assertTrue("Difference more then 30% for EUR", res);
    }
}