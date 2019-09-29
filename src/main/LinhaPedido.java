package main;

public class LinhaPedido {
	
	public Produto produto;
	public int quanti;

	public LinhaPedido(Produto produto, int quanti) {
		super();
		this.produto = produto;
		this.quanti = quanti;
	}

	public double calcularPreco() {
		return produto.obterPreco(quanti);
	}
}
