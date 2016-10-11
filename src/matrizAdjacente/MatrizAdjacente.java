/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizAdjacente;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Gomes
 */
public class MatrizAdjacente implements grafos.Grafo {

    public double ma[][];

    public MatrizAdjacente(int vertices) {
        this.ma = new double[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                this.ma[i][j] = Double.POSITIVE_INFINITY;
                this.ma[j][j] = 0.0D;
            }
        }
    }

    public void adicionarAresta(Vertice origem, Vertice destino) {
        this.ma[origem.index][destino.index] = Math.sqrt(Math.pow((origem.X - destino.X), 2) + Math.pow((origem.Y - destino.Y), 2));
    }

    @Override
    public void adicionarAresta(int origem, int destino) throws Exception {
        adicionarAresta(origem, destino, 0D);
    }

    @Override
    public void adicionarAresta(int origem, int destino, double peso) throws Exception {
        this.ma[origem][destino] = peso;
    }

    @Override
    public boolean existeAresta(int origem, int destino) {
        return this.ma[origem][destino] != Double.POSITIVE_INFINITY;
    }

    @Override
    public int grauDoVertice(int vertice) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int numeroDeVertices() {
        return this.ma.length;
    }

    @Override
    public int numeroDeArestas() {
        int qtdAresta = 0;
        for (int i = 0; i < this.ma.length; i++) {
            for (int j = 0; j < this.ma[i].length; j++) {
                if (existeAresta(i, j)) {
                    qtdAresta++;
                }
            }
        }
        return qtdAresta;
    }

    @Override
    public List<Integer> listDeAdjacentes(int vertice) throws Exception {
        List adjacentes = new LinkedList();
        for (int i = 0; i < this.ma[vertice].length; i++) {
            if (existeAresta(vertice, i)) {
                adjacentes.add(i);
            }
        }
        return adjacentes;
    }

    @Override
    public Set<Integer> conjuntoDeAdjacentes(int vertice) throws Exception {
        Set adjacentes = new HashSet();
        for (int i = 0; i < this.ma[vertice].length; i++) {
            if (existeAresta(vertice, i)) {
                adjacentes.add(i);
            }
        }
        return adjacentes;
    }

    @Override
    public void setarPeso(int origem, int destino, double peso) throws Exception {
        adicionarAresta(origem, destino, peso);
    }

    @Override
    public Set<Integer> vertices() {
        Set vertices = new LinkedHashSet();
        for (int i = 0; i < this.ma.length; i++) {
            vertices.add(i);
        }
        return vertices;
    }

}
