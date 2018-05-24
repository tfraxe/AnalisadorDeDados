package view.paginas;

import java.awt.event.ActionListener;
import java.util.LinkedList;
import view.util.BotaoRadio;
import java.awt.event.ActionEvent;
import model.CalculoAnalise;
import model.Media;

//Processa os eventos dos botoes de operacoes univariadas da pagina inicial
public class UnivariadaListener implements ActionListener
{
    private LinkedList<BotaoRadio> botoes;
    private CalculoAnalise calculo;

    public void setBotoes(LinkedList<BotaoRadio> botoes)
    {
        this.botoes = botoes;
        calculo = new CalculoAnalise(new Media());
    }

    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() instanceof BotaoRadio)
        {
            BotaoRadio fonte = (BotaoRadio)event.getSource();
            for(BotaoRadio botao : botoes)
                if(botao == fonte)
                {
                    calculo.calcularValor(0);
                }
        }
    }
}