package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeitorArquivo
{
    private File arquivo;

    public LeitorArquivo() { }

    public LeitorArquivo(File arquivo)
    {
        this.arquivo = arquivo;
    }

    public File getArquivo()
    {
        return arquivo;
    }

    public void setArquivo(File arquivo)
    {
        this.arquivo = arquivo;
    }

    public void ler() throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(arquivo));
        ArrayList<String[]> tabela = new ArrayList<String[]>();
        String linha;
        while((linha = reader.readLine()) != null)
        {
            String[] dados = linha.split(",");
            tabela.add(dados);
        }
        for(String[] item: tabela) 
        {
            for(int i = 0; i < item.length; i++) 
            {
				String teste = item[i];
				System.out.print(teste);
				System.out.print(" ");
			}
			System.out.println();
		}	
    }
}