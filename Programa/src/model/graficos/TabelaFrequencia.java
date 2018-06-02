package model.graficos;

import java.util.*;
import java.io.*;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

import model.ColunaIncompativelException;
import model.graficos.Grafico;
import model.Tabela;

public class TabelaFrequencia implements Grafico
{
    public JFrame calcular(int coluna) throws ColunaIncompativelException
    {
        ArrayList<String[]> tabela = Tabela.getTabela();
        if(coluna >= 0 && coluna < tabela.get(0).length)
        {
            HashMap<String, Double> qtdPorValor = new HashMap<String, Double>();
		    Set<String> linhasDistintas = new HashSet<String>();
	        int tamanho_tabela = tabela.size();
	        if(tabela != null && tamanho_tabela > 1)
	        {
		        for (int i = 1; i < tamanho_tabela; i++)
		        {
		    	    String tupla = tabela.get(i)[coluna];
		    	    if(!qtdPorValor.containsKey(tupla))
		    	    {
		    		    qtdPorValor.put(tupla, 1.0);
		    		    linhasDistintas.add(tupla);
		    	    }
		    	    else
		    		    qtdPorValor.put(tupla, qtdPorValor.get(tupla) + 1.0);
		        }
		    }   
		    HashMap<Integer, String> indicesLinha = new HashMap<Integer, String>();
		    int i = 0;
		    for(String item : linhasDistintas)
		    {
			    indicesLinha.put(i, item);
			    i++;			
		    }
		    Object[][] matrizDados = new Object[linhasDistintas.size() + 1][3];
		    matrizDados[linhasDistintas.size()][0] = (Object) "Total";
		    double[] somaColuna = new double[2];
		    for (int j = 0; j < linhasDistintas.size(); j++) 
		    {
			    String nomeDaLinha = indicesLinha.get(j);
			    matrizDados[j][0] = nomeDaLinha;
			    for (int k = 1; k < 3; k++)
			    {
				    Double freqAbsoluta = qtdPorValor.get(nomeDaLinha);
				    if(k == 1)
				    {
					    matrizDados[j][k] = freqAbsoluta;
					    somaColuna[k-1] += freqAbsoluta;
				    }
				    else
				    {
					    matrizDados[j][k] = freqAbsoluta / tabela.size();
					    somaColuna[k-1] += freqAbsoluta / tabela.size();
				    }
			    }
		    }
		    for (int m = 0; m < somaColuna.length; m++) 
			    matrizDados[linhasDistintas.size()][m+1] = somaColuna[m];
		    String[] nomeColunas = {tabela.get(0)[coluna], "Freq. Absoluta", "Freq. Relativa"};
            JTable tabelaGrafica = new JTable(matrizDados, nomeColunas);
            JFrame frame =  new JFrame();
			JScrollPane scrollPane = new JScrollPane(tabelaGrafica, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			tabelaGrafica.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.setSize(400, 200);
		    return frame;
        }
        return null;
    }

    public JFrame calcular(int coluna1, int coluna2) throws ColunaIncompativelException
    {
        return null;
    }
}