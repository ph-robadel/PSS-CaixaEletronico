package br.ufes.principal;

import br.ufes.model.CofreCaixaEletronico;
import br.ufes.model.Dinheiro;
import br.ufes.model.EstoqueDinheiro;
import java.util.ArrayList;

/**
 *
 * @author pedroh
 */
public class Principal {
    public static void main(String[] args) {
        CofreCaixaEletronico caixa = new CofreCaixaEletronico(new ArrayList<EstoqueDinheiro>());
        caixa.add(new EstoqueDinheiro(new Dinheiro(5), 10));
        caixa.add(new EstoqueDinheiro(new Dinheiro(20), 10));
        caixa.add(new EstoqueDinheiro(new Dinheiro(10), 10));
        caixa.add(new EstoqueDinheiro(new Dinheiro(50), 10));
        caixa.add(new EstoqueDinheiro(new Dinheiro(2), 10));
        caixa.add(new EstoqueDinheiro(new Dinheiro(100), 10));
        caixa.add(new EstoqueDinheiro(new Dinheiro(1),20));
        caixa.add(new EstoqueDinheiro(new Dinheiro(0.5),20));
        caixa.add(new EstoqueDinheiro(new Dinheiro(0.25), 20));
        caixa.add(new EstoqueDinheiro(new Dinheiro(0.10), 20));
        caixa.add(new EstoqueDinheiro(new Dinheiro(0.05), 20));
        
        
        try{
            System.out.println(caixa.sacar(247.80)); 
        }catch(RuntimeException rx){
            System.out.println(rx);
        }
        
        try{
            System.out.println(caixa.sacar(150.25)); 
        }catch(RuntimeException rx){
            System.out.println(rx);
        }        
        
    }
}
