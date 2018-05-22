package controller;

import controller.ItemController;

//Controlador da execucao do item salvar da barra de menu
public class SalvarItemController implements ItemController
{
    public void executar(String texto)
    {
        if(texto == "Salvar")
        //Apenas um teste
            System.out.println("clicou salvar");
    }
}