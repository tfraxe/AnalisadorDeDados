package controller;

import controller.ItemController;

//Controlador da execucao do item fechar da barra de menu
public class FecharItemController implements ItemController
{
    public void executar(String texto)
    {
        if(texto == "Fechar")
        //Apenas um teste
            System.out.println("clicou fechar");
    }
}