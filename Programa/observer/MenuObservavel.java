package observer;

import observer.MenuObservador;
import javax.swing.JMenuItem;

public interface MenuObservavel 
{
    public void adicionarMenuObservador(MenuObservador observador);

    public void removerMenuObservador(MenuObservador observador);

    public void notificarMenuObservadores(JMenuItem menu_item);
}