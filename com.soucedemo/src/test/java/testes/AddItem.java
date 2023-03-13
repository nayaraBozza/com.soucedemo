package testes;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddItem {

    @Test
    public void testAdditem(){

        //Caminho para informar onde esta o driver do Selenium
        System.setProperty("webdriver.chrome.driver","C:\\Users\\wanes\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");

        // Abrir o navegador
        WebDriver navegador = new ChromeDriver();
        navegador.get("https://www.saucedemo.com");
        navegador.manage().window().maximize();

        //Adicionando Itens
        navegador.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        navegador.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        navegador.findElement(By.ByClassName.className("shopping_cart_container")).click();
        //Finalizando a compra
        navegador.findElement(By.id("checkout")).click();

    }

}
