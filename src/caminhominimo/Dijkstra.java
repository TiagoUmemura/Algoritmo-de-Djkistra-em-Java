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
    public GrafoListaAdjacencia doDijkstra(GrafoListaAdjacencia grafo, List<String> listVertAdd, String source){
        grafo.getVertice(source).setDist(0);//seta distancia do source para zero
        List<String> listaVertice = new ArrayList<String>();//lista com todos os vertices
        List<Vertice> listaVertice2 = new ArrayList<Vertice>();
        double distVert = 999999999;
        int count = 0;//numero de iterações
        
        listaVertice2 = grafo.getVertices();
        for(int i = 0; i < listaVertice2.size(); i++){//preencher lista com todos os vertices
            listaVertice.add(listaVertice2.get(i).getId());
        }
        
        while(!listaVertice.isEmpty()){//lista Q
            distVert = 999999999;
            String verticeMenor = "";//menor dist
            for(int i = 0; i < listaVertice.size(); i++){//pegar o vertice com a menor dist
                Vertice u = grafo.getVertice(listaVertice.get(i));
                if(u.getDist() < distVert){//menor vertice dist
                    distVert = u.getDist();
                    verticeMenor = listaVertice.get(i);
                }
            }
            listaVertice.remove(verticeMenor);//remove o vertice de distMenor, já foi visitado
            List<String> vertAdj = new ArrayList<String>();
            List<Vertice> vertAdj2 = new ArrayList<Vertice>();
            Vertice u = grafo.getVertice(verticeMenor);//vertice u, da vez
            vertAdj2 = grafo.getVerticesAdjacentes(u);//adj de u
            for(int i = 0; i < vertAdj2.size(); i++){//salvar em lista de string usando o id
                Vertice v = vertAdj2.get(i);
                vertAdj.add(v.getId());
            }//////
            //para cada vizinho v de u. V nao sai da lista
            for(int i = 0; i < vertAdj.size(); i++){
                double alt;
                double distUV;//de u até v
                Vertice v = grafo.getVertice(vertAdj.get(i));
                distUV = Double.parseDouble(v.getId()) - Double.parseDouble(u.getId()); //aresta id de v - id de u
                if(distUV < 0){
                    distUV = Math.abs(distUV);
                }
                
                alt = u.getDist() + distUV;
                if(alt < v.getDist()){//caminho mais curto encontrado
                   grafo.getVertice(v.getId()).setDist(alt);
                   grafo.getVertice(v.getId()).setPrev(u.getId());
                }
            }
            count++;
            if(count%1000 == 0){
                System.out.println("Count: " + count);
            }
        }
        
        System.out.println("");
        
        return grafo;
    }
}
