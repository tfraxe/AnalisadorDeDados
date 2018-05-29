package view.util;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public class Coluna extends JPanel
{
    public Coluna(Color cor)
    {
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setBackground(cor);
    }
}