package observer;

import observer.MenuObservavel;
import javax.swing.JMenuItem;

public interface MenuObservador
{
    public void selecionouMenuItem(JMenuItem item);    
}