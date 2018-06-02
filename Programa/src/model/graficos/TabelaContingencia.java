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

public class TabelaContingencia implements Grafico
{
    public JFrame calcular(int coluna) throws ColunaIncompativelException
    {
        return null;
    }

    public JFrame calcular(int coluna1, int coluna2) throws ColunaIncompativelException
    {
        ArrayList<String[]> tabela = Tabela.getTabela();
        if(coluna1 >= 0 && coluna1 < tabela.get(0).length && coluna2 >= 0 && coluna2 < tabela.get(0).length)
        {
            HashMap<List<String>, Integer> qtdPorPar = new HashMap<List<String>, Integer>();
		    Set<String> colunasDistintas = new HashSet<String>();
		    Set<String> linhasDistintas = new HashSet<String>();
	        int tamanho_tabela = tabela.size();
	        if(tabela != null && tamanho_tabela > 1)
	        {
		        for (int i = 1; i < tamanho_tabela; i++)
		        {
		    	    List<String> tupla = new LinkedList<String>();
		    	    tupla.add(tabela.get(i)[coluna1]);
		    	    tupla.add(tabela.get(i)[coluna2]);
		    	    colunasDistintas.add(tupla.get(0));
		    	    linhasDistintas.add(tupla.get(1));
		    	    if(!qtdPorPar.containsKey(tupla))
		    		    qtdPorPar.put(tupla, 1);
		    	    else
		    		    qtdPorPar.put(tupla, qtdPorPar.get(tupla) + 1);
		        }
		    }
		    HashMap<Integer, String> indicesColuna = new HashMap<Integer, String>();
		    HashMap<Integer, String> indicesLinha = new HashMap<Integer, String>();
		    int i = 1;
		    for(String item : colunasDistintas)
		    {
			    indicesColuna.put(i, item);
			    i++;			
		    }
		    i = 0;
		    for(String item : linhasDistintas)
		    {
			    indicesLinha.put(i, item);
			    i++;			
		    }
		    Object[][] matrizDados = new Object[linhasDistintas.size() + 1][colunasDistintas.size() + 2];
		    matrizDados[linhasDistintas.size()][0] = (Object) "Total";
		    int[] somaColuna = new int[colunasDistintas.size()];
		    for (int j = 0; j < linhasDistintas.size(); j++) 
		    {
			    String nomeDaLinha = indicesLinha.get(j);
			    matrizDados[j][0] = nomeDaLinha;
			    int somaLinha = 0;
			    for (int k = 1; k < colunasDistintas.size() + 1; k++)
			    {
				    String nomeDaColuna = indicesColuna.get(k);
				    List<String> nomesAcesso = new LinkedList<String>(); 
				    nomesAcesso.add(nomeDaColuna); 
				    nomesAcesso.add(nomeDaLinha);
				    if(qtdPorPar.containsKey(nomesAcesso))
					    matrizDados[j][k] = qtdPorPar.get(nomesAcesso);
				    else
					    matrizDados[j][k] = 0;
				    somaLinha += (Integer)matrizDados[j][k];
				    somaColuna[k-1] += (Integer)matrizDados[j][k];
			    }
			    matrizDados[j][colunasDistintas.size()+1] = somaLinha;
		    }
		    int somaTotalColunas = 0;
		    for (int m = 0; m < somaColuna.length; m++) 
		    {
			    matrizDados[linhasDistintas.size()][m+1] = somaColuna[m];
			    somaTotalColunas += somaColuna[m];
		    }
		    matrizDados[linhasDistintas.size()][colunasDistintas.size() + 1] = somaTotalColunas;
		    String[] nomeColunas = new String[colunasDistintas.size() + 2];
		    StringBuilder nomeHeader = new StringBuilder();
		    nomeColunas[0] = nomeHeader.append(tabela.get(0)[coluna2]).append(" / ").append(tabela.get(0)[coluna1]).toString();
		    nomeColunas[colunasDistintas.size() + 1] = "Total";
            for(int l = 1; l < nomeColunas.length - 1; l++) 
			    nomeColunas[l] = indicesColuna.get(l);
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
}