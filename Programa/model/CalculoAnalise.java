package model;

import model.Analise;
import model.ColunaIncompativelException;
import javax.swing.JOptionPane;

public class CalculoAnalise
{
	private Analise analise;

	public CalculoAnalise(Analise analise)
	{
		this.analise = analise;
	}

	public void calcularValor(int coluna)
	{
		try
		{
			Double resultado = analise.calcular(coluna);	
			if(resultado != null)
				JOptionPane.showMessageDialog(null, resultado);	
		}
		catch(ColunaIncompativelException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}