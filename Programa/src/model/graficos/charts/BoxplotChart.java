package model.graficos.charts;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.io.*;
import java.util.Date;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.axis.*;

import org.jfree.data.statistics.BoxAndWhiskerXYDataset;
import org.jfree.data.statistics.DefaultBoxAndWhiskerXYDataset;
import org.jfree.data.statistics.BoxAndWhiskerCalculator;

import org.jfree.ui.ApplicationFrame;

import model.ColunaIncompativelException;
import model.Tabela;
import model.graficos.charts.Chart;

public class BoxplotChart extends Chart
{ 
	private  ArrayList<String[]> tabela = Tabela.getTabela();
	
	public BoxplotChart(String applicationTitle, String chartTitle, int coluna) throws ColunaIncompativelException
	{
		super(applicationTitle);
		if(coluna >= 0 && coluna < tabela.get(0).length)
		{
			try
			{
				JFreeChart grafico = ChartFactory.createBoxAndWhiskerChart(chartTitle, "Nome da Coluna", "Valores", createDataset(coluna), true);
				XYPlot plot = grafico.getXYPlot();
				plot.setDomainAxis(new SymbolAxis("", new String[] { tabela.get(0)[coluna] }));
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

	private BoxAndWhiskerXYDataset createDataset(int coluna) throws ColunaIncompativelException
	{ 
		DefaultBoxAndWhiskerXYDataset dataset = new DefaultBoxAndWhiskerXYDataset("Tecnicas");
		int tamanho_tabela = tabela.size();
      	ArrayList<Double> listaValores = new ArrayList<Double>();
	    if(tabela != null && tamanho_tabela > 1 && coluna >= 0)
	    {
		    try
		    {
		        int n_NaN = 0;
		        for(int i = 1; i < tamanho_tabela; i++)
		        {
		            String valor = tabela.get(i)[coluna];
		            if(!valor.equals("NaN") && !valor.equals("")) 
		                listaValores.add(Double.parseDouble(valor));
		            else
		                n_NaN++;
                }
                dataset.add(new Date(0), BoxAndWhiskerCalculator.calculateBoxAndWhiskerStatistics(listaValores));	           
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