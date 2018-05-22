package view.janelas;

import view.janelas.JanelaAbstrata;
import javax.swing.JFrame;

/* Classe abstrata que define o decorador de janela.
   Essa classe mantém um objeto com a janela que está sendo exibida. */
public abstract class DecoradorJanela extends JanelaAbstrata
{
    protected JanelaAbstrata janela;

    public DecoradorJanela(JanelaAbstrata janela)
    {
        this.janela = janela;
        super.frame = janela.frame;
    }

    public void iniciar()
    {
        janela.iniciar();
    }

    public JFrame getFrame()
    {
        return super.frame;
    }
}