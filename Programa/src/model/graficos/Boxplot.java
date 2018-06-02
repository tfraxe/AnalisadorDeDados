package model.graficos;

import javax.swing.JFrame;

import model.ColunaIncompativelException;
import model.graficos.Grafico;
import model.graficos.charts.BoxplotChart;
import model.Tabela;

public class Boxplot implements Grafico
{
    public JFrame calcular(int coluna) throws ColunaIncompativelException
    {
        try
        {
            String nome_coluna = Tabela.getTabela().get(0)[coluna];
            BoxplotChart chart = new BoxplotChart("Boxplot", "Boxplot de " + nome_coluna, coluna);
            return chart;
        }
        catch(ColunaIncompativelException e)
        {
            throw e;
        }
    }

    public JFrame calcular(int coluna1, int coluna2) throws ColunaIncompativelException
    {
        return null;
    }
}