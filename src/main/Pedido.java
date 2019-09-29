package main;

import java.util.List;

public class Pedido {

	public Cliente cliente;
	public double valorComDesconto;
	public double valorSemDesconto;
	public List<LinhaPedido> linhapDePedidos;

	public Pedido(List<LinhaPedido> linhapDePedidos, Cliente cliente) {
		this.linhapDePedidos = linhapDePedidos;
		this.cliente = cliente;
	}

	public void calcularPreco() {
		for (LinhaPedido linhapDePedidos : linhapDePedidos) {
			this.valorSemDesconto += linhapDePedidos.calcularPreco();
		}
		if (this.valorSemDesconto <= 0.0) {
			this.valorSemDesconto = 0.0;
		}
		this.valorComDesconto = cliente.obterValorComDesconto(this);
		if (this.valorComDesconto <= 0.0) {
			this.valorComDesconto = 0.0;
		}

		System.out.println("Valor com Desconto: " + valorComDesconto);
		System.out.println("Valor sem Desconto: " + valorSemDesconto);
	}

	public double obterValorBase() {
		return this.valorSemDesconto;
	}
}
