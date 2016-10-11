/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizAdjacente;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gomes
 */
public class Leitura {

    public static final MatrizAdjacente leitura(String diretorio) {
        MatrizAdjacente grafo = null;
        try {
            BufferedReader leitura = new BufferedReader(new FileReader(diretorio));
            String linha = leitura.readLine();
            grafo = new MatrizAdjacente(Integer.valueOf(linha.substring(linha.lastIndexOf('\t') + 1)));//numero de vertices
            leitura.readLine();//descarta numero de arestas 
            while (leitura.ready()) {
                linha = leitura.readLine();             
                grafo.adicionarAresta(
                        Integer.valueOf(linha.substring(0,linha.indexOf('\t'))),
                        Integer.valueOf(linha.substring(linha.indexOf('\t')+1,linha.lastIndexOf('\t'))),
                        Double.valueOf(linha.substring(linha.lastIndexOf('\t')+1)));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Leitura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Leitura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Leitura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return grafo;
    }
}
