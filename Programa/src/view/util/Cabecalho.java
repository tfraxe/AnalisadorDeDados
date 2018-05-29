package view.util;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import view.util.Cores;

public class Cabecalho extends JPanel
{
    public Cabecalho()
    {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBackground(new Cores().BRANCO_MEDIO());
    }
}