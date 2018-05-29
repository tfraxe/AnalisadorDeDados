package observer;

import observer.Observavel;
import observer.Notificacao;

public abstract class Observador
{
    protected Notificacao notificacao;
    protected Observavel observavel;

    public void setObservavel(Observavel o)
    {
        observavel = o;
    }

    protected void update()
    {
        if(observavel != null)
            notificacao = observavel.getNotificacao();
    }
}