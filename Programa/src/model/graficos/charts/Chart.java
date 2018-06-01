package model.graficos.charts;

import java.util.ArrayList;
import java.awt.event.WindowEvent;

import org.jfree.ui.ApplicationFrame;

import model.Tabela;

public abstract class Chart extends ApplicationFrame
{
    protected Chart(String applicationTitle)
    {
        super(applicationTitle);
    }

    public void windowClosing(WindowEvent e)
	{
		dispose();
	}
}