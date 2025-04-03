package br.fiap.produto;

import br.fiap.fornecedor.Fornecedor;

public class Produto {
    private String nome;
    private double valor;
    private int qtdEstoque;
    private Fornecedor fornecedor;

    public Produto(String nome, int qtdEstoque, double valor, Fornecedor fornecedor) {
        this.nome = nome;
        this.qtdEstoque = qtdEstoque;
        this.valor = valor;
        this.fornecedor= fornecedor;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
