package view.listeners;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import view.util.BotaoRadio;

public class GraficosQuantitativosListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() instanceof BotaoRadio)
        {
            BotaoRadio fonte = (BotaoRadio)e.getSource();
            System.out.println(fonte.getText());
        }
    } 
}