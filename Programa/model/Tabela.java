package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import observer.TabelaObservavel;
import observer.TabelaObservador;

public class Tabela implements TabelaObservavel
{
    private static File file;
    private static ArrayList<String[]> tabela;
    private ArrayList<TabelaObservador> observadores = new ArrayList<TabelaObservador>();

    public Tabela() { }

    public Tabela(File arquivo)
    {
        file = arquivo;
    }

    public static File getArquivo()
    {
        return file;
    }

    public static void setArquivo(File arquivo)
    {
        file = arquivo;
    }

    public static ArrayList<String[]> getTabela()
    {
        return tabela;
    }

    public void lerArquivo() throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        tabela = new ArrayList<String[]>();
        
        String primeira_linha = reader.readLine();
        if(primeira_linha != null)
        {
            String[] colunas = primeira_linha.split(",");
            int numero_colunas = colunas.length;
            String linha;
            tabela.add(colunas);
            while((linha = reader.readLine()) != null)
            {
                String[] dados = linha.split(",");
                if(dados.length == numero_colunas)
                    tabela.add(dados);
            }
            notificarTabelaObservadores();
        }
    }

    public void adicionarTabelaObservador(TabelaObservador observador)
    {
        observadores.add(observador);
    }
    
    public void removerTabelaObservador(TabelaObservador observador)
    {
        observadores.remove(observador);
    }

    public void notificarTabelaObservadores()
    {
        for(TabelaObservador observador : observadores)
            observador.tabelaPronta();
    }
}