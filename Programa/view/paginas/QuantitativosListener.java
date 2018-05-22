package view.paginas;

import java.awt.event.ActionListener;
import java.util.LinkedList;
import view.util.BotaoRadio;
import java.awt.event.ActionEvent;

//Processa os eventos dos botoes de graficos com dados quantitativos da pagina inicial
public class QuantitativosListener implements ActionListener
{
    private LinkedList<BotaoRadio> botoes;

    public void setBotoes(LinkedList<BotaoRadio> botoes)
    {
        this.botoes = botoes;
    }

    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() instanceof BotaoRadio)
        {
            BotaoRadio fonte = (BotaoRadio)event.getSource();
            for(BotaoRadio botao : botoes)
                if(botao == fonte)
                //Apenas um teste
                    System.out.println(fonte.getText());
        }
    }
}