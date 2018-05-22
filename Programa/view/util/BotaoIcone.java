package view.util;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionListener;

public class BotaoIcone extends JButton
{
    public BotaoIcone(ImageIcon icone, ActionListener listener)
    {
        super(icone);
        setBorderPainted(false);
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBackground(new Cores().BRANCO_FRACO());
        addActionListener(listener);
        setSize(new Dimension(50, 50));
    }
}