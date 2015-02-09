package model;

import Page.PageI;

public class PageFactory {
    public static <T>  T  initElements(org.openqa.selenium.WebDriver driver, java.lang.Class<T> pageClassToProxy) {
        PageI page = (PageI) org.openqa.selenium.support.PageFactory.initElements(driver, pageClassToProxy);
        page.setDriver(driver);
        return (T) page;
    }
}