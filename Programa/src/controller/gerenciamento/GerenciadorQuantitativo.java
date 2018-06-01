package controller.gerenciamento;

import java.util.HashMap;

import model.graficos.Grafico;
import model.graficos.CalculoGrafico;
import model.graficos.Histograma;
import model.graficos.TabelaFrequencia;
import model.graficos.Boxplot;
import model.graficos.Scatterplot;
import view.paginas.GraficosView;
import controller.GraficosController;
import observer.Observador;
import observer.NotificacaoGrafico;

public class GerenciadorQuantitativo extends Observador
{
    private GraficosController graficos_controller;
    private GraficosView view;
    private HashMap<String, Grafico> graficos;

    public GerenciadorQuantitativo()
    {
        graficos_controller = new GraficosController();
        graficos = new HashMap<String, Grafico>();
        graficos.put("Histograma", new Histograma());
        graficos.put("Tabela Quantitativos", new TabelaFrequencia());
        graficos.put("Boxplot", new Boxplot());
        graficos.put("Scatterplot", new Scatterplot());
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
                if(grafico instanceof Scatterplot)
                    graficos_controller.executar(n.coluna1, n.coluna2);
                else
                    graficos_controller.executar(n.coluna1);
            }
        }
    }
}