package view.janelas;

import observer.MenuObservador;
import observer.MenuObservavel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import javax.swing.JMenuItem;

/* Processa a escolha do item da barra de menu de uma janela
   Faz uso do padrao de projeto observer pois implementa a interface MenuObservavel. */
public class JanelaMenuListener implements ActionListener, MenuObservavel
{
    private LinkedList<MenuObservador> observadores;

    public JanelaMenuListener()
    {
        observadores = new LinkedList<MenuObservador>();
    }

    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() instanceof JMenuItem)
        {
            JMenuItem menu_item = (JMenuItem)event.getSource();
            notificarMenuObservadores(menu_item);
        }
    }

    public void adicionarMenuObservador(MenuObservador observador)
    {
        observadores.add(observador);
    }

    public void removerMenuObservador(MenuObservador observador)
    {
        observadores.remove(observador);
    }

    public void notificarMenuObservadores(JMenuItem menu_item)
    {
        for(MenuObservador item : observadores)
            item.selecionouMenuItem(menu_item);
    }
}