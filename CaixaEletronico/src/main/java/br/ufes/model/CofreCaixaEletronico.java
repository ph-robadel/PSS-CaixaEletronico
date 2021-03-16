package br.ufes.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author pedroh
 */
public class CofreCaixaEletronico {
    private ArrayList<EstoqueDinheiro> listaDinheiro;

    public CofreCaixaEletronico(ArrayList<EstoqueDinheiro> listaDinheiro) {
        if(listaDinheiro == null){
            throw new RuntimeException("Lista não pode ser nula");
        }
        
        this.listaDinheiro = listaDinheiro;
        ordenarDinheiro();
    }
    
    public void add(EstoqueDinheiro estoqueDinheiro){
        this.listaDinheiro.add(estoqueDinheiro);
        ordenarDinheiro();
    }
    
    /**
     * Ordena a lista de dinheiro (Notas e/ou moedas) pelo seu valor. Ordena do maior para o menor.
     * 
     */
    private void ordenarDinheiro(){
        Collections.sort(this.listaDinheiro);
    }
    
    public String sacar(double valorTotal){
        StringBuilder sb = new StringBuilder();
        double valorRestante = valorTotal;
        int quantidadeDinheiro = 0;
        
        for(EstoqueDinheiro dinheiro : listaDinheiro){
            if(dinheiro.getValor() > valorRestante) continue;
            
            quantidadeDinheiro = (int) (valorRestante/dinheiro.getValor());
            
            while(quantidadeDinheiro > 0 && !dinheiro.isPossuiQuantidade(quantidadeDinheiro) ){
                quantidadeDinheiro--;
            }
            
            try{
                dinheiro.retirarDinheiro(quantidadeDinheiro);
                valorRestante -= dinheiro.getValor() * quantidadeDinheiro;
                sb.append(quantidadeDinheiro).append(" x R$ ").append(dinheiro.getValor()).append("\n");
            }catch(RuntimeException re){}
        }
        
        if(valorRestante > 0.009d)
            throw new RuntimeException("Não é possível sacar R$ "+valorTotal);
        
        return sb.toString();
    }
    
    public void ReporDinheiro(double valorDinheiro, int quantidade){
        for(EstoqueDinheiro dinheiro : this.listaDinheiro){
            if(dinheiro.getValor() == valorDinheiro){
                dinheiro.inserirDinheiro(quantidade);
                return;
            }
        }
        
        throw new RuntimeException("Não foi encontrado o dinheiro informado");
    }
    
}
