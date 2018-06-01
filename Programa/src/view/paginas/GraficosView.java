package view.paginas;

import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

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
            ApplicationFrame frame = n.resultado;
            frame.pack();
			RefineryUtilities.centerFrameOnScreen(frame);
			frame.setVisible(true);
        }  
    }
}