package testes;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Before;
import org.junit.After;


public class LoginTest {
    public  WebDriver navegador;
    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\wanes\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        navegador = new ChromeDriver();
    }
    @After
    Public void NoDriver() throws InterruptedException{
        if(navegador != null ){
            navegador.quit();
        }else {
            System.out.println("Navigated to Home page");
        }
    }
    @Test(priority = 1 )
    public void testLoginSource() {

        // Abrir o navegador
        navegador.get("https://www.saucedemo.com");
        navegador.manage().window().maximize();

        //Localizando elementos e inserindo texto de entrada
        navegador.findElement(By.id("user-name")).sendKeys("standard_user");
        navegador.findElement(By.id("password")).sendKeys("secret_sauce");
        navegador.findElement(By.name("submit")).click();
        navegador.close();

        // Verificar se o login foi bem-sucedido
        WebElement productsLabel = navegador.findElement(By.className("form_group"));
        if (!productsLabel.getText().equals("Products")) {
            // Se o login não foi bem-sucedido, verificar criticidade e registrar um bug
            verificarCriticidadeERegistrarBug("Bug de Implementação", "Login bem-sucedido não redirecionou para a página correta", "High");
        }

        // Fechar o navegador
        navegador.close();
    }


    //Fluxo Principal - Teste de Login mal-Sucedido,Credenciais Incorretas
    @Test(priority = 2)
    public void NoLogin(){

        testLoginSource("usuario_incorreto", "senha_incorreta");

    }
    @Test(priority = 3)
    public void WhiteLogin(){
        WebElement errorLabel = navegador.findElement(By.cssSelector("[data-test='error']"));
        if(!errorLabel.getText().isEmpty()) {
            testLoginSource("");

        }
    }
    public void verificarCriticidadeERegistrarBug(String tipo, String descricao, String criticidade){
        switch (criticidade.toLowerCase()) {
            case "Blocker":
                registrarBug("Bug Bloqueado", tipo, descricao);
                break;
            case "High":
                registrarBug("Bug Alta Criticidade", tipo, descricao);
                break;
            case "Medium":
                registrarBug("Bug Média Criticidade", tipo, descricao);
                break;
            case "Low":
                registrarBug("Bug Baixa Criticidade", tipo, descricao);
                break;
            default:
                System.out.println("Criticidade não reconhecida: " + criticidade);
        }
    }

    private void registrarBug(String tipo, String descricao, String criticidade) {
        System.out.println("Bug registrado: Tipo - " + tipo + ", Descrição - " + descricao + ", Criticidade - " + criticidade);

        // Chamar a API do Jira para criar um bug
        try {
            criarBugNoJira(tipo, descricao, criticidade);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }

}
