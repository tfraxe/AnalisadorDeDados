package model.graficos;

import java.io.IOException;

import org.jfree.ui.ApplicationFrame;

import model.ColunaIncompativelException;
import model.graficos.Grafico;
import model.graficos.charts.GraficoBarrasRelativoChart;
import model.Tabela;

public class GraficoBarrasRelativo implements Grafico
{
    public ApplicationFrame calcular(int coluna) throws ColunaIncompativelException
    {
        try
        {
            String nome_coluna = Tabela.getTabela().get(0)[coluna];
            GraficoBarrasRelativoChart absoluto = new GraficoBarrasRelativoChart("Grafico relativo", "Grafico de barras relativo de " + nome_coluna, coluna);
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