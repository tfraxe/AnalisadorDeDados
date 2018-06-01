package controller.gerenciamento;

import java.util.HashMap;

import model.univariada.Univariada;
import model.univariada.CalculoUnivariada;
import model.univariada.Media;
import model.univariada.Moda;
import model.univariada.Mediana;
import model.univariada.Minimo;
import model.univariada.Maximo;
import model.univariada.Variancia;
import model.univariada.DesvioPadrao;
import model.univariada.Skewness;
import model.univariada.Kurtosis;
import view.paginas.UnivariadaView;
import view.listeners.BotaoUnivariadaListener;
import controller.UnivariadaController;
import observer.NotificacaoUnivariada;
import observer.Observador;

public class GerenciadorUnivariada extends Observador
{
	private UnivariadaController controlador_univariada;
	private HashMap<String, Univariada> operacoes;
	private UnivariadaView view;

	public GerenciadorUnivariada()
	{
		controlador_univariada = new UnivariadaController();
		operacoes = new HashMap<String, Univariada>();
		operacoes.put("Media", new Media());
		operacoes.put("Moda", new Moda());
		operacoes.put("Mediana", new Mediana());
		operacoes.put("Minimo", new Minimo());
		operacoes.put("Maximo", new Maximo());
		operacoes.put("Variancia", new Variancia());
		operacoes.put("Desvio Padrao", new DesvioPadrao());
		operacoes.put("Skewness", new Skewness());
		operacoes.put("Kurtosis", new Kurtosis());
	}

	public void update()
	{
		super.update();
		if(super.notificacao instanceof NotificacaoUnivariada)
		{
			NotificacaoUnivariada n = (NotificacaoUnivariada)super.notificacao;
			Univariada operacao = operacoes.get(n.operacao);
			if(operacao != null)
			{
				CalculoUnivariada model = new CalculoUnivariada(operacao, n.operacao);
				view = new UnivariadaView();
				model.adicionarObservador(view);
				view.setObservavel(model);
				controlador_univariada.setModel(model);
				controlador_univariada.executar(n.coluna);
			}
		}
	}
}