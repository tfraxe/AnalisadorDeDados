package view.janelas;

import javax.swing.JFrame;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.awt.Dimension;

/* Classe raiz do padrao de projeto decorator para janelas
   Essa classe mantem o JFrame da janela que esta sendo exibida. */
public abstract class JanelaAbstrata
{
    protected JFrame frame;
    protected static Dimension resolucao = Toolkit.getDefaultToolkit().getScreenSize();

    public static Dimension getResolucao()
    {
        return resolucao;
    }

    public JFrame getFrame()
    {
        return frame;
    }

    public abstract void montar();

    public abstract void iniciar();

    public void setIcone(URL caminho)
    {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.createImage(caminho);
        frame.setIconImage(image);
    }
}