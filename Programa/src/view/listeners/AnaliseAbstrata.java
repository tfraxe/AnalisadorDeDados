package view.listeners;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.util.BotaoRadio;
import java.awt.event.ActionEvent;

public abstract class AnaliseAbstrata implements ActionListener 
{
    private static String operacao_selecionada;
    private boolean primeira_vez;
    protected String mensagem;

    protected AnaliseAbstrata(String mensagem)
    {
        this.mensagem = mensagem;
        primeira_vez = true;
        operacao_selecionada = null;
    }

    protected static String getOperacao()
    {
        return operacao_selecionada;
    }

    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() instanceof BotaoRadio)
        {
            BotaoRadio fonte = (BotaoRadio)event.getSource();
            operacao_selecionada = fonte.getText();
            if(primeira_vez)
            {
                JOptionPane.showMessageDialog(null, mensagem);
                primeira_vez = false;
            }
        }
    }
}