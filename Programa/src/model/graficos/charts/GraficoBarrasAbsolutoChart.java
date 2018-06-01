package model.graficos.charts;

import java.awt.Dimension;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

import java.util.*;
import java.io.*;

import model.graficos.charts.Chart;
import model.Tabela;
import model.ColunaIncompativelException;

public class GraficoBarrasAbsolutoChart extends Chart
{
	private ArrayList<String[]> tabela = Tabela.getTabela();
	public GraficoBarrasAbsolutoChart(String applicationTitle, String chartTitle, int coluna) throws ColunaIncompativelException
	{
		super(applicationTitle);
		if(coluna >= 0 && coluna < tabela.get(0).length)
		{
			try
			{
				JFreeChart graficoBarras = ChartFactory.createBarChart(chartTitle, "Valores", "Frequência (Absoluta)", createDataset(coluna), PlotOrientation.VERTICAL, true, true, false);
				ChartPanel chartPanel = new ChartPanel(graficoBarras);
				chartPanel.setPreferredSize(new Dimension(800, 400));
				setContentPane(chartPanel);
			}
			catch(ColunaIncompativelException e)
			{
				throw e;
			}
		}
	}

	private CategoryDataset createDataset(int coluna) throws ColunaIncompativelException 
	{
		int tamanho_tabela = tabela.size();
		if(tabela != null && tamanho_tabela > 1 && (coluna >= 0))
	    {
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		    try
		    {
		        int n_NaN = 0;
		        HashMap<String, Integer> qtdPorValor = new HashMap<String, Integer>();
		        for(int i = 1; i < tamanho_tabela; i++)
		        {
		            String valor = tabela.get(i)[coluna];
		            if(!valor.equals("NaN")) 
		            {
		                if(!qtdPorValor.containsKey(valor))
		                 	qtdPorValor.put(valor, 1);
		                else
		                 	qtdPorValor.put(valor, qtdPorValor.get(valor) + 1);
		            }
		            else
		            n_NaN++;
		        }
		        Iterator iter = qtdPorValor.keySet().iterator();
		        while(iter.hasNext())
		        {
		            Object k = iter.next();
		            dataset.addValue(qtdPorValor.get(k), "Serie 1", k.toString());
		        }
		        return dataset;   	           
		    }
		    catch(ArithmeticException e)
		    {
		        throw new ColunaIncompativelException("Não foi possivel gerar gráfico: dado não quantitativo");   
		    }
		    catch(NumberFormatException e)
		    {
				throw new ColunaIncompativelException("Não foi possivel gerar gráfico: dado não quantitativo");   
		    }
	    }
	   return null; 
	}
}