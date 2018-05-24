package controller;

import javax.swing.JOptionPane;
import controller.ItemController;

//Controlador da execucao do item suporte da barra de menu
public class SuporteItemController implements ItemController
{
    public void executar(String texto)
    {
        if(texto == "Suporte")
        JOptionPane.showMessageDialog(null, "Em caso de dúvidas ou sugestões,\n entre em contato através do nosso e-mail:\n analisadordados@metricx.com");
    }
}