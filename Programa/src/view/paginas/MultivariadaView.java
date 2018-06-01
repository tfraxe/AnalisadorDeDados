package view.paginas;

import javax.swing.JOptionPane;

import observer.NotificacaoMultivariada;
import observer.Observador;

public class MultivariadaView extends Observador
{
    public void update()
    {
        super.update();
        if(super.notificacao instanceof NotificacaoMultivariada)
        {
            NotificacaoMultivariada n = (NotificacaoMultivariada)super.notificacao;
            JOptionPane.showMessageDialog(null, n.resultado);
        }  
    }
}