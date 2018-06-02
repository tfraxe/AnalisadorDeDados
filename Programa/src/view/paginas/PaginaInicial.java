package view.paginas;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.net.URL;

import view.listeners.*;
import view.util.*;

public class PaginaInicial extends DecoradorPagina implements ActionListener
{
    private Toolkit toolkit;
    private URL calculadora;
    private URL grafico;
    private BotaoIcone botao_analises;
    private BotaoIcone botao_graficos;
    private Coluna coluna_icones;
    private Coluna coluna_operacoes;
    private Coluna coluna_centro;
    private ButtonGroup grupo_univariada;
    private ButtonGroup grupo_multivariada;
    private ButtonGroup grupo_quantitativos;
    private ButtonGroup grupo_qualitativos;
    private Titulo univariada;
    private JButton botao_univariada;
    private BotaoRadio media;
    private BotaoRadio moda;
    private BotaoRadio mediana;
    private BotaoRadio minimo;
    private BotaoRadio maximo;
    private BotaoRadio variancia;
    private BotaoRadio desvio_padrao;
    private BotaoRadio skewness;
    private BotaoRadio kurtosis;
    private Titulo multivariada;
    private JButton botao_multivariada;
    private BotaoRadio covariancia;
    private BotaoRadio pearson;
    private Titulo quantitativos;
    private JButton botao_quantitativos;
    private BotaoRadio histograma;
    private BotaoRadio tabela_frequencias_quantitativos;
    private BotaoRadio boxplot;
    private BotaoRadio scatterplot;
    private Titulo qualitativos;
    private JButton botao_qualitativos;
    private BotaoRadio tabela_contingencia;
    private BotaoRadio tabela_frequencias_qualitativos;
    private BotaoRadio grafico_barras_absoluto;
    private BotaoRadio grafico_barras_relativo;
    private UnivariadaListener univariada_listener;
    private MultivariadaListener multivariada_listener;
    private GraficoListener grafico_listener;
    private BotaoUnivariadaListener botao_univariada_listener;
    private BotaoMultivariadaListener botao_multivariada_listener;
    private BotaoQuantitativosListener botao_quantitativos_listener;
    private BotaoQualitativosListener botao_qualitativos_listener;

    public PaginaInicial(PaginaAbstrata pagina)
    {
        super(pagina);
        construirElementos();
    }

    public BotaoUnivariadaListener getBotaoUnivariadaListener()
    {
        return botao_univariada_listener;
    }

    public BotaoMultivariadaListener getBotaoMultivariadaListener()
    {
        return botao_multivariada_listener;
    }

    public BotaoQuantitativosListener getBotaoQuantitativosListener()
    {
        return botao_quantitativos_listener;
    }

    public BotaoQualitativosListener getBotaoQualitativosListener()
    {
        return botao_qualitativos_listener;
    }

    private void construirElementos()
    {
        toolkit = Toolkit.getDefaultToolkit();
        calculadora = this.getClass().getResource("/resources/calculator.png");
        grafico = this.getClass().getResource("/resources/graph.png");
        univariada_listener = new UnivariadaListener();
        multivariada_listener = new MultivariadaListener();
        grafico_listener = new GraficoListener();
        botao_univariada_listener = new BotaoUnivariadaListener();
        botao_multivariada_listener = new BotaoMultivariadaListener();
        botao_quantitativos_listener = new BotaoQuantitativosListener();
        botao_qualitativos_listener = new BotaoQualitativosListener();
        construirColunas();
        construirBotoes();
        agruparBotoes();
    }

    private void construirColunas()
    {
        coluna_icones = new Coluna(new Cores().BRANCO_FRACO());
        coluna_operacoes = new Coluna(new Cores().BRANCO_MEDIO());
        coluna_centro = new Coluna(new Cores().BRANCO_FORTE());
    }

