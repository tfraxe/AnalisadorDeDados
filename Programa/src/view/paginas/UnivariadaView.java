package view.paginas;

import javax.swing.JOptionPane;

import observer.NotificacaoUnivariada;
import observer.Observador;

public class UnivariadaView extends Observador
{
    public void update()
    {
        super.update();
        if(super.notificacao instanceof NotificacaoUnivariada)
        {
            NotificacaoUnivariada n = (NotificacaoUnivariada)super.notificacao;
            JOptionPane.showMessageDialog(null, n.resultado);
        }  
    }
}