package view.listeners;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import view.listeners.UnivariadaListener;
import view.listeners.TabelaListener;
import observer.Observavel;
import observer.NotificacaoUnivariada;

public class BotaoUnivariadaListener extends Observavel implements ActionListener
{
    private NotificacaoUnivariada notificacao;

    public BotaoUnivariadaListener()
    {
        super();
        this.notificacao = new NotificacaoUnivariada();
    }

    public void actionPerformed(ActionEvent e)
    {
        this.notificacao.operacao = UnivariadaListener.getOperacao();
        this.notificacao.coluna = TabelaListener.getPrimeiraColuna();
        TabelaListener.resetColunas();
        if(this.notificacao.operacao != null && this.notificacao.coluna >= 0)
        {
            super.notificacao = this.notificacao;
            super.notificarObservadores();
        }
    }
}