package view.paginas;

import observer.TabelaObservador;
import view.paginas.PaginaAbstrata;
import view.paginas.PaginaInicial;
import gerenciamento.Gerenciador;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.util.ArrayList;
import model.Tabela;

public class TabelaListener implements TabelaObservador 
{

    public void tabelaPronta()
    {
        PaginaAbstrata pagina = Gerenciador.getPagina();
        if(pagina instanceof PaginaInicial)
        {
            PaginaInicial pagina_inicial = (PaginaInicial)pagina;
            ArrayList<String[]> tabela =  Tabela.getTabela();
            String[] nomeColunas = tabela.get(0);
            String[][] dados = new String[tabela.size() - 1][nomeColunas.length];
            for(int i = 1; i < tabela.size(); i++) 
                dados[i - 1] = tabela.get(i);
            JTable csvTable = new JTable(dados, nomeColunas);
            JScrollPane csvPanel = new JScrollPane(csvTable);
            pagina_inicial.inserirCentro(csvPanel);
        }
    }
}