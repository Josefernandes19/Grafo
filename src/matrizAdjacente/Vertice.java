/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizAdjacente;

/**
 *
 * @author Gomes
 */
public class Vertice {

    public static final int NAO_TEM = -1;
    public static final boolean ENCONTRADO = true;
    public static final boolean NAO_ENCONTRADO = false;

    public int index;
    public int X;
    public int Y;
    public int pai = NAO_TEM;
    public double distancia = Double.POSITIVE_INFINITY;
    public boolean encontrado = NAO_ENCONTRADO;

    public Vertice(int index) {
        this.index = index;
    }

    public Vertice(int index, int X, int Y) {
        this.index = index;
        this.X = X;
        this.Y = Y;
    }
}
