package model.graficos;

import javax.swing.JFrame;

import javax.swing.JOptionPane;

import model.graficos.Grafico;
import model.ColunaIncompativelException;
import observer.Observavel;
import observer.NotificacaoGrafico;

public class CalculoGrafico extends Observavel
{
    private Grafico grafico;
	private NotificacaoGrafico notificacao;

	public CalculoGrafico(Grafico grafico)
	{
		super();
		this.grafico = grafico;
		this.notificacao = new NotificacaoGrafico();
	}

	public void calcularGrafico(int coluna)
	{
		try
		{
			JFrame resultado = grafico.calcular(coluna);
			if(resultado != null)
			{
				this.notificacao.resultado = resultado;
				super.notificacao = this.notificacao;	
				super.notificarObservadores();
			}
		}
		catch(ColunaIncompativelException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    }
    
    public void calcularGrafico(int coluna1, int coluna2)
	{
		try
		{
			JFrame resultado = grafico.calcular(coluna1, coluna2);
			if(resultado != null)
			{
				this.notificacao.resultado = resultado;
				super.notificacao = this.notificacao;	
				super.notificarObservadores();
			}
		}
		catch(ColunaIncompativelException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}