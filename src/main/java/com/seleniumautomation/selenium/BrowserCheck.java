package com.seleniumautomation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

public class BrowserCheck {

    private static String path;
    private static String site;

    // CONSTRUTORES
    public BrowserCheck(String pathParam, String siteParam) {
        path = pathParam;
        site = siteParam;
    }

    // main method para abrir o browser
    public void open() {
        // iniciar webdriver
        System.setProperty("webdriver.chrome.driver", path + "\\chromedriver.exe");
        WebDriver chrome = new ChromeDriver();

        // inicializar o formulário
        FormActions form = new FormActions(chrome, site);
        form.openPage();

        // esperar 5 segundos
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //        chrome.close();

    }

    // getters and setters for class variable
    public void setPath(String path) {
        this.path = path;
    }

    public static String getPath() {
        return path;
    }

    public static String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }


}
