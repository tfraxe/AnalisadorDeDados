package model.univariada;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import model.univariada.Univariada;
import model.ColunaIncompativelException;
import model.Tabela;

public class Moda implements Univariada
{
	public String calcular(int coluna) throws ColunaIncompativelException
	{
		ArrayList<String[]> tabela = Tabela.getTabela();
		if(tabela != null && tabela.size() > 1 && coluna >= 0)
		{
			int maior_frequencia = 0;
			HashSet<String> moda = new HashSet<String>();	
			HashSet<String> conjunto = new HashSet<String>(); 
			ArrayList<String> valores = new ArrayList<String>();
			for(int i = 1; i < tabela.size(); i++)
			{
				String texto = tabela.get(i)[coluna];
				conjunto.add(texto);
				valores.add(texto);
			}
			for(String texto : conjunto)
			{
				int frequencia = Collections.frequency(valores, texto);
				if(frequencia >= maior_frequencia)
				{
					maior_frequencia = frequencia;
					moda.add(texto);
				}
			}
			if(maior_frequencia > 1)
				return moda.toString();
			throw new ColunaIncompativelException("Nao ha moda nessa coluna");
		}
		return null;
	}
}