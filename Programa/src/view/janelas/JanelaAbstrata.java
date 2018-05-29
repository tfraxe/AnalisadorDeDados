package view.janelas;

import javax.swing.JFrame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.awt.Dimension;

/* Classe raiz do padrao de projeto decorator para janelas
   Essa classe mantem o JFrame da janela que esta sendo exibida. */
public abstract class JanelaAbstrata implements WindowListener
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

    public void windowActivated(WindowEvent e) { }

    public void windowClosed(WindowEvent e) { }

    public void windowClosing(WindowEvent e) 
    {
        System.exit(0);
    }

    public void windowDeactivated(WindowEvent e) { }

    public void windowDeiconified(WindowEvent e) { }

    public void windowIconified(WindowEvent e) { }

    public void windowOpened(WindowEvent e) { }
}