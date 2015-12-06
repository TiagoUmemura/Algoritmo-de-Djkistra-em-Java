/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caminhominimo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Documentois
 */
public class Dijkstra {
    public Dijkstra(){
        
    }
    /*
    *grafo
    *lista com tdos os vertices add
    *String com id do vertice fonte
    */
    public void doDijkstra(GrafoListaAdjacencia grafo, List<String> listVertAdd, String source){
        grafo.getVertice(source).setDist(0);//seta distancia do source para zero
        //System.out.println("dist source " + grafo.getVertice(source).getDist());
        double distVert = 999999999;
        int count = 0;//numero de iterações
        while(!listVertAdd.isEmpty()){//lista Q
            distVert = 999999999;
            String verticeMenor = "";//menor dist
            for(int i = 0; i < listVertAdd.size(); i++){//pegar o vertice com a menor dist
                Vertice u = grafo.getVertice(listVertAdd.get(i));
                if(u.getDist() < distVert){
                    distVert = u.getDist();
                    verticeMenor = listVertAdd.get(i);
                }
            }
            listVertAdd.remove(verticeMenor);//remove o vertice de distMenor, já foi visitado
            List<String> vertAdj = new ArrayList<String>();
            List<Vertice> vertAdj2 = new ArrayList<Vertice>();
            Vertice u = grafo.getVertice(verticeMenor);//vertice u, da vez
            vertAdj2 = grafo.getVerticesAdjacentes(u);//adj de u
            for(int i = 0; i < vertAdj2.size(); i++){//salvar em lista de string usando o id
                Vertice v = vertAdj2.get(i);
                vertAdj.add(v.getId());
            }//////
            //for each neighbor v of u:     where v is still in Q.
            for(int i = 0; i < vertAdj.size(); i++){
                double alt;
                double distUV;//de u até v
                Vertice v = grafo.getVertice(vertAdj.get(i));
                distUV = Double.parseDouble(v.getId()) - Double.parseDouble(u.getId()); //aresta id de v - id de u
                if(distUV < 0){
                    distUV = Math.abs(distUV);
                }
                
                alt = u.getDist() + distUV;
                if(alt < v.getDist()){
                   grafo.getVertice(v.getId()).setDist(alt);
                   grafo.getVertice(v.getId()).setPrev(u.getId());
                }
            }
            count++;
            System.out.println("Count: " + count);
        }
        System.out.println("Dist: " + grafo.getVertice("309").getDist());    
    }
}
