package test;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import main.Cliente;
import main.Pedido;

@RunWith(MockitoJUnitRunner.class)
public class TesteCliente {

	private Cliente cliente;

	@Mock
	private Pedido pedido;	
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testarObterValorComDesconto() {
		Mockito.when(pedido.obterValorBase()).thenReturn(100.00);
		cliente = new Cliente(10);
		double result = cliente.obterValorComDesconto(pedido);
		Assertions.assertEquals(result,90.00);
	}	
	
	@Test
	public void testarValorComDescontoZerado() {
		Mockito.when(pedido.obterValorBase()).thenReturn(95.00);
		cliente = new Cliente(0);
		double result = cliente.obterValorComDesconto(pedido);
		Assertions.assertEquals(result,95.00);
	}
	
	@Test
	public void testaValorComDescontoNegativo() {
		Mockito.when(pedido.obterValorBase()).thenReturn(50.00);
		cliente = new Cliente(-10);
		double result = cliente.obterValorComDesconto(pedido);
		Assertions.assertEquals(result,50.00);
	}
	
	@Test
	public void testarValorComCemPorcentoDeDesconto() {
		Mockito.when(pedido.obterValorBase()).thenReturn(300.00);
		cliente = new Cliente(100);
		double result = cliente.obterValorComDesconto(pedido);
		Assertions.assertEquals(result,300.00);
	}
	
	@Test
	public void testarValorComMaisCemPorcentoDeDesconto() {
		Mockito.when(pedido.obterValorBase()).thenReturn(500.00);
		cliente = new Cliente(200);
		double result = cliente.obterValorComDesconto(pedido);
		Assertions.assertEquals(result,500.00);
	}
	
}
