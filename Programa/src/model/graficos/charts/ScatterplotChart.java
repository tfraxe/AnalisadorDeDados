package model.graficos.charts;

import java.awt.Color; 
import java.awt.BasicStroke; 
import java.awt.Shape.*;
import java.awt.geom.*;
import java.awt.Dimension;

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

import java.util.*;
import java.io.*;

import model.ColunaIncompativelException;
import model.Tabela;
import model.graficos.charts.Chart;

public class ScatterplotChart extends Chart 
{
    private ArrayList<String[]> tabela = Tabela.getTabela();

    public ScatterplotChart(String applicationTitle, String chartTitle, int col1, int col2) throws ColunaIncompativelException
    {
        super(applicationTitle);
        if(col1 >= 0 && col1 < tabela.get(0).length && col2 >= 0 && col2 < tabela.get(0).length)
        {
            try
            {
                JFreeChart xylineChart = ChartFactory.createScatterPlot(chartTitle,
                                                                        tabela.get(0)[col1],
                                                                        tabela.get(0)[col2],
                                                                        createDataset(col1, col2),
                                                                        PlotOrientation.VERTICAL,
                                                                        true, true, false);   
                ChartPanel chartPanel = new ChartPanel(xylineChart);
                chartPanel.setPreferredSize( new Dimension(800, 400));
                final XYPlot plot = xylineChart.getXYPlot();
                plot.setBackgroundPaint(Color.BLACK);
                XYShapeRenderer renderer = new XYShapeRenderer();
                renderer.setSeriesPaint( 0 , Color.BLUE );
                plot.setRenderer(renderer);  
                setContentPane(chartPanel);
            }
            catch(ColunaIncompativelException e)
            {
                throw e;
            }
        }
    }
   
    private XYDataset createDataset(int coluna1, int coluna2) throws ColunaIncompativelException 
    {
        int tamanho_tabela = tabela.size();
        
        if(tabela != null && tamanho_tabela > 1 && (coluna1 >= 0 && coluna2 >= 0))
        {
            final XYSeries dados = new XYSeries("Dados");
            Double valor2Double;
            Double valor1Double;
            try
            {
                int n_NaN = 0;
                for(int i = 1; i < tamanho_tabela; i++)
                {
                    String valor1 = tabela.get(i)[coluna1];
                    String valor2 = tabela.get(i)[coluna2];

                    if(!valor1.equals("NaN") && !valor2.equals("NaN")) 
                    {
                        valor1Double = Double.parseDouble(valor1);
                        valor2Double = Double.parseDouble(valor2);
                        dados.add(valor1Double, valor2Double);
                    }
                    else
                        n_NaN++;
                }
                final XYSeriesCollection dataset = new XYSeriesCollection();
                dataset.addSeries(dados);
                return dataset;          
            }
            catch(ArithmeticException e)
            {
                throw new ColunaIncompativelException("Nao e possivel gerar scatterplot entre essas duas colunas");   
            }
            catch(NumberFormatException e)
            {
                throw new ColunaIncompativelException("Nao e possivel gerar scatterplot entre essas duas colunas");   
            }
        }         
        return null;
    }
}