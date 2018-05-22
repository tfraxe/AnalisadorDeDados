package view.paginas;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.*;
import view.janelas.JanelaAbstrata;
import view.paginas.DecoradorPagina;
import view.paginas.UnivariadaListener;
import view.paginas.MultivariadaListener;
import view.paginas.QuantitativosListener;
import view.paginas.QualitativosListener;
import view.util.*;
import model.Tabela;
import model.TabelaObserver;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JScrollPane;

//Decorador de pagina que carrega o visual da pagina inicial do programa
public class PaginaInicial extends DecoradorPagina implements ActionListener, TabelaObserver
{
    private int largura;
    private int altura;
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
    private BotaoRadio covariancia;
    private BotaoRadio pearson;
    private Titulo quantitativos;
    private BotaoRadio histograma;
    private BotaoRadio tabela_frequencias_quantitativos;
    private BotaoRadio boxplot;
    private BotaoRadio scatterplot;
    private Titulo qualitativos;
    private BotaoRadio tabela_contingencia;
    private BotaoRadio tabela_frequencias_qualitativos;
    private BotaoRadio grafico_barras;
    private UnivariadaListener univariada_listener;
    private MultivariadaListener multivariada_listener;
    private QuantitativosListener quantitativos_listener;
    private QualitativosListener qualitativos_listener;

    public PaginaInicial(PaginaAbstrata pagina)
    {
        super(pagina);
        construirElementos();
    }

    //Controla a construção da pagina para que todos os componentes estejam instanciados
    private void construirElementos()
    {
        univariada_listener = new UnivariadaListener();
        multivariada_listener = new MultivariadaListener();
        quantitativos_listener = new QuantitativosListener();
        qualitativos_listener = new QualitativosListener();
        largura = (int)JanelaAbstrata.getResolucao().getWidth();
        altura = (int)JanelaAbstrata.getResolucao().getHeight();
        construirColunas();
        construirBotoes();
        agruparBotoes();
        setListeners();
    }

    //Instancia os objetos Coluna
    private void construirColunas()
    {
        coluna_icones = new Coluna(new Cores().BRANCO_FRACO());
        coluna_operacoes = new Coluna(new Cores().BRANCO_MEDIO());
        coluna_centro = new Coluna(new Cores().BRANCO_FORTE());
    }

    //Instancia os botoes da pagina
    private void construirBotoes()
    {
        botao_analises = new BotaoIcone(new ImageIcon("view/icones/calculator.png", null), this);
        botao_graficos = new BotaoIcone(new ImageIcon("view/icones/graph.png", null), this);

        univariada = new Titulo("Analise Univariada");
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
        covariancia = new BotaoRadio("Covariancia", multivariada_listener);
        pearson = new BotaoRadio("Pearson", multivariada_listener);

        quantitativos = new Titulo("Dados Quantitativos");
        histograma = new BotaoRadio("Histograma", quantitativos_listener);
        tabela_frequencias_quantitativos = new BotaoRadio("Tabela Frequencias", quantitativos_listener);
        boxplot = new BotaoRadio("Boxplot", quantitativos_listener);
        scatterplot = new BotaoRadio("Scatterplot", quantitativos_listener);

        qualitativos = new Titulo("Dados Qualitativos");
        tabela_contingencia = new BotaoRadio("Tabela Contingencia", qualitativos_listener);
        tabela_frequencias_qualitativos = new BotaoRadio("Tabela Frequencias", qualitativos_listener);
        grafico_barras = new BotaoRadio("Grafico de barras", qualitativos_listener);
    }

