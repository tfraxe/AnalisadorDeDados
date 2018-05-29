package model.univariada;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import model.univariada.Univariada;
import model.ColunaIncompativelException;
import model.Tabela;

public class Mediana implements Univariada
{
	public String calcular(int coluna) throws ColunaIncompativelException
	{
		ArrayList<String[]> tabela = Tabela.getTabela();
		if(tabela != null && tabela.size() > 1 && coluna >= 0)
		{
			ArrayList<String> valores = new ArrayList<String>();
			for(int i = 1; i < tabela.size(); i++)
				valores.add(tabela.get(i)[coluna]);
			if(valores.size() > 0)
			{
				try
				{
					ArrayList<Double> numeros = new ArrayList<Double>();
					for(String item: valores)
						numeros.add(Double.parseDouble(item));
					Collections.sort(numeros, new Comparator<Double>() {
						@Override
						public int compare(Double n1, Double n2)
						{
							return Double.compare(n1, n2);
						}
					});
					if(numeros.size() % 2 == 0)
						return numeros.get((int)(numeros.size() / 2)).toString();
					return numeros.get((int)((numeros.size() - 1) / 2)).toString();
				}
				catch(NumberFormatException e)
				{
					Collections.sort(valores, String.CASE_INSENSITIVE_ORDER);
					if(valores.size() % 2 == 0)
						return valores.get((int)(valores.size() / 2));
					return valores.get((int)((valores.size() - 1) / 2));
				}
			}
		}
		return null;
	}
}