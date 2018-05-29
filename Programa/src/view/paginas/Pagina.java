package view.paginas;

import view.paginas.PaginaAbstrata;
import javax.swing.JPanel;

//Classe concreta que representa uma pagina em branco da aplicacao
public class Pagina extends PaginaAbstrata
{
    public Pagina()
    {
        super.panel = new JPanel();
    }

    public void carregar() { }
}