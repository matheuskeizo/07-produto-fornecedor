package br.fiap.util;

import br.fiap.fornecedor.Fornecedor;
import br.fiap.produto.Produto;

import java.awt.*;

import static java.lang.Long.*;
import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.Double.*;
import static javax.swing.JOptionPane.*;


public class Util {
    private Fornecedor[] fornecedor = new Fornecedor[2];
    private Produto[] produto = new Produto[2];
    private int idxProduto=0;
    private int idxFornecedor=0;
    public void menuPrincipal (){
        int opcao = 0;
        String menu = "1.Cadastrar produto \n2.Pesquisar produto por nome\n3.Pesquisar fornecedor por CNPJ\n4.Finalizar";
        while(opcao !=4){
            opcao= parseInt(showInputDialog(menu));
            if(opcao==1){
                cadastraProduto();
            }else {
                if(opcao==2){
                    pesquisarProduto();
                }else{
                    if(opcao==3){
                        pesquisar();

                    }
                }
            }
        }
    }

    private void pesquisar(){
        String aux = "";
        Fornecedor fornecedor = pesquisarFornecedor();
        if(fornecedor !=null){
            aux+= "Fornecedor : "+ fornecedor.getNome() + "\n";
            aux+= "CNPJ : "+ fornecedor.getCnpj() + "\n";
            showMessageDialog(null,aux);
        }
    }

    private void cadastraProduto (){
        String nome;
        int qtdEstoque;
        double valor;
        Fornecedor fornecedor = pesquisarFornecedor();

           if(fornecedor==null) {
               fornecedor=cadastrarFornecedor();
           }else{
               nome = showInputDialog("Nome do produto");
               qtdEstoque = parseInt(showInputDialog("Qtd em estoque"));
               valor = parseDouble(showInputDialog("Valor unitário"));
               produto[idxProduto] = new Produto(nome,qtdEstoque,valor,fornecedor);
               idxProduto++;
           }
    }

    private void pesquisarProduto (){
        String aux = "Produto não encontrado";
        String nome = showInputDialog("Nome do produto");
        for(int i=0;i<idxProduto;i++){
            if(produto[i].getNome().equalsIgnoreCase(nome)){
                aux="";
                aux += "Nome do produto: " + nome + "\n";
                aux += "Valor unitário: R$" + produto[i].getValor() + "\n";
                aux += "Nome fornecedor: " + produto[i].getFornecedor().getNome() + "\n";
            }
        }
        showMessageDialog(null,aux);
    }

    private Fornecedor pesquisarFornecedor (){
        long cnpj = parseLong(showInputDialog("CNPJ DO FORNECEDOR"));
        for(int i=0;i<idxFornecedor;i++){
            if(fornecedor[i].getCnpj()==cnpj){
                return fornecedor[i];
            }
        }
        showMessageDialog(null,"CNPJ não cadastrado");
        return null;
    }

    private Fornecedor cadastrarFornecedor(){
        long cnpj = parseLong(showInputDialog("CNPJ do fornecedor"));
        String nome = showInputDialog("Nome do CNPJ");
        fornecedor[idxFornecedor] = new Fornecedor(nome,cnpj);
        idxFornecedor++;
        return fornecedor[idxFornecedor-1];
    }
}
