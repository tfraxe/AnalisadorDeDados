package view.listeners;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

import view.listeners.GraficoListener;
import view.listeners.TabelaListener;
import observer.Observavel;
import observer.NotificacaoGrafico;

public abstract class BotaoGraficoAbstrato extends Observavel implements ActionListener
{
    protected NotificacaoGrafico notificacao;

    protected BotaoGraficoAbstrato()
    {
        super();
        this.notificacao = new NotificacaoGrafico();
    }

    public void actionPerformed(ActionEvent e)
    {
        this.notificacao.coluna1 = TabelaListener.getPrimeiraColuna();
        this.notificacao.coluna2 = TabelaListener.getSegundaColuna();
        TabelaListener.resetColunas();
        if(this.notificacao.coluna1 == this.notificacao.coluna2)
            JOptionPane.showMessageDialog(null, "Escolha colunas diferentes");
        else if(this.notificacao.grafico != null && this.notificacao.coluna1 >= 0)
        {
            super.notificacao = this.notificacao;
            super.notificarObservadores();
        }
    }
}