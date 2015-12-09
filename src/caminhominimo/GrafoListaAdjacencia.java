/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caminhominimo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Documentois
 */
public class GrafoListaAdjacencia implements Grafo<Vertice,Aresta<Vertice,Vertice>> {
    HashMap<Vertice,ArrayList<Vertice>> grafo = new HashMap<Vertice,ArrayList<Vertice>>();
    HashMap<String, Vertice> grafo2 = new HashMap<String, Vertice>();
    @Override
    public ArrayList<Vertice> getVerticesAdjacentes(Vertice u) {//funcionando
        if(u != null && this.grafo.containsKey(u))
            return this.grafo.get(u);
        else
            return null;
    }
    
    /*
    retorna a lista com todos os vertices do grafo(sai repetido)
    */   
    @Override
    public ArrayList<Vertice> getVertices() {//funcionando
        ArrayList<Vertice> keys = new ArrayList<Vertice>();
        ArrayList<Vertice> listVertices = new ArrayList<Vertice>();
        try{
            keys.addAll(grafo.keySet());
            return keys;
            /*for(int i=0;i<keys.size();i++)
            listVertices.addAll(grafo.get(keys.get(i)));

            listVertices.addAll(keys);

            return listVertices;*/
        }finally{
            keys = null;
            listVertices = null;
        }
    }

    @Override
    public ArrayList<Aresta<Vertice, Vertice>> getArestas() {
        ArrayList<Aresta<Vertice,Vertice>> list = new ArrayList<Aresta<Vertice,Vertice>>();
        ArrayList<Vertice> keys = new ArrayList<Vertice>();

        try{
            keys.addAll(this.grafo.keySet());
            ArrayList<Vertice> vertices = null;
            for(int i=0;i<keys.size();i++){
                vertices = this.grafo.get(keys.get(i));
                for(int j=0;j<vertices.size();j++){
                    Aresta a = new Aresta(new Vertice(keys.get(i).getId()), new Vertice(vertices.get(j).getId()));
                    if(a != null)
                        list.add(a);
                }
            }
            return list;
        }finally{
            list = null;
            keys = null;
        }
    }

    @Override
    public Vertice getVertice(String id) { //funcionando
        if(this.grafo2.containsKey(id)){
            return grafo2.get(id);
        }
        return null;
    }

    @Override
    public void adicionaVertice(Vertice verticeNoGrafo, Vertice verticeAdicionado) {//funcionando
        if(verticeNoGrafo != null && verticeAdicionado != null && this.grafo.containsKey(verticeNoGrafo)){
            this.grafo.get(verticeNoGrafo).add(verticeAdicionado);
        }
    }

    /*
    * Adciona um vertice no grafo, sem ligação com outro vertice
    * Cria uma chave para o vertice que leva a um arraylist de vertice adjacentes
    */
    @Override
    public void adicionaVertice(Vertice verticeAdicionado, String id) {//funcionando
        if(!grafo2.containsKey(id)){
            this.grafo.put(verticeAdicionado, new ArrayList<Vertice>());
            this.grafo2.put(id, verticeAdicionado);//add hash de string para o vertice de id da string
        }
        else{
            //System.out.println("Vertice ja existente");
        }
    }

    @Override
    public void adicionaAresta(Aresta<Vertice, Vertice> arestaAdicionada) {
        if(grafo.containsKey(arestaAdicionada.getVertice1())){
              if(grafo.get(arestaAdicionada.getVertice1()).contains(arestaAdicionada.getVertice2()))
                  //throw new RuntimeException("O grafo já contem o vértice especificado");
                  System.out.println("O grafo já contem o vertice especificado");
              else
                  grafo.get(arestaAdicionada.getVertice1()).add(arestaAdicionada.getVertice2());
          }else{
              ArrayList<Vertice> list = new ArrayList<Vertice>();
              list.add(arestaAdicionada.getVertice2());
              grafo.put(arestaAdicionada.getVertice1(), list);
              //list.clear();
              list = null;
          }
    }
    
}
