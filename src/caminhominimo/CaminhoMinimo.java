/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caminhominimo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Documentois
 */
public class CaminhoMinimo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Arquivo arq = new Arquivo();
        List<String> arqString = new ArrayList<String>();
        List<String> listVertAdd = new ArrayList<String>();//lista de vertices adicionados
        GrafoListaAdjacencia grafo = new GrafoListaAdjacencia();
        arqString = arq.TxtToString();
        System.out.println("Tamanho:" + arqString.size());
        
        for(int i = 4; i < 500; i++){//adicionar todos os vertices, lista para controle do que ja foi add  arqString.size()
            String[] split = arqString.get(i).split("\t"); //pegar a string na posição e dar split por tab
            if(!listVertAdd.contains(split[0])){
                Vertice v = new Vertice(split[0]);
                listVertAdd.add(split[0]);
                grafo.adicionaVertice(v);
            }
            if(!listVertAdd.contains(split[1])){
                Vertice v1 = new Vertice(split[1]);
                listVertAdd.add(split[1]);
                grafo.adicionaVertice(v1);
            }
            Vertice v2 = grafo.getVertice(split[0]);//vertice da colun 1
            v2.setDist(99999999);//dist infinita
            Vertice v3 = grafo.getVertice(split[1]);//vertice da colun 2
            v3.setDist(99999999);//distancia infinita
            grafo.adicionaVertice(v2, v3);//add adj
        }

        System.out.println("Quant de v: " + listVertAdd.size());
        /*List<Vertice> vertAdj = new ArrayList<Vertice>();
        Vertice v = grafo.getVertice("1");
        vertAdj = grafo.getVerticesAdjacentes(v);
        String t = "";
        for(int i = 0; i < vertAdj.size(); i++){
            t += vertAdj.get(i).getId() + " ";
        }
        System.out.println("Adj: " + t);
        */
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.doDijkstra(grafo, listVertAdd, "3");
    }
    
}
