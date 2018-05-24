package model;

import model.Analise;
import model.ColunaIncompativelException;
import model.Tabela;
import java.util.ArrayList;

public class Media implements Analise
{
	public Double calcular(int coluna) throws ColunaIncompativelException
	{
		ArrayList<String[]> tabela = Tabela.getTabela();
		if(tabela != null && tabela.size() > 1)
		{
			try
			{
				double soma = 0;
				for(String[] linha : tabela)
				{
					Double numero = Double.valueOf(linha[coluna]);
					soma += numero.doubleValue();
				}
				return new Double(soma / tabela.size());
			}
			catch(NumberFormatException exception)
			{
				throw new ColunaIncompativelException("Nao e possivel calcular media nessa coluna");
			}
		}
		return null;
	}
}