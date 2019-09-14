package br.fib.calculosalario;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculoSalarioTest {
	
	private SystemCalc calc;
	
	@Before
	public void gotoHomePage()
	{
		calc = new SystemCalc();
		calc.irParaHomePage();		
	}
	
	@Test
	public void calculaSalarioSemInformarDependentes() {
		calc.cadastrarNovoCalculoDeSalario("funcionario" , 0, 5 , 1000.0);
		assertTrue(calc.calculoRegistrado("funcionario", "5.000"));
	}
	
	@Test
	public void naoAceitarCalculoSemInformarHoras() {
		calc.cadastrarNovoCalculoDeSalario("funcionario sem horas" , 0, 0 , 1000.0);
		assertTrue(calc.mostrouMensagemDeErro("deve ser maior ou igual a 1"));
		
	}
	
	@Test
	public void naoAceitarCalculoSemInformarSalario() {
		calc.cadastrarNovoCalculoDeSalario("funcionario sem salario" , 0, 8 , 0.0);
		assertTrue(calc.mostrouMensagemDeErro("deve ser maior ou igual a 1"));	
	}
	
	@Test
	public void calculaSalarioInformandoQtdeDeDependentes() {
		calc.cadastrarNovoCalculoDeSalario("funcionario com dependentes" , 1, 8 , 100.0);
        assertTrue(calc.calculoRegistrado("funcionario com dependentes", "850"));		
	}
		
	
	@After
	public void fecharSistema()
	{
		calc.fecharSistema();		
	}
	
	

}
