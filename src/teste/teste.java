/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import matrizAdjacente.Dijkstra;
import matrizAdjacente.Leitura;
import matrizAdjacente.MatrizAdjacente;
import matrizAdjacente.Prim;
import matrizAdjacente.Vertice;

/**
 *
 * @author Gomes
 */
public class teste {

    public static void main(String[] args) {
//        caminho minimo
        Dijkstra d = new Dijkstra(Leitura.leitura("C:\\Users\\guilh\\Documents\\NetBeansProjects\\Grafos4\\src\\teste\\v_00500_a0010000.grafo"));
        try {
            int vi = 2;
            d.solucao(vi);
            for (int i = 0; i < d.vertices.length; i++) {
                System.out.println("Do vertice " + vi + " para " + i + " tem a distância de " + d.vertices[i].distancia
                        + " e o seu caminho é " + d.caminho(i));
            }
        } catch (Exception ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        }

//        //arvore geradora minima
//        Vertice[] vl = new Vertice[3];
//        vl[0] = new Vertice(0, 0, 0);
//        vl[1] = new Vertice(1, 3, 0);
//        vl[2] = new Vertice(2, 3, -4);
//        MatrizAdjacente grafo = new MatrizAdjacente(3);
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                grafo.adicionarAresta(vl[i], vl[j]);
//            }
//        }
//        System.out.println("Arvore geradora Minima");
//        for (int i = 0; i < grafo.numeroDeVertices(); i++) {
//            System.out.print("|");
//            for (int j = 0; j < grafo.numeroDeVertices(); j++) {
//                System.out.print(grafo.ma[i][j] + "|");
//            }
//            System.out.println("");
//        }
//        Prim p = new Prim(grafo, vl);
//        try {
//            p.solucao(0);
//            for (int i = 0; i < 3; i++) {
//                System.out.println("Do vertice 0 para " + i + " tem a distância de " + p.vertices[i].distancia
//                        + " e o seu caminho é " + p.caminho(i));
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        //menor caminho
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                grafo.adicionarAresta(vl[i], vl[j]);
//            }
//        }
//        System.out.println("Menor Caminho");
//        for (int i = 0; i < grafo.numeroDeVertices(); i++) {
//            System.out.print("|");
//            for (int j = 0; j < grafo.numeroDeVertices(); j++) {
//                System.out.print(grafo.ma[i][j] + "|");
//            }
//            System.out.println("");
//        }
//        Dijkstra d = new Dijkstra(grafo, vl);
//        try {
//            d.solucao(0);
//            for (int i = 0; i < 3; i++) {
//                System.out.println("Do vertice 0 para " + i + " tem a distância de " + d.vertices[i].distancia
//                        + " e o seu caminho é " + d.caminho(i));
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
