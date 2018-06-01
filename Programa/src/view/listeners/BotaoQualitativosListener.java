package view.listeners;

import java.awt.event.ActionEvent;

import view.listeners.BotaoGraficoAbstrato;

public class BotaoQualitativosListener extends BotaoGraficoAbstrato
{
    public BotaoQualitativosListener()
    {
        super();
    }

    public void actionPerformed(ActionEvent e)
    {
        super.notificacao.grafico = GraficoListener.getGraficoQualitativo();
        super.actionPerformed(e);
    }
}