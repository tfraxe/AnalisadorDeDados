package view.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import model.Tabela;
import view.paginas.PaginaAbstrata;
import view.paginas.PaginaInicial;
import observer.Observador;
import observer.NotificacaoTabela;
import controller.gerenciamento.Gerenciador;

public class TabelaListener extends Observador
{
    private JTable tabela;
    private String[] nome_colunas;
    private String[][] dados;
    private static int primeira_coluna = -1;
    private static int segunda_coluna = -1;
    private PaginaInicial pagina;

    public TabelaListener(PaginaInicial pagina)
    {
        this.pagina = pagina;
    }

    public static int getPrimeiraColuna()
    {
        return primeira_coluna;
    }

    public static int getSegundaColuna()
    {
        return segunda_coluna;
    }

    public static void resetColunas()
    {
        primeira_coluna = -1;
        segunda_coluna = -1;
    }

    public void update()
    {
        super.update();
        if(super.notificacao instanceof NotificacaoTabela)
        {
            NotificacaoTabela n = (NotificacaoTabela)super.notificacao;
            ArrayList<String[]> lista = n.tabela;
            nome_colunas = lista.get(0);
            dados = new String[lista.size() - 1][nome_colunas.length];
            for(int i = 1; i < lista.size(); i++) 
                dados[i - 1] = lista.get(i);
            tabela = new JTable(dados, nome_colunas);
            JTableHeader header = tabela.getTableHeader();
            header.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e)
                {
                    if(primeira_coluna == -1)
                        primeira_coluna = header.columnAtPoint(e.getPoint());
                    else if(segunda_coluna == -1)
                        segunda_coluna = header.columnAtPoint(e.getPoint());
                }
            });
            JScrollPane panel = new JScrollPane(tabela);
            pagina.inserirCentro(panel);
        }
    }
}