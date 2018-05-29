package view.util;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import view.util.Cores;

public class BotaoRadio extends JRadioButton
{
    public BotaoRadio(String text, ActionListener listener)
    {
        super(text);
        setFocusPainted(false);
        setBackground(new Cores().BRANCO_MEDIO());
        addActionListener(listener);
    }
}