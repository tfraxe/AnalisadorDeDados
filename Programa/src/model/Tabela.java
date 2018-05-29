package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import observer.NotificacaoTabela;
import observer.Observavel;

public class Tabela extends Observavel
{
    private File file;
    private static ArrayList<String[]> tabela;
    private NotificacaoTabela notificacao;

    public Tabela() 
    { 
        super();
        this.notificacao = new NotificacaoTabela();
    }

    public File getArquivo()
    {
        return file;
    }

    public void setArquivo(File arquivo)
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
        try
        {
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
                this.notificacao.tabela = tabela;
                super.notificacao = this.notificacao; 
                super.notificarObservadores();
            }
        }
        catch(IOException e)
        {
            throw e;
        }
        finally
        {
            reader.close();
        }
    }
}