package main;

public class Cliente {

	public int desconto;

	public Cliente(int desconto) {
		this.desconto = desconto;
	}

	public double obterValorComDesconto(Pedido pedido) {

		if (this.desconto <= 0.0) {
			return pedido.obterValorBase();
		} else if (this.desconto >= 100) {
			return pedido.obterValorBase();
		}

		return (pedido.obterValorBase() - (pedido.obterValorBase()) * (this.desconto / 100.0));
	}

}
