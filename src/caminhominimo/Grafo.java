/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caminhominimo;

import java.util.ArrayList;

/**
 *
 * @author Documentois
 */
public interface Grafo<V extends Vertice, A extends Aresta<V,V>> {
    public ArrayList<V> getVerticesAdjacentes(V u);
    public ArrayList<V> getVertices();
    public ArrayList<A> getArestas();
    public V getVertice(String id);
    
    /*
    * @param verticeNoGrafo Vértice que já está no grafo
     * @param verticeAdicionado Vértice sendo adicionado no grafo
     */
    public void adicionaVertice(V verticeNoGrafo, V verticeAdicionado);
	
    /**
     * Adiciona um vértice <code>verticeAdicionado</code> ao grafo.
     * O vértice ficará sem nenhum outro vértice adjacente.
     * @param verticeAdicionado Vértice sendo adicionado ao grafo
     */
    public void adicionaVertice(V verticeAdicionado, String id);
	
    /**
     * Adiciona uma aresta ao grafo. Se algum dos vértices
     * da aresta adicionada já estiverem no grafo eles são
     * sobrepostos
     * 
     * @param arestaAdicionada Aresta adicionada ao grafo
     */
    public void adicionaAresta(A arestaAdicionada);	
}
