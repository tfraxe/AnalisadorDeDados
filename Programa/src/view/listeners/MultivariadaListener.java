package view.listeners;

import view.listeners.AnaliseAbstrata;
import java.awt.event.ActionEvent;

public class MultivariadaListener extends AnaliseAbstrata
{
    private static String operacao_selecionada = null;

    public MultivariadaListener()
    {
        super("Escolha duas colunas");
    }

    public static String getOperacao()
    {
        return operacao_selecionada;
    }

    public void actionPerformed(ActionEvent e)
    {
        super.actionPerformed(e);
        operacao_selecionada = super.getOperacao();
    }
}