package gerenciamento;

import java.util.HashMap;

import model.multivariada.Multivariada;
import model.multivariada.CalculoMultivariada;
import model.multivariada.Covariancia;
import model.multivariada.Pearson;
import view.paginas.MultivariadaView;
import controller.MultivariadaController;
import observer.NotificacaoMultivariada;
import observer.Observador;

public class GerenciadorMultivariada extends Observador
{
	private MultivariadaController controlador_multivariada;
	private HashMap<String, Multivariada> operacoes;
	private MultivariadaView view;

	public GerenciadorMultivariada()
	{
		controlador_multivariada = new MultivariadaController();
		operacoes = new HashMap<String, Multivariada>();
		operacoes.put("Covariancia", new Covariancia());
		operacoes.put("Pearson", new Pearson());
	}

	public void update()
	{
		super.update();
		if(super.notificacao instanceof NotificacaoMultivariada)
		{
			NotificacaoMultivariada n = (NotificacaoMultivariada)super.notificacao;
			Multivariada operacao = operacoes.get(n.operacao);
			if(operacao != null)
			{
				CalculoMultivariada model = new CalculoMultivariada(operacao, n.operacao);
				view = new MultivariadaView();
				model.adicionarObservador(view);
				view.setObservavel(model);
				controlador_multivariada.setModel(model);
				controlador_multivariada.executar(n.coluna1, n.coluna2);
			}
		}
	}
}