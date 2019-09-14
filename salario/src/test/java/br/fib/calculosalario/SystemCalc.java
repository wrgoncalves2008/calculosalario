package br.fib.calculosalario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SystemCalc {
	
	//variaveis com as urls das paginas a serem acessadas 
	private String pathDriver = "/home/willians/eclipse/chromedriver";
	private String homeurl = "http://192.168.5.115:9098";
	private String paginaCadastroDeCalculos = "http://192.168.5.115:9098/calculator/new";
	
	//Variaveis com os nomes dos campos na pagina de cadastro de novo salario
	private String campoNome = "name";
	private String campoDependentes = "dependents";
	private String campoHorasTrabalhadas = "timeToWork";
	private String campoSalarioHora = "salaryHour";
	private String botaoSubmit = "salvar";
		
	private WebDriver driver;
	
	public void irParaHomePage() {
		
		driver = SeleniumDrive.chromeDriver(pathDriver);
		irParaPagina( homeurl );			
	}
	
	public void cadastrarNovoCalculoDeSalario( String nome, int dependentes, int horasTrabalhadas, double salarioPorHora )
	{
		irParaPagina( paginaCadastroDeCalculos);
		
		alimentarCampo(campoNome, nome);
		alimentarCampo(campoDependentes, String.valueOf(dependentes));
		alimentarCampo(campoHorasTrabalhadas, String.valueOf(horasTrabalhadas));
		alimentarCampo(campoSalarioHora, String.valueOf(salarioPorHora));
		salvarCalculo();		
		
	}	
	
	public boolean calculoRegistrado( String nome, String salario ) {
		boolean achouNome = driver.getPageSource().contains(nome);
		boolean achouSalarioBruto = driver.getPageSource().contains(salario);
		
		return (achouNome && achouSalarioBruto);
	}
	
	public boolean mostrouMensagemDeErro( String mensagem ) {	
		boolean achouMensagem = driver.getPageSource().contains(mensagem);
		return achouMensagem;
	}
	
	
	public void fecharSistema() {
		driver.close();
	}
	
	private void irParaPagina( String url ) {
		driver.get( url );			
	}
	
	private void alimentarCampo( String nomeCampo , String value )
	{
		WebElement campo = driver.findElement(By.name(nomeCampo));
		campo.clear();
		campo.sendKeys(value);		
	}
	
	private void salvarCalculo() {
		WebElement botao = driver.findElement(By.id(botaoSubmit));
		botao.submit();		
	}
	
}
