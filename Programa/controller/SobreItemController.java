package controller;

import javax.swing.JOptionPane;
import controller.ItemController;

//Controlador da execucao do item sobre da barra de menu
public class SobreItemController implements ItemController
{
    public void executar(String texto)
    {
        if(texto == "Sobre")
            JOptionPane.showMessageDialog(null, "Equipe:\nAbner Lima\nAnderson Nobre\nEdealcia Regina\nTiago Fontenele\nThiago Fraxe");
    }
}