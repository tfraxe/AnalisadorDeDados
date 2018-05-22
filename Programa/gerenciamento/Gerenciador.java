package gerenciamento;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import view.janelas.*;
import view.paginas.*;
import java.net.URL;

//Essa classe controla o carregamento da janela e da pagina inicial
public class Gerenciador
{
    private static JanelaNavega janela;
    private static PaginaInicial pagina;
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
            icone = ClassLoader.getSystemResource("view/icones/pie-chart.png");
            //Decoracao de janela
            janela = new JanelaNavega(new JanelaMenu(new Janela("Analisador Descritivo de Dados")));
            //Decoracao de pagina
            pagina = new PaginaInicial(new Pagina());
            pagina.carregar();
            janela.montar();
            janela.setIcone(icone);
            janela.navegar(pagina);
            janela.iniciar();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar a aplicação: " + e.getMessage());
        }
    }
}