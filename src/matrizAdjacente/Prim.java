/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizAdjacente;

import java.util.List;

/**
 *
 * @author Gomes
 */
public class Prim {

    private final MatrizAdjacente grafo;
    public Vertice vertices[];

    public Prim(MatrizAdjacente grafo, Vertice[] vertices) {
        this.grafo = grafo;
        this.vertices = vertices;
    }
    
    public Prim(MatrizAdjacente grafo){
        this.grafo = grafo;
        this.vertices = new Vertice[grafo.numeroDeVertices()];
        for (int i = 0; i < grafo.numeroDeVertices(); i++) {
            vertices[i]= new Vertice(i);
        }
    }

    public void solucao(int atual) throws Exception {
        for (Vertice vertice : vertices) {//caso faça uma pesquisa com outro ponto de partida
            vertice.encontrado = Vertice.NAO_ENCONTRADO;
            vertice.distancia = Double.POSITIVE_INFINITY;
            vertice.pai = Vertice.NAO_TEM;
        }
        vertices[atual].distancia = grafo.ma[atual][atual];
        for (int count = 0; count < grafo.numeroDeVertices(); count++) {//checa todos os vertices
            vertices[atual].encontrado = Vertice.ENCONTRADO;
            List<Integer> adj = grafo.listDeAdjacentes(atual);
            for (int i = 0; i < adj.size(); i++) {//atualizar pai e menor aresta
                if (vertices[adj.get(i)].distancia > grafo.ma[atual][adj.get(i)] && vertices[adj.get(i)].encontrado == Vertice.NAO_ENCONTRADO) {
                    vertices[adj.get(i)].distancia = grafo.ma[atual][adj.get(i)];
                    vertices[adj.get(i)].pai = vertices[atual].index;
//                    System.out.println(vertices[adj.get(i)].distancia);
                }
            }
            Vertice aux = new Vertice(atual, 0, 0);
            for (Vertice vertice : vertices) {//encontrar menor distancia
                if (vertice.encontrado == Vertice.NAO_ENCONTRADO && vertice.distancia <= aux.distancia) {
                    aux = vertice;//<=...garante que tem que troque o atual por alguém que não foi visitado 
                }
            }
            atual = aux.index;
        }
    }

    public String caminho(int destino) {
        String caminho = "";
        for (; vertices[destino].pai != Vertice.NAO_TEM; destino = vertices[destino].pai) {
            caminho = String.valueOf(vertices[destino].index) + (("".equals(caminho)) ? caminho : "-" + caminho);
        }
        return String.valueOf(vertices[destino].index) + (("".equals(caminho)) ? caminho : "-" + caminho);
    }
}
