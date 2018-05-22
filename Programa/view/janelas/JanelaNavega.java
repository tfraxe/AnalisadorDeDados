package view.janelas;

import view.janelas.DecoradorJanela;
import view.janelas.JanelaAbstrata;
import view.paginas.PaginaAbstrata;
import javax.swing.*;

//Classe de decoracao de janela. Adiciona a possibilidade de navegar para uma pagina.
public class JanelaNavega extends DecoradorJanela
{
    public JanelaNavega(JanelaAbstrata janela)
    {
        super(janela);
    }

    public void montar()
    {
        super.janela.montar();
    }

    public void navegar(PaginaAbstrata pagina)
    {
        super.frame.setContentPane(pagina.getPanel());
    }
}