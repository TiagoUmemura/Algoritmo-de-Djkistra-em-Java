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
public class Vertice {
     private String id;
     private double dist;
     private String prev;//o pai desse vertice no caminho minimo
    //private double peso = Double.POSITIVE_INFINITY;

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }
    
    public Vertice(){
        this.id = String.valueOf(getClass().hashCode());
    }
    
    public Vertice(String id){
        this.id = id;
    }

    public double getDist() {
        return dist;
    }

    public void setDist(double dist) {
        this.dist = dist;
    }
    
    public String getId(){
        return this.id;
    }
    
    public void setId(String id){
        this.id = id;
    }
}    