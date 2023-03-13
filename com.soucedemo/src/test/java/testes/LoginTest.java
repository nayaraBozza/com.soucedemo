package testes;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginTest {
    @Test
    public void testLoginNoSource() {


        //Caminho para informar onde esta o driver do Selenium
        System.setProperty("webdriver.chrome.driver","C:\\Users\\wanes\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");


        // Abrir o navegador
        WebDriver navegador = new ChromeDriver();
        navegador.get("https://www.saucedemo.com");
        navegador.manage().window().maximize();



        //Localizando elementos e inserindo texto de entrada
        navegador.findElement(By.id("user-name")).sendKeys("problem_user");
        navegador.findElement(By.id("password")).sendKeys("secret_sauce");
        navegador.findElement(By.name("submit")).click();
        navegador.close();











    }

}
