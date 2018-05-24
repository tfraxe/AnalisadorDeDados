package gerenciamento;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import controller.AbrirItemController;
import view.janelas.*;
import view.paginas.*;
import java.net.URL;
import model.Tabela;

//Essa classe controla o carregamento da janela e da pagina inicial
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
            icone = ClassLoader.getSystemResource("view/icones/pie-chart.png");
            //Decoracao de janela
            JanelaNavega janela_navega = new JanelaNavega(new JanelaMenu(new Janela("Analisador Descritivo de Dados")));
            //Decoracao de pagina
            PaginaInicial pagina_inicial = new PaginaInicial(new Pagina());
            janela = janela_navega;
            pagina = pagina_inicial;
            pagina_inicial.carregar();
            janela_navega.montar();
            janela_navega.setIcone(icone);
            janela_navega.navegar(pagina_inicial);
            janela_navega.iniciar();

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar a aplicação: " + e.getMessage());
        }
    }
}