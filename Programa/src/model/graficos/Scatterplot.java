package model.graficos;

import java.io.IOException;

import javax.swing.JFrame;

import model.ColunaIncompativelException;
import model.graficos.Grafico;
import model.graficos.charts.ScatterplotChart;
import model.Tabela;

public class Scatterplot implements Grafico
{
    public JFrame calcular(int coluna) throws ColunaIncompativelException
    {
        return null;
    }

    public JFrame calcular(int coluna1, int coluna2) throws ColunaIncompativelException
    {
        try
        {
            String nome_coluna1 = Tabela.getTabela().get(0)[coluna1];
            String nome_coluna2 = Tabela.getTabela().get(0)[coluna2];
            ScatterplotChart chart = new ScatterplotChart("Scatterplot", "Scatterplot entre " + nome_coluna1 + " e " + nome_coluna2, coluna1, coluna2);
            return chart;
        }
        catch(ColunaIncompativelException e)
        {
            throw e;
        }
    }
}