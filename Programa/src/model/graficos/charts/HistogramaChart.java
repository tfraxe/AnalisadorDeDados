package model.graficos.charts;

import java.awt.Color; 
import java.awt.Dimension;
import java.awt.BasicStroke; 
import java.awt.Shape.*;
import java.awt.geom.*;

import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 
import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.xy.XYSeriesCollection; 
import org.jfree.chart.renderer.xy.XYShapeRenderer;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;

import java.util.*;
import java.io.*;

import model.ColunaIncompativelException;
import model.Tabela;
import model.graficos.charts.Chart;

public class HistogramaChart extends Chart  
{
	private ArrayList<String[]> tabela = Tabela.getTabela();
	
	public HistogramaChart(String applicationTitle, String chartTitle, int coluna) throws ColunaIncompativelException
	{
		super(applicationTitle);
		if(coluna >= 0 && coluna < tabela.get(0).length)
		{
			try
			{	
				JFreeChart grafico = ChartFactory.createHistogram(chartTitle, tabela.get(0)[coluna], "Frequência (Absoluta)", createDataset(coluna), PlotOrientation.VERTICAL, true, true, false);
				ChartPanel graficoPanel = new ChartPanel(grafico);
				graficoPanel.setPreferredSize(new Dimension(800, 400));
				setContentPane(graficoPanel);
			}
			catch(ColunaIncompativelException e)
			{
				throw e;
			}
		}
	}

	private HistogramDataset createDataset(int coluna) throws ColunaIncompativelException
	{
      	int tamanho_tabela = tabela.size();
      	if(tabela != null && tamanho_tabela > 1 && (coluna >= 0))
      	{
			List<Double> listaValores = new ArrayList<Double>();
			Set<Double> valoresDistintos = new HashSet<Double>();
	        try
	        {
	            int n_NaN = 0;
	            for(int i = 1; i < tamanho_tabela; i++)
	            {
	            	String valor = tabela.get(i)[coluna];
				   	if(!valor.equals("NaN") && !valor.equals("")) 
				   	{
	            		listaValores.add(Double.parseDouble(valor));
	                	valoresDistintos.add(Double.parseDouble(valor));
	               	}
	              	else
	                	n_NaN++;
	            }
				double minimo = Collections.min(listaValores).doubleValue();
				double maximo = Collections.max(listaValores).doubleValue();
				double[] valores = new double[listaValores.size()];
				for (int j = 0; j < valores.length; j++)
					valores[j] = listaValores.get(j).doubleValue();
			  	HistogramDataset dataset = new HistogramDataset();
			  	dataset.addSeries("Serie 1", valores, valoresDistintos.size(), minimo, maximo);
			  	return dataset;
	        }
	        catch(ArithmeticException e)
	        {
	        	throw new ColunaIncompativelException("Nao e possivel calcular Histograma nessa coluna");   
	        }
	        catch(NumberFormatException e)
	        {
				throw new ColunaIncompativelException("Nao e possivel calcular Histograma nessa coluna");   
	        }
		}
		return null;
	}
}