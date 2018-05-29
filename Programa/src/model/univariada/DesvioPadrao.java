package model.univariada;

import java.util.ArrayList;
import java.util.Locale;
import java.math.BigDecimal;
import java.math.RoundingMode;

import model.univariada.Univariada;
import model.univariada.Variancia;
import model.ColunaIncompativelException;
import model.Tabela;

public class DesvioPadrao implements Univariada
{
	public String calcular(int coluna) throws ColunaIncompativelException
	{
		ArrayList<String[]> tabela = Tabela.getTabela();
		if(tabela != null && tabela.size() > 1 && coluna >= 0)
		{
			try
			{
				BigDecimal variancia = new BigDecimal(Double.parseDouble(new Variancia().calcular(coluna)));
				double desvio_padrao = Math.sqrt(variancia.doubleValue());
				return String.format(Locale.ROOT, "%.2f", desvio_padrao);
			}
			catch(NumberFormatException e)
			{
				throw new ColunaIncompativelException("Nao e possivel calcular desvio padrao nessa coluna");
			}
			catch(ColunaIncompativelException e)
			{
				throw new ColunaIncompativelException("Nao e possivel calcular desvio padrao nessa coluna");
			}
		}
		return null;
	}
}