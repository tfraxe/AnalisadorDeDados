package model.univariada;

import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

import model.univariada.Univariada;
import model.ColunaIncompativelException;
import model.Tabela;

public class Maximo implements Univariada
{
	public String calcular(int coluna) throws ColunaIncompativelException
	{
		ArrayList<String[]> tabela = Tabela.getTabela();
		if(tabela != null && tabela.size() > 1 && coluna >= 0)
		{
			ArrayList<String> valores = new ArrayList<String>();
			for(int i = 1; i < tabela.size(); i++)
			{
				String texto = tabela.get(i)[coluna];
				if(!texto.equals(""))
					valores.add(texto);
			}
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
					return numeros.get(numeros.size() - 1).toString();
				}
				catch(NumberFormatException e)
				{
					Collections.sort(valores, String.CASE_INSENSITIVE_ORDER);
					return valores.get(valores.size() - 1);
				}
			}
		}
		return null;
	}
}