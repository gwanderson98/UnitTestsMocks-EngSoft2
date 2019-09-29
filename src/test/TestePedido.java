package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import main.Cliente;
import main.LinhaPedido;
import main.Pedido;

@RunWith(MockitoJUnitRunner.class)
public class TestePedido {

	@Mock
	private Cliente cliente;
	
	private Pedido pedido;	
	
	private List<LinhaPedido> linhaDePedidos = new ArrayList<>();
	
	@Mock
	private LinhaPedido linhaDePedido1;
	
	@Mock
	private LinhaPedido linhaDePedido2;
	
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		linhaDePedidos.add(linhaDePedido1);
		linhaDePedidos.add(linhaDePedido2);
	}
	
		
	@Test
	public void testOption1() {
		Mockito.when(linhaDePedido1.calcularPreco()).thenReturn(80.00);
		Mockito.when(linhaDePedido2.calcularPreco()).thenReturn(60.00);
		pedido = new Pedido(linhaDePedidos,cliente);
		Mockito.when(cliente.obterValorComDesconto(pedido)).thenReturn(10.0);
		pedido.calcularPreco();
		Assertions.assertEquals(pedido.valorSemDesconto,140.0);
	}
	
	@Test
	public void testOption2() {
		Mockito.when(linhaDePedido1.calcularPreco()).thenReturn(60.00);
		Mockito.when(linhaDePedido2.calcularPreco()).thenReturn(30.00);
		pedido = new Pedido(linhaDePedidos,cliente);
		Mockito.when(cliente.obterValorComDesconto(pedido)).thenReturn(10.0);
		pedido.calcularPreco();
		Assertions.assertEquals(pedido.valorComDesconto,10.0);
	}
	
	@Test
	public void testOption3() {
		Mockito.when(linhaDePedido1.calcularPreco()).thenReturn(80.00);
		Mockito.when(linhaDePedido2.calcularPreco()).thenReturn(20.00);
		pedido = new Pedido(linhaDePedidos,cliente);
		Mockito.when(cliente.obterValorComDesconto(pedido)).thenReturn(-10.0);
		pedido.calcularPreco();
		Assertions.assertEquals(pedido.valorComDesconto,0.0);
	}
	
	@Test
	public void testOption4() {
		Mockito.when(linhaDePedido1.calcularPreco()).thenReturn(-40.00);
		Mockito.when(linhaDePedido2.calcularPreco()).thenReturn(-60.00);
		pedido = new Pedido(linhaDePedidos,cliente);
		Mockito.when(cliente.obterValorComDesconto(pedido)).thenReturn(20.0);
		pedido.calcularPreco();
		Assertions.assertEquals(pedido.valorSemDesconto,0.0);
	}
}
