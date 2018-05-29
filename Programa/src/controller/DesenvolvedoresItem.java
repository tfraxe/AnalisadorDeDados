package controller;

import controller.ItemController;
import java.awt.Desktop;
import java.net.URI;
import java.net.URL;
import javax.swing.JOptionPane;

public class DesenvolvedoresItem implements ItemController
{
    public void executar()
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