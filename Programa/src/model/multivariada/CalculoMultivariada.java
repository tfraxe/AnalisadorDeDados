package model.multivariada;

import javax.swing.JOptionPane;

import model.multivariada.Multivariada;
import model.ColunaIncompativelException;
import observer.NotificacaoMultivariada;
import observer.Observavel;

public class CalculoMultivariada extends Observavel
{
	private Multivariada operacao;
	private String texto;
	private NotificacaoMultivariada notificacao;

	public CalculoMultivariada(Multivariada operacao, String texto)
	{
		super();
		this.operacao = operacao;
		this.texto = texto;
		this.notificacao = new NotificacaoMultivariada();
	}

	public void calcularValor(int coluna1, int coluna2)
	{
		try
		{
			String resultado = operacao.calcular(coluna1, coluna2);
			if(resultado != null)
			{
				this.notificacao.resultado = texto + ": " + resultado;
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