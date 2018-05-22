package view.paginas;

import javax.swing.JPanel;
import view.paginas.PaginaAbstrata;

//Classe abstrata do padrao de projeto decorator para paginas
public abstract class DecoradorPagina extends PaginaAbstrata
{
    protected PaginaAbstrata pagina;

    public DecoradorPagina(PaginaAbstrata pagina)
    {
        this.pagina = pagina;
        super.panel = pagina.panel;
    }

    public JPanel getPanel()
    {
        return super.panel;
    }
}