    private void construirBotoes()
    {
        botao_analises = new BotaoIcone(new ImageIcon(toolkit.createImage(calculadora)), this);
        botao_graficos = new BotaoIcone(new ImageIcon(toolkit.createImage(grafico)), this);
        univariada = new Titulo("Analise Univariada");
        botao_univariada = new JButton("Calcular");
        botao_univariada.addActionListener(botao_univariada_listener);
        media = new BotaoRadio("Media", univariada_listener);
        moda = new BotaoRadio("Moda", univariada_listener);
        mediana = new BotaoRadio("Mediana", univariada_listener);
        minimo = new BotaoRadio("Minimo", univariada_listener);
        maximo = new BotaoRadio("Maximo", univariada_listener);
        variancia = new BotaoRadio("Variancia", univariada_listener);
        desvio_padrao = new BotaoRadio("Desvio Padrao", univariada_listener);
        skewness = new BotaoRadio("Skewness", univariada_listener);
        kurtosis = new BotaoRadio("Kurtosis", univariada_listener);

        multivariada = new Titulo("Analise Multivariada");
        botao_multivariada = new JButton("Calcular");
        botao_multivariada.addActionListener(botao_multivariada_listener);
        covariancia = new BotaoRadio("Covariancia", multivariada_listener);
        pearson = new BotaoRadio("Pearson", multivariada_listener);

        quantitativos = new Titulo("Dados Quantitativos");
        botao_quantitativos = new JButton("Calcular");
        botao_quantitativos.addActionListener(botao_quantitativos_listener);
        histograma = new BotaoRadio("Histograma", grafico_listener);
        tabela_frequencias_quantitativos = new BotaoRadio("Tabela Quantitativos", grafico_listener);
        boxplot = new BotaoRadio("Boxplot", grafico_listener);
        scatterplot = new BotaoRadio("Scatterplot", grafico_listener);

        qualitativos = new Titulo("Dados Qualitativos");
        botao_qualitativos = new JButton("Calcular");
        botao_qualitativos.addActionListener(botao_qualitativos_listener);
        tabela_contingencia = new BotaoRadio("Tabela Contingencia", grafico_listener);
        tabela_frequencias_qualitativos = new BotaoRadio("Tabela Qualitativos", grafico_listener);
        grafico_barras_absoluto = new BotaoRadio("Grafico de barras absoluto", grafico_listener);
        grafico_barras_relativo = new BotaoRadio("Grafico de barras relativo", grafico_listener);
    }

    private void agruparBotoes()
    {
        grupo_univariada = new ButtonGroup();
        grupo_multivariada = new ButtonGroup();
        grupo_quantitativos = new ButtonGroup();
        grupo_qualitativos = new ButtonGroup();
        
        grupo_univariada.add(media);
        grupo_univariada.add(moda);
        grupo_univariada.add(mediana);
        grupo_univariada.add(minimo);
        grupo_univariada.add(maximo);
        grupo_univariada.add(variancia);
        grupo_univariada.add(desvio_padrao);
        grupo_univariada.add(skewness);
        grupo_univariada.add(kurtosis);

        grupo_multivariada.add(covariancia);
        grupo_multivariada.add(pearson);
        
        grupo_quantitativos.add(histograma);
        grupo_quantitativos.add(tabela_frequencias_quantitativos);
        grupo_quantitativos.add(boxplot);
        grupo_quantitativos.add(scatterplot);

        grupo_qualitativos.add(tabela_contingencia);
        grupo_qualitativos.add(tabela_frequencias_qualitativos);
        grupo_qualitativos.add(grafico_barras_absoluto);
        grupo_qualitativos.add(grafico_barras_relativo);
    }

    public void carregar()
    {
        JPanel panel = super.getPanel();
        panel.setLayout(new BorderLayout());
        panel.add(criarLateralEsquerda(), BorderLayout.LINE_START);
        panel.add(criarColunaCentro(), BorderLayout.CENTER);
        super.pagina.carregar();
    }

