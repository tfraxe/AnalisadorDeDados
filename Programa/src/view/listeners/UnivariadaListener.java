package view.listeners;

import view.listeners.AnaliseAbstrata;
import java.awt.event.ActionEvent;

public class UnivariadaListener extends AnaliseAbstrata
{
    private static String operacao_selecionada = null;

    public UnivariadaListener()
    {
        super("Escolha uma coluna");
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