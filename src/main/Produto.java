package main;

public class Produto {

	public double preco;

	public Produto(double preco) {
		super();
		this.preco = preco;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public double obterPreco(int quanti){
		if(quanti <= 0) {
			return 0.0;
		}
		if(preco <= 0) {
			return 0.0;
		}
		return  preco * quanti;
	}
}
