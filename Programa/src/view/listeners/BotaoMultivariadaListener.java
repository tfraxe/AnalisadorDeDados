package view.listeners;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import view.listeners.AnaliseMultivariadaListener;
import view.listeners.TabelaListener;
import observer.Observavel;
import observer.NotificacaoMultivariada;

public class BotaoMultivariadaListener extends Observavel implements ActionListener
{
    private NotificacaoMultivariada notificacao;

    public BotaoMultivariadaListener()
    {
        super();
        this.notificacao = new NotificacaoMultivariada();
    }

    public void actionPerformed(ActionEvent e)
    {
        this.notificacao.operacao = AnaliseMultivariadaListener.getOperacao();
        this.notificacao.coluna1 = TabelaListener.getPrimeiraColuna();
        this.notificacao.coluna2 = TabelaListener.getSegundaColuna();
        TabelaListener.resetColunas();
        if(this.notificacao.operacao != null && this.notificacao.coluna1 >= 0 && this.notificacao.coluna2 >= 0)
        {
            super.notificacao = this.notificacao;
            super.notificarObservadores();
        }
    }
}