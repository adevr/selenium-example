package com.seleniumautomation.selenium;

public class Main {
    public static void main(String[] args) {

        // variavel de ambiente para a localização da chromedriver
        String path = System.getenv("SDRIVER");
        String site = "http://localhost:8080";

        // write code to pass path variable to BrowserCheck class
        BrowserCheck browser = new BrowserCheck(path, site);
        browser.open();



    }
}
