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
public class Aresta<U extends Vertice,V extends Vertice> {
    private Vertice v1 = null;
    private Vertice v2 = null;
    
    public Aresta(V v1,V v2){
        this.v1 = v1;
        this.v2 = v2;
    }
    
    public Vertice getVertice1(){
        return this.v1;
    }
    
    public void setVertice1(Vertice v1){
        this.v1 = v1;
    }
    
    public Vertice getVertice2(){
        return this.v2;
    }
    
    public void setVertice2(Vertice v2){
        this.v2 = v2;
    }
}