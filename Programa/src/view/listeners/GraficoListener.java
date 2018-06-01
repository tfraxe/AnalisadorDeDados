package view.listeners;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.util.BotaoRadio;
import java.util.HashSet;
import java.awt.event.ActionEvent;

public class GraficoListener implements ActionListener 
{
    private static String grafico_quantitativo;
    private static String grafico_qualitativo;
    private boolean primeira_vez;
    protected String mensagem;
    private HashSet<String> quantitativos;
    private HashSet<String> qualitativos;

    public GraficoListener()
    {
        this.mensagem = "Escolha uma coluna";
        primeira_vez = true;
        grafico_quantitativo = null;
        grafico_qualitativo = null;
        quantitativos = new HashSet<String>();
        quantitativos.add("Histograma");
        quantitativos.add("Tabela Quantitativos");
        quantitativos.add("Boxplot");
        quantitativos.add("Scatterplot");
        qualitativos = new HashSet<String>();
        qualitativos.add("Tabela Contingencia");
        qualitativos.add("Tabela Qualitativos");
        qualitativos.add("Grafico de barras absoluto");
        qualitativos.add("Grafico de barras relativo");
    }

    public static String getGraficoQuantitativo()
    {
        return grafico_quantitativo;
    }

    public static String getGraficoQualitativo()
    {
        return grafico_qualitativo;
    }

    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() instanceof BotaoRadio)
        {
            BotaoRadio fonte = (BotaoRadio)event.getSource();
            String grafico_selecionado = fonte.getText();
            if(quantitativos.contains(grafico_selecionado))
                grafico_quantitativo = grafico_selecionado;
            if(qualitativos.contains(grafico_selecionado))
                grafico_qualitativo = grafico_selecionado;
            if(primeira_vez)
            {
                if(grafico_selecionado.equals("Scatterplot"))
                    mensagem = "Escolha duas colunas";
                JOptionPane.showMessageDialog(null, mensagem);
                primeira_vez = false;
            }
        }
    }
}
