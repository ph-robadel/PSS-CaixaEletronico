package br.ufes.model;

/**
 *
 * @author pedroh
 */
public class EstoqueDinheiro implements Comparable<EstoqueDinheiro>{
    private Dinheiro dinheiro;
    private int quantidade;

    public EstoqueDinheiro(Dinheiro dinheiro, int quantidade) {
        this.dinheiro = dinheiro;
        this.quantidade = quantidade;
    }
    
    public void retirarDinheiro(int quantidade){
        if(quantidade <= 0)
            throw new RuntimeException("Quantidade informada é inválida! Ou é nula ou é negativa");
        if(quantidade > this.quantidade)
            throw new RuntimeException("Quantidade insuficiente");
        
        this.quantidade -= quantidade;
    }
    
    public void inserirDinheiro(int quantidade){
        if(quantidade <= 0)
            throw new RuntimeException("Quantidade informada é inválida! Ou é nula ou é negativa");
        
        this.quantidade += quantidade;
    }
    
    public boolean isPossuiQuantidade(int quantidade){
        if(quantidade <= 0)
            throw new RuntimeException("Quantidade informada é inválida! Ou é nula ou é negativa");
        return this.quantidade >= quantidade;
    }
    
    public Dinheiro getDinheiro() {
        return dinheiro;
    }

    public int getQuantidade() {
        return quantidade;
    }
    
    public double getValor(){
        return this.dinheiro.getValor();
    }

    @Override
    public int compareTo(EstoqueDinheiro dinheiro) {
        if(this.dinheiro.getValor() > dinheiro.getValor()) return -1;
        if(this.dinheiro.getValor() < dinheiro.getValor()) return 1;
        return 0;
    }
}
