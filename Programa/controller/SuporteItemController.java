package controller;

import controller.ItemController;

//Controlador da execucao do item suporte da barra de menu
public class SuporteItemController implements ItemController
{
    public void executar(String texto)
    {
        if(texto == "Suporte")
        //Apenas um teste
            System.out.println("clicou suporte");
    }
}