package view.listeners;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import observer.Observavel;
import observer.NotificacaoMenu;

public class JanelaMenuListener extends Observavel implements ActionListener
{
    private NotificacaoMenu notificacao;

    public JanelaMenuListener()
    {
        super();
        this.notificacao = new NotificacaoMenu();
    }

    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() instanceof JMenuItem)
        {
            JMenuItem menu_item = (JMenuItem)event.getSource();
            this.notificacao.texto = menu_item.getText();
            super.notificacao = this.notificacao;
            super.notificarObservadores();
        }
    }
}