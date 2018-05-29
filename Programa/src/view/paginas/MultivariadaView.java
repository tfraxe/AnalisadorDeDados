package view.paginas;

import javax.swing.JOptionPane;

import observer.NotificacaoCalculoMultivariada;
import observer.Observador;

public class MultivariadaView extends Observador
{
    public void update()
    {
        super.update();
        if(super.notificacao instanceof NotificacaoCalculoMultivariada)
        {
            NotificacaoCalculoMultivariada n = (NotificacaoCalculoMultivariada)super.notificacao;
            JOptionPane.showMessageDialog(null, n.resultado);
        }  
    }
}