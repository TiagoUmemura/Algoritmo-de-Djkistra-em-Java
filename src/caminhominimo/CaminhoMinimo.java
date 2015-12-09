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
        //4
        for(int i = 4; i < 100000; i++){//adicionar todos os vertices, lista para controle do que ja foi add  arqString.size()
            String[] split = arqString.get(i).split("\t"); //pegar a string na posição e dar split por tab
            //if(!listVertAdd.contains(split[0])){
                Vertice v = new Vertice(split[0]);
                //listVertAdd.add(split[0]);
                grafo.adicionaVertice(v, split[0]);
            //}
            //if(!listVertAdd.contains(split[1])){
                Vertice v1 = new Vertice(split[1]);
                //listVertAdd.add(split[1]);
                grafo.adicionaVertice(v1, split[1]);
            //}
            Vertice v2 = grafo.getVertice(split[0]);//vertice da colun 1
            v2.setDist(99999999);//dist infinita
            Vertice v3 = grafo.getVertice(split[1]);//vertice da colun 2
            v3.setDist(99999999);//distancia infinita
            grafo.adicionaVertice(v2, v3);//add adj
            if(i %1000 == 0){
                System.out.println("i: " + i);
            }
        }
        String source = "5";
        Dijkstra dijkstra = new Dijkstra();
        GrafoListaAdjacencia grafoMin = dijkstra.doDijkstra(grafo, listVertAdd, source);
        
        String target = "15";//definir o vertice alvo
        System.out.println("Vertice alvo: " + target);
        if(grafoMin.getVertice(target).getPrev() != null){
            while(!target.equals(source)){
            System.out.println("Prev: " + grafoMin.getVertice(target).getPrev());
            target = grafoMin.getVertice(target).getPrev();
            }
        }else{
            System.out.println("");
        }
        System.out.println("Dist: " + grafoMin.getVertice("15").getDist());
    }
    
}