    private JPanel criarLateralEsquerda()
    {
        JPanel esquerda = new JPanel(new BorderLayout());
        esquerda.add(criarColunaIcones(), BorderLayout.LINE_START);
        esquerda.add(criarColunaOperacoes(), BorderLayout.CENTER);
        return esquerda;
    }
    
    private JPanel criarColunaIcones()
    {
        coluna_icones.setLayout(new BoxLayout(coluna_icones, BoxLayout.Y_AXIS));
        coluna_icones.add(botao_analises);
        coluna_icones.add(botao_graficos);
        return coluna_icones;
    }

    private JPanel criarColunaOperacoes()
    {
        coluna_operacoes.setLayout(new BoxLayout(coluna_operacoes, BoxLayout.Y_AXIS));
        setBotoesAnalise();
        return coluna_operacoes;
    }

    private JPanel criarColunaCentro()
    {
        coluna_centro.setLayout(new GridLayout());
        return coluna_centro; 
    }

    private void setBotoesAnalise()
    {
        grupo_univariada.clearSelection();
        grupo_multivariada.clearSelection();
        coluna_operacoes.removeAll();
        Cabecalho cabecalho_univariada = new Cabecalho();
        cabecalho_univariada.add(univariada);
        cabecalho_univariada.add(botao_univariada);
        coluna_operacoes.add(cabecalho_univariada);
        coluna_operacoes.add(media);
        coluna_operacoes.add(moda);
        coluna_operacoes.add(mediana);
        coluna_operacoes.add(minimo);
        coluna_operacoes.add(maximo);
        coluna_operacoes.add(variancia);
        coluna_operacoes.add(desvio_padrao);
        coluna_operacoes.add(skewness);
        coluna_operacoes.add(kurtosis);
        Cabecalho cabecalho_multivariada = new Cabecalho();
        cabecalho_multivariada.add(multivariada);
        cabecalho_multivariada.add(botao_multivariada);
        coluna_operacoes.add(cabecalho_multivariada);
        coluna_operacoes.add(covariancia);
        coluna_operacoes.add(pearson);
        coluna_operacoes.revalidate();
        coluna_operacoes.repaint();
    }

    private void setBotoesGraficos()
    {
        grupo_quantitativos.clearSelection();
        grupo_qualitativos.clearSelection();
        coluna_operacoes.removeAll();
        Cabecalho cabecalho_quantitativos = new Cabecalho();
        cabecalho_quantitativos.add(quantitativos);
        cabecalho_quantitativos.add(botao_quantitativos);
        coluna_operacoes.add(cabecalho_quantitativos);
        coluna_operacoes.add(histograma);
        coluna_operacoes.add(tabela_frequencias_quantitativos);
        coluna_operacoes.add(boxplot);
        coluna_operacoes.add(scatterplot);
        Cabecalho cabecalho_qualitativos = new Cabecalho();
        cabecalho_qualitativos.add(qualitativos);
        cabecalho_qualitativos.add(botao_qualitativos);
        coluna_operacoes.add(cabecalho_qualitativos);
        coluna_operacoes.add(tabela_contingencia);
        coluna_operacoes.add(tabela_frequencias_qualitativos);
        coluna_operacoes.add(grafico_barras_absoluto);
        coluna_operacoes.add(grafico_barras_relativo);
        coluna_operacoes.revalidate();
        coluna_operacoes.repaint();
    }

    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() instanceof BotaoIcone)
        {
            BotaoIcone botao = (BotaoIcone)event.getSource();
            if(botao == botao_analises)
                setBotoesAnalise();
            if(botao == botao_graficos)
                setBotoesGraficos();
        }
    }

    public void inserirCentro(JComponent component)
    {
        limparCentro();
        coluna_centro.add(component);
        coluna_centro.revalidate();
        coluna_centro.repaint();
    }

    public void limparCentro()
    {
        coluna_centro.removeAll();
        coluna_centro.revalidate();
        coluna_centro.repaint();
    }
}