package view.paginas;

import javax.swing.JPanel;

//Define uma pagina abstrata para ser decorada
public abstract class PaginaAbstrata
{
    protected JPanel panel;

    public abstract void carregar();

    public JPanel getPanel()
    {
        return panel;
    }
}