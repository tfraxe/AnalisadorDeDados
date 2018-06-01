package model.graficos;

import java.io.IOException;

import org.jfree.ui.ApplicationFrame;

import model.ColunaIncompativelException;
import model.graficos.Grafico;
import model.graficos.charts.HistogramaChart;
import model.Tabela;

public class Histograma implements Grafico
{
    public ApplicationFrame calcular(int coluna) throws ColunaIncompativelException
    {
        try
        {
            String nome_coluna = Tabela.getTabela().get(0)[coluna];
            HistogramaChart chart = new HistogramaChart("Histograma", "Histograma de " + nome_coluna, coluna);
            return chart;
        }
        catch(ColunaIncompativelException e)
        {
            throw e;
        }
    }

    public ApplicationFrame calcular(int coluna1, int coluna2) throws ColunaIncompativelException
    {
        return null;
    }
}