package view.paginas;

import javax.swing.JFrame;

import observer.NotificacaoGrafico;
import observer.Observador;

public class GraficosView extends Observador
{
    public void update()
    {
        super.update();
        if(super.notificacao instanceof NotificacaoGrafico)
        {
            NotificacaoGrafico n = (NotificacaoGrafico)super.notificacao;
            JFrame frame = n.resultado;
            frame.pack();
			frame.setVisible(true);
        }  
    }
}