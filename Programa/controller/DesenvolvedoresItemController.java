package controller;

import controller.ItemController;
import java.awt.Desktop;
import java.net.URI;
import java.net.URL;
import javax.swing.JOptionPane;

//Controlador da execucao do item desenvolvedores da barra de menu
public class DesenvolvedoresItemController implements ItemController
{
    public void executar(String texto)
    {
        if(texto == "Desenvolvedores")
        {
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if(desktop != null && desktop.isSupported(Desktop.Action.BROWSE))
            {
                try
                {
                    URL url = new URL("https://github.com/tfraxe/AnalisadorDeDados");
                    desktop.browse(url.toURI());
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Nao foi possivel acessar a pagina:\nhttps://github.com");
                }
            }
        }
    }
}