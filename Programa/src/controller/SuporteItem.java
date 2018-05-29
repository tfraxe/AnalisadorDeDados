package controller;

import javax.swing.JOptionPane;
import controller.ItemController;

public class SuporteItem implements ItemController
{
    public void executar()
    {
        JOptionPane.showMessageDialog(null, "Em caso de dúvidas ou sugestões,\n entre em contato através do nosso e-mail:\n analisadordados@metricx.com");
    }
}