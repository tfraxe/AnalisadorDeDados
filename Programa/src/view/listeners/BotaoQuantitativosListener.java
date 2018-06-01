package view.listeners;

import java.awt.event.ActionEvent;

import view.listeners.BotaoGraficoAbstrato;

public class BotaoQuantitativosListener extends BotaoGraficoAbstrato
{
    public BotaoQuantitativosListener()
    {
        super();
    }

    public void actionPerformed(ActionEvent e)
    {
        super.notificacao.grafico = GraficoListener.getGraficoQuantitativo();
        super.actionPerformed(e);
    }
}