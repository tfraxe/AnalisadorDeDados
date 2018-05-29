package controller;

import view.paginas.PaginaInicial;
import controller.ItemController;
import gerenciamento.Gerenciador;

public class FecharItem implements ItemController
{
    public void executar()
    {
        if(Gerenciador.getPagina() instanceof PaginaInicial)
        {
            PaginaInicial pagina = (PaginaInicial)Gerenciador.getPagina();
            pagina.limparCentro();
        }
    }
}