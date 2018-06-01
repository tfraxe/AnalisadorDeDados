package controller.gerenciamento;

import java.util.HashMap;

import model.graficos.Grafico;
import model.graficos.CalculoGrafico;
import model.graficos.TabelaFrequencia;
import model.graficos.TabelaContingencia;
import model.graficos.GraficoBarrasAbsoluto;
import model.graficos.GraficoBarrasRelativo;
import view.paginas.GraficosView;
import controller.GraficosController;
import observer.Observador;
import observer.NotificacaoGrafico;

public class GerenciadorQualitativo extends Observador
{
    private GraficosController graficos_controller;
    private GraficosView view;
    private HashMap<String, Grafico> graficos;

    public GerenciadorQualitativo()
    {
        graficos_controller = new GraficosController();
        graficos = new HashMap<String, Grafico>();
        graficos.put("Tabela Contingencia", new TabelaContingencia());
        graficos.put("Tabela Qualitativos", new TabelaFrequencia());
        graficos.put("Grafico de barras absoluto", new GraficoBarrasAbsoluto());
        graficos.put("Grafico de barras relativo", new GraficoBarrasRelativo());
    }

    public void update()
    {
        super.update();
        if(super.notificacao instanceof NotificacaoGrafico)
        {
            NotificacaoGrafico n = (NotificacaoGrafico)super.notificacao;
            Grafico grafico = graficos.get(n.grafico);
            if(grafico != null)
            {
                CalculoGrafico model = new CalculoGrafico(grafico);
                view = new GraficosView();
                model.adicionarObservador(view);
                view.setObservavel(model);
                graficos_controller.setModel(model);
                graficos_controller.executar(n.coluna1);
            }
        }
    }
}