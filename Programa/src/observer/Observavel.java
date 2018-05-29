package observer;

import java.util.LinkedList;
import observer.Observador;
import observer.Notificacao;

public abstract class Observavel
{
    protected LinkedList<Observador> observadores;
    protected Notificacao notificacao;

    protected Observavel()
    {
        observadores = new LinkedList<Observador>();
    }

    public void adicionarObservador(Observador observador)
    {
        observadores.add(observador);
        observador.update();
    }

    public void removerObservador(Observador observador)
    {
        observadores.remove(observador);
    }

    public void notificarObservadores()
    {
        for(Observador item : observadores)
            item.update();
    }

    public Notificacao getNotificacao()
    {
        return notificacao;
    }
}