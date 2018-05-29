package controller;

import javax.swing.JOptionPane;
import controller.ItemController;

public class SobreItem implements ItemController
{
    public void executar()
    {
        JOptionPane.showMessageDialog(null, "Equipe:\nAbner Lima\nAnderson Nobre\nEdealcia Regina\nTiago Fontenele\nThiago Fraxe");
    }
}