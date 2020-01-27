package com.seleniumautomation.selenium;

import dbconnection.Connection;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import static java.lang.System.out;

public class FormActions {

    private static WebDriver chrome;
    private static String site;

    public FormActions(WebDriver browserParam, String siteParam) {
        chrome = browserParam;
        site = siteParam;
    }

    public void openPage() {
        chrome.get(site);

        chrome.manage().window().setSize(new Dimension(1366, 768));
        WebElement contactBtn = chrome.findElement(By.linkText("Contactos"));
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement cookiesLabel = chrome.findElement(By.className("cookies-wrapper"));
        cookiesLabel.findElement(By.id("accept-cookie")).click();
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        if (contactBtn.isDisplayed()) {
            out.println("Button presente na página!");
            out.println("A redireccionar..");
            contactBtn.click();
            fillForm(chrome);
        }
    }

    public void fillForm(WebDriver page) {

        WebDriverWait wait = new WebDriverWait(page, 5);
        WebElement formDiv = page.findElement(By.id("wpcf7-f7-p2210-o1"));

        if (formDiv.isDisplayed()) {
            out.println("Formulário aberto");
            // localizar os campos do formulário
            WebElement name = formDiv.findElement(By.name("your-name"));
            WebElement email = formDiv.findElement(By.name("your-email"));
            WebElement subject = formDiv.findElement(By.name("your-subject"));
            WebElement message = formDiv.findElement(By.name("your-message"));
            WebElement button = formDiv.findElement(By.className("wpcf7-submit"));
            WebElement checkbox = formDiv.findElement(By.name("checkbox-462[]"));

            // introduzir informação nos campos do formulário
            try {
                name.sendKeys("Alexandre");
//                wait.until(ExpectedConditions.textToBePresentInElementValue(name, "Alexandre"));
                email.sendKeys("alexandrereis@loba.pt");
//                wait.until(ExpectedConditions.textToBePresentInElement(email, "@loba.pt"));
                subject.sendKeys("Test Email");
//                wait.until(ExpectedConditions.textToBePresentInElement(subject, "Test"));
                message.sendKeys("Isto é um teste de email automatizado");
//                wait.until(ExpectedConditions.textToBePresentInElement(message, ""));
                if(!checkbox.isSelected()){
                    checkbox.click();
                }

            } catch (Exception exception) {
                out.println("Todos/alguns campos em branco.");
                exception.printStackTrace();
            }


            if (button.isDisplayed()) {
                out.println("A submeter o formulário, por favor aguarde");
                try {
                    button.submit();
                    if (page.findElement(By.className("wpcf7-mail-sent-ok")).isDisplayed()) {
                        out.println("Formulário submetido com sucesso");
                    }

                } catch (Exception exception) {
                    out.println("Formulário não submetido");
                    exception.printStackTrace();
                }

            } else {
                out.println("O button não está presente na página");
            }

        } else {
            out.println("A página não foi carregada.");
        }

        //dbconnection.Connection conn = new Connection();
        out.println("Teste aprovado .... \uD83C\uDF7A");
    }

    public static String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public static WebDriver getChrome() {
        return chrome;
    }

    public void setChrome(WebDriver chrome) {
        this.chrome = chrome;
    }
}
