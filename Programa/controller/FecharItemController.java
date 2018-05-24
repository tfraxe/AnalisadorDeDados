package controller;

import controller.ItemController;
import gerenciamento.Gerenciador;
import view.paginas.PaginaInicial;

//Controlador da execucao do item fechar da barra de menu
public class FecharItemController implements ItemController
{
    public void executar(String texto)
    {
        if(texto == "Fechar")
        {
            if(Gerenciador.getPagina() instanceof PaginaInicial)
            {
                PaginaInicial pagina = (PaginaInicial)Gerenciador.getPagina();
                pagina.limparCentro();
            }
        }
    }
}