package observer;

import observer.TabelaObservador;

public interface TabelaObservavel
{
    public void adicionarTabelaObservador(TabelaObservador observador);
    
    public void removerTabelaObservador(TabelaObservador observador);

    public void notificarTabelaObservadores();
}