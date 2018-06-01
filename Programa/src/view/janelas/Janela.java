package view.janelas;

import java.awt.Dimension;
import javax.swing.JFrame;
import view.janelas.JanelaAbstrata;

//Classe concreta de Janela no padrão de projeto Decorator
public class Janela extends JanelaAbstrata
{
    private int largura = (int)JanelaAbstrata.resolucao.getWidth();
    private int altura = (int)JanelaAbstrata.resolucao.getHeight();

    public Janela(String titulo)
    {
        super.frame = new JFrame(titulo);
    }
    
    public void montar()
    {
        super.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        super.frame.setMinimumSize(new Dimension((int)(largura / 2), (int)(altura / 1.5)));
    }

    public void iniciar()
    {
        //super.frame.addWindowListener(this);
        super.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.frame.pack();
        super.frame.setVisible(true);
    }
}