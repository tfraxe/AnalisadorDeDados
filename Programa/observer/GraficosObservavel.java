package observer;

import observer.GraficosObservador;

public interface GraficosObservavel
{
    public void adicionarGraficosObservador(GraficosObservador observador);

    public void removerGraficosObservador(GraficosObservador observador);

    public void notificarGraficosObservadores();
}