    //Agrupa os botoes de analises e graficos
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
        grupo_qualitativos.add(grafico_barras);
    }

    //Adiciona os botoes agrupados aos seus devidos listeners
    private void setListeners()
    {
        LinkedList<BotaoRadio> botoes_univariada = new LinkedList<BotaoRadio>();
        LinkedList<BotaoRadio> botoes_multivariada = new LinkedList<BotaoRadio>();
        LinkedList<BotaoRadio> botoes_quantitativos = new LinkedList<BotaoRadio>();
        LinkedList<BotaoRadio> botoes_qualitativos = new LinkedList<BotaoRadio>();

        botoes_univariada.add(media);
        botoes_univariada.add(moda);
        botoes_univariada.add(mediana);
        botoes_univariada.add(minimo);
        botoes_univariada.add(maximo);
        botoes_univariada.add(variancia);
        botoes_univariada.add(desvio_padrao);
        botoes_univariada.add(skewness);
        botoes_univariada.add(kurtosis);

        botoes_multivariada.add(covariancia);
        botoes_multivariada.add(pearson);

        botoes_quantitativos.add(histograma);
        botoes_quantitativos.add(tabela_frequencias_quantitativos);
        botoes_quantitativos.add(boxplot);
        botoes_quantitativos.add(scatterplot);

        botoes_qualitativos.add(tabela_contingencia);
        botoes_qualitativos.add(tabela_frequencias_qualitativos);
        botoes_qualitativos.add(grafico_barras);

        univariada_listener.setBotoes(botoes_univariada);
        multivariada_listener.setBotoes(botoes_multivariada);
        quantitativos_listener.setBotoes(botoes_quantitativos);
        qualitativos_listener.setBotoes(botoes_qualitativos);
    }

    //Organiza os componentes instanciados para exibir na pagina
    public void carregar()
    {
        JPanel panel = super.getPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
        panel.add(criarColunaIcones());
        panel.add(criarColunaOperacoes());
        panel.add(criarColunaCentro());
        super.pagina.carregar();
    }

    //Cria a coluna com os botoes analises e graficos
    private JPanel criarColunaIcones()
    {
        coluna_icones.setLayout(new BoxLayout(coluna_icones, BoxLayout.Y_AXIS));
        coluna_icones.add(botao_analises);
        coluna_icones.add(botao_graficos);
        coluna_icones.setPreferredSize(new Dimension(50, altura - 100));
        return coluna_icones;
    }

    //Cria a coluna com os botoes de operações
    private JPanel criarColunaOperacoes()
    {
        coluna_operacoes.setLayout(new BoxLayout(coluna_operacoes, BoxLayout.Y_AXIS));
        setBotoesAnalise();
        coluna_operacoes.setPreferredSize(new Dimension(250, altura - 100));
        return coluna_operacoes;
    }

    //cria a parte central da pagina
    private JPanel criarColunaCentro()
    {
        coluna_centro.setLayout(new BoxLayout(coluna_centro, BoxLayout.Y_AXIS));
        JLabel mensagem = new JLabel("Bem-vindo! Escolha um arquivo .csv e calcule dados estatisticos.");
        JButton botao_abrir = new JButton("Abrir arquivo...");
        botao_abrir.setBorderPainted(false);
        botao_abrir.setFocusPainted(false);
        botao_abrir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botao_abrir.addActionListener(this);
        coluna_centro.add(mensagem);
        coluna_centro.add(botao_abrir);
        mensagem.setAlignmentX(Component.CENTER_ALIGNMENT);
        botao_abrir.setAlignmentX(Component.CENTER_ALIGNMENT);
        coluna_centro.setPreferredSize(new Dimension(largura - 400, altura - 100));
        return coluna_centro; 
    }

    //Troca os botoes da coluna de operações para univariada e multivariada
    private void setBotoesAnalise()
    {
        grupo_univariada.clearSelection();
        grupo_multivariada.clearSelection();
        coluna_operacoes.removeAll();
        coluna_operacoes.add(univariada);
        coluna_operacoes.add(media);
        coluna_operacoes.add(moda);
        coluna_operacoes.add(mediana);
        coluna_operacoes.add(minimo);
        coluna_operacoes.add(maximo);
        coluna_operacoes.add(variancia);
        coluna_operacoes.add(desvio_padrao);
        coluna_operacoes.add(skewness);
        coluna_operacoes.add(kurtosis);
        coluna_operacoes.add(multivariada);
        coluna_operacoes.add(covariancia);
        coluna_operacoes.add(pearson);
        coluna_operacoes.revalidate();
        coluna_operacoes.repaint();
    }

    //Troca os botoes da coluna de operações para quantitativos e qualitativos
    private void setBotoesGraficos()
    {
        grupo_quantitativos.clearSelection();
        grupo_qualitativos.clearSelection();
        coluna_operacoes.removeAll();
        coluna_operacoes.add(quantitativos);
        coluna_operacoes.add(histograma);
        coluna_operacoes.add(tabela_frequencias_quantitativos);
        coluna_operacoes.add(boxplot);
        coluna_operacoes.add(scatterplot);
        coluna_operacoes.add(qualitativos);
        coluna_operacoes.add(tabela_contingencia);
        coluna_operacoes.add(tabela_frequencias_qualitativos);
        coluna_operacoes.add(grafico_barras);
        coluna_operacoes.revalidate();
        coluna_operacoes.repaint();
    }

    //Recebe o evento de clique dos botoes da coluna de icones 
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

    public void atualizarTabela() {
        ArrayList<String[]> table = Tabela.getTabela();

        coluna_centro.removeAll(); // limpa a coluna central. 
        
        String[] nomeColunas = table.get(0);
        String[][] dados = new String[table.size()][nomeColunas.length];
        int i = 0;
        for (String[] linhas : table) 
        {
            dados[i] = linhas;
            i++;
        }

        JTable csvTable = new JTable(dados, nomeColunas);
        JScrollPane csvPanel = new JScrollPane(csvTable);
        csvPanel.setPreferredSize(new Dimension(800,300));
        coluna_centro.add(csvPanel);
        coluna_centro.revalidate();
        coluna_centro.repaint();
    }
}