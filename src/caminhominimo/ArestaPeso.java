/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caminhominimo;

/**
 *
 * @author Documentois
 */
public class ArestaPeso extends Aresta<Vertice,Vertice> {
    public String peso;
    
    public ArestaPeso(Vertice v1,Vertice v2,String peso){
        super(v1,v2);
        this.peso = peso;
    }
    
    public String getPeso(){
        return this.peso;
    }
    
    public void setPeso(String peso){
        this.peso = peso;
    }
}
