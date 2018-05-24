package view.util;

import javax.swing.JLabel;
import java.awt.Font;

public class Titulo extends JLabel
{
    public Titulo(String texto)
    {
        super(texto);
        setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
    }
}