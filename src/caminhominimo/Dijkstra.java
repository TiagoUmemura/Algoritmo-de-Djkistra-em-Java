/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caminhominimo;

import java.util.ArrayList;
import java.util.HashMap;
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
    public GrafoListaAdjacencia doDijkstra(GrafoListaAdjacencia grafo, String source, HashMap<String, Double> arestaHash){
        
        grafo.getVertice(source).setDist(0);//seta distancia do source para zero
        HashMap<String, String> listaVerticeHash = new HashMap<String, String>();
        List<String> listaVertice = new ArrayList<String>();//lista com todos os vertices
        List<Vertice> listaVertice2 = new ArrayList<Vertice>();
        List<String> listaVerticeVisitados = new ArrayList<String>();//vertices cinzas na teoria
        HashMap<String, String> listaVerticeVisitadosHash = new HashMap<String, String>();
        double distVert = 999999999;
        int count = 0;//numero de iterações
        
        listaVertice2 = grafo.getVertices();
        for(int i = 0; i < listaVertice2.size(); i++){//preencher lista com todos os vertices
            listaVertice.add(listaVertice2.get(i).getId());
            listaVerticeHash.put(listaVertice2.get(i).getId(), listaVertice2.get(i).getId());
        }
        System.out.println("Quant de v: " + listaVertice.size());
        listaVerticeVisitados.add(source);//lista de vertices visitados
        listaVerticeVisitadosHash.put(source, source);
                
        while(!listaVerticeVisitados.isEmpty()){//lista Q
            distVert = 999999999;
            String verticeMenor = "";//menor dist
            for(int i = 0; i < listaVerticeVisitados.size(); i++){//pegar o vertice com a menor dist
                Vertice u = grafo.getVertice(listaVerticeVisitados.get(i));
                if(u.getDist() < distVert){//menor vertice dist
                    distVert = u.getDist();
                    verticeMenor = listaVerticeVisitados.get(i);
                    //System.out.println("vertmo: " + verticeMenor);
                }
            }
            listaVertice.remove(verticeMenor);//remove o vertice de distMenor,
            listaVerticeVisitados.remove(verticeMenor);//remove
            listaVerticeHash.remove(verticeMenor);//remove
            listaVerticeVisitadosHash.remove(verticeMenor);
            List<String> vertAdj = new ArrayList<String>();
            List<Vertice> vertAdj2 = new ArrayList<Vertice>();
            Vertice u = grafo.getVertice(verticeMenor);//vertice u, da vez
            vertAdj2 = grafo.getVerticesAdjacentes(u);//adj de u
            for(int i = 0; i < vertAdj2.size(); i++){//salvar em lista de string usando o id
                Vertice v = vertAdj2.get(i);
                vertAdj.add(v.getId());
                if(!listaVerticeVisitadosHash.containsKey(v.getId()) && listaVerticeHash.containsKey(v.getId())){
                    listaVerticeVisitados.add(v.getId());
                    listaVerticeVisitadosHash.put(v.getId(), v.getId());
                }
            }//////
            //para cada vizinho v de u. V nao sai da lista
            for(int i = 0; i < vertAdj.size(); i++){
                double alt;
                double distUV;//de u até v
                Vertice v = grafo.getVertice(vertAdj.get(i));
                String arestachave = "";
                arestachave = v.getId() + u.getId();
                distUV = arestaHash.get(arestachave); //aresta id de v - id de u
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
