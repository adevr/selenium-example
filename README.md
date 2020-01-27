# selenium-script

##Selenium chromedriver test

![alt text](https://3.bp.blogspot.com/-bY5Js-Plm8Y/V1aBSPTLz5I/AAAAAAAABio/Rew-CBamQwk7WR_X2dYeDZXdrDPB7o71gCPcB/s1600/selenium-webdriver-java-online-courses-techtutorr.jpg)

Test Scripts developed with webdriver (chromedriver) and selenium ide (firefox/chrome).

### Maven Instalation

First: Install chocolatey

Chocolatey POWERSHELL:

```Set-ExecutionPolicy Bypass -Scope Process -Force; iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))```

Second: 
``` choco install maven ``` to install Maven.


### ChromeDriver

In order to run the test, we need to download the selenium webdriver
[Download chromedriver](https://chromedriver.storage.googleapis.com/index.html?path=73.0.3683.68/)

It's recomended to create a env variable to store de webdriver path. This variable is called under the main.java file.
``` set SDRIVER=C:\PATH\TO\CHROMEDRIVER.EXE ```

[Steps to set Env variable](https://stackoverflow.com/questions/13748784/setting-up-and-using-environmental-variables-in-intellij-idea)


### Clone do Projeto

Once the project is cloned the user must run the command ``` mvn verify ``` to build the maven project.

