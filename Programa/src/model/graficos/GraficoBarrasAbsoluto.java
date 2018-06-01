package model.graficos;

import java.io.IOException;

import org.jfree.ui.ApplicationFrame;

import model.ColunaIncompativelException;
import model.graficos.Grafico;
import model.graficos.charts.GraficoBarrasAbsolutoChart;
import model.Tabela;

public class GraficoBarrasAbsoluto implements Grafico
{
    public ApplicationFrame calcular(int coluna) throws ColunaIncompativelException
    {
        try
        {
            String nome_coluna = Tabela.getTabela().get(0)[coluna];
            GraficoBarrasAbsolutoChart absoluto = new GraficoBarrasAbsolutoChart("Grafico absoluto", "Grafico de barras absoluto de " + nome_coluna, coluna);
            return absoluto;
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