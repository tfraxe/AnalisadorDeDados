package controller.gerenciamento;

import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.io.File;

import model.Tabela;
import view.janelas.*;
import view.paginas.*;
import controller.gerenciamento.GerenciadorUnivariada;
import controller.gerenciamento.GerenciadorMultivariada;
import controller.gerenciamento.GerenciadorMenuBar;
import controller.gerenciamento.GerenciadorQuantitativo;
import controller.gerenciamento.GerenciadorQualitativo;

public class Gerenciador
{
    private static JanelaAbstrata janela;
    private static PaginaAbstrata pagina;
    private URL icone;

    public static JanelaAbstrata getJanela()
    {
        return janela;
    } 

    public static PaginaAbstrata getPagina()
    {
        return pagina;
    } 

    public void iniciar()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            icone = this.getClass().getResource("/resources/pie-chart.png");
            criarPagina();
            criarJanela();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar a aplicação: " + e.getMessage());
        }
    }

    private void criarJanela()
    {
        JanelaMenu janela_menu = new JanelaMenu(new Janela("Analisador Descritivo de Dados"));
        GerenciadorMenuBar gerenciador_menuBar = new GerenciadorMenuBar();
        janela_menu.montar();
        gerenciador_menuBar.setObservavel(janela_menu.getJanelaMenuListener());
        janela_menu.getJanelaMenuListener().adicionarObservador(gerenciador_menuBar);
        JanelaNavega temp = new JanelaNavega(janela_menu);
        janela = temp;
        if(icone != null)
            temp.setIcone(icone);
        temp.navegar(pagina);
        temp.iniciar();
    }

    private void criarPagina()
    {
        PaginaInicial temp = new PaginaInicial(new Pagina());
        pagina = temp;
        GerenciadorUnivariada gerenciador_univariada = new GerenciadorUnivariada();
        GerenciadorMultivariada gerenciador_multivariada = new GerenciadorMultivariada();
        GerenciadorQuantitativo gerenciador_quantitativo = new GerenciadorQuantitativo();
        GerenciadorQualitativo gerenciador_qualitativo = new GerenciadorQualitativo();
        temp.carregar();
        gerenciador_univariada.setObservavel(temp.getBotaoUnivariadaListener());
        temp.getBotaoUnivariadaListener().adicionarObservador(gerenciador_univariada);
        gerenciador_multivariada.setObservavel(temp.getBotaoMultivariadaListener());
        temp.getBotaoMultivariadaListener().adicionarObservador(gerenciador_multivariada);
        gerenciador_quantitativo.setObservavel(temp.getBotaoQuantitativosListener());
        temp.getBotaoQuantitativosListener().adicionarObservador(gerenciador_quantitativo);
        gerenciador_qualitativo.setObservavel(temp.getBotaoQualitativosListener());
        temp.getBotaoQualitativosListener().adicionarObservador(gerenciador_qualitativo);
    }
}