package model.univariada;

import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.RoundingMode;

import model.univariada.Univariada;
import model.ColunaIncompativelException;
import model.Tabela;

public class Media implements Univariada
{
	public String calcular(int coluna) throws ColunaIncompativelException
	{
		ArrayList<String[]> tabela = Tabela.getTabela();
		int tamanho_tabela = tabela.size();
		if(tabela != null && tamanho_tabela > 1 && coluna >= 0)
		{
			try
			{
				BigDecimal soma = new BigDecimal(0);
				int n_NaN = 0;
				for(int i = 1; i < tamanho_tabela; i++)
				{
					String valor = tabela.get(i)[coluna];
					if(!valor.equals("NaN"))
						soma = soma.add(new BigDecimal(Double.parseDouble(valor)));
					else
						n_NaN++;
				}
				return soma.divide(new BigDecimal(tamanho_tabela - n_NaN), 3, RoundingMode.HALF_UP).toString();
			}
			catch(ArithmeticException e)
			{
				throw new ColunaIncompativelException("Nao e possivel calcular media nessa coluna: 1");	
			}
			catch(NumberFormatException e)
			{
				throw new ColunaIncompativelException("Nao e possivel calcular media nessa coluna");
			}
		}
		return null;
	}
}