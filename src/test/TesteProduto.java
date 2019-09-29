package test;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import main.Produto;

@RunWith(MockitoJUnitRunner.class)
public class TesteProduto {

	private Produto produto;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testarObterPreco() {
		produto = new Produto(50.0);
		double result = produto.obterPreco(2);
		Assertions.assertEquals(result, 100.0);
	}

	@Test
	public void testarObterPrecoProdutoNegativo() {
		produto = new Produto(-80.0);
		double result = produto.obterPreco(3);
		Assertions.assertEquals(result, 0.0);
	}

	@Test
	public void testarObterPrecoQuantidadeNegativa() {
		produto = new Produto(10.0);
		double result = produto.obterPreco(-1);
		Assertions.assertEquals(result, 0.0);
	}	

}
