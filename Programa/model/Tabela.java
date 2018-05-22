package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Tabela implements TabelaObservable
{
    private static File arquivo;
    private static ArrayList<TabelaObserver> observers = new ArrayList<TabelaObserver>();
    private static ArrayList<String[]> tabela = new ArrayList<String[]>();

    public Tabela() { }

    public Tabela(File arquivo)
    {
        Tabela.arquivo = arquivo;
    }

    public File getArquivo()
    {
        return arquivo;
    }

    public static void setArquivo(File arquivo)
    {
        Tabela.arquivo = arquivo;
    }

    public static ArrayList<String[]> getTabela()
    {
        return tabela;
    }

    public void addObservers(TabelaObserver to)
    {
    
        observers.add(to);
    } 

    public static void notificar()
    {
        if(observers != null)
            for(TabelaObserver item : observers)
                item.atualizarTabela(); 
    } 

    public static void ler() throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(arquivo));
        String linha;
        while((linha = reader.readLine()) != null)
        {
            String[] dados = linha.split(",");
            tabela.add(dados);
        }
        
        /* for(String[] item: tabela) 
        {
            for(int i = 0; i < item.length; i++) 
            {
				String teste = item[i];
				System.out.print(teste);
				System.out.print(" ");
			}
			System.out.println();
		} */

        Tabela.notificar();

    }
}
