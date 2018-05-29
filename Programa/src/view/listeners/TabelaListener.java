package view.listeners;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelListener;

import model.Tabela;
import view.paginas.PaginaAbstrata;
import view.paginas.PaginaInicial;
import observer.Observador;
import observer.NotificacaoTabela;
import gerenciamento.Gerenciador;

public class TabelaListener extends Observador implements TableColumnModelListener
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
            tabela.getColumnModel().addColumnModelListener(this);
            JScrollPane panel = new JScrollPane(tabela);
            pagina.inserirCentro(panel);
        }
    }

    public void columnAdded(TableColumnModelEvent e) { }

    public void columnMarginChanged(ChangeEvent e) { }

    public void columnMoved(TableColumnModelEvent e) { }

    public void columnRemoved(TableColumnModelEvent e) { }

    public void columnSelectionChanged(ListSelectionEvent e)
    {
        if(primeira_coluna == -1)
            primeira_coluna = tabela.getSelectedColumn();
        else
            segunda_coluna = tabela.getSelectedColumn();
    }
}