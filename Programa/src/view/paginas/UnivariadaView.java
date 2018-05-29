package view.paginas;

import javax.swing.JOptionPane;

import observer.NotificacaoCalculoUnivariada;
import observer.Observador;

public class UnivariadaView extends Observador
{
    public void update()
    {
        super.update();
        if(super.notificacao instanceof NotificacaoCalculoUnivariada)
        {
            NotificacaoCalculoUnivariada n = (NotificacaoCalculoUnivariada)super.notificacao;
            JOptionPane.showMessageDialog(null, n.resultado);
        }  
    }
}