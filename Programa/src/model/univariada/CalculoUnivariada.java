package model.univariada;

import javax.swing.JOptionPane;

import model.univariada.Univariada;
import model.ColunaIncompativelException;
import observer.NotificacaoUnivariada;
import observer.Observavel;

public class CalculoUnivariada extends Observavel
{
	private Univariada operacao;
	private String texto;
	private NotificacaoUnivariada notificacao;

	public CalculoUnivariada(Univariada operacao, String texto)
	{
		super();
		this.operacao = operacao;
		this.texto = texto;
		this.notificacao = new NotificacaoUnivariada();
	}

	public void calcularValor(int coluna)
	{
		try
		{
			String resultado = operacao.calcular(coluna);
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