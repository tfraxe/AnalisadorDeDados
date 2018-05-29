package model.univariada;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.ArrayList;

import model.Tabela;
import model.ColunaIncompativelException;
import model.univariada.Media;

public class MomentoCentral
{
    private int coluna;
	private int momento;
	private int n_NaN;

    public MomentoCentral(int coluna, int momento)
    {
        this.coluna = coluna;
		this.momento = momento;
		n_NaN = 0;
	}
	
	public int getNaN()
	{
		return n_NaN;
	}

    public BigDecimal calcularMomento() throws ColunaIncompativelException
    {
        ArrayList<String[]> tabela = Tabela.getTabela();
		int tamanho_tabela = tabela.size();
		if(tabela != null && tamanho_tabela > 1 && coluna >= 0)
		{
			try
			{
				BigDecimal media = new BigDecimal(Double.parseDouble(new Media().calcular(coluna)));
				BigDecimal soma = new BigDecimal(0);
				ArrayList<Double> numeros = new ArrayList<Double>();
				for(int i = 1; i < tamanho_tabela; i++)
				{
					String valor = tabela.get(i)[coluna];
					if(!valor.equals("NaN"))
						numeros.add(Double.parseDouble(valor));
					else
						n_NaN++;
				}
				for(Double item : numeros)
					soma = soma.add(new BigDecimal(item.doubleValue()).subtract(media).pow(momento));
				return soma.divide(new BigDecimal(tamanho_tabela - n_NaN), 3, RoundingMode.HALF_UP);
			}
			catch(ArithmeticException e)
			{
				throw new ColunaIncompativelException("Nao e possivel calcular momento nessa coluna");
			}
			catch(NumberFormatException e)
			{
				throw new ColunaIncompativelException("Nao e possivel calcular momento nessa coluna");
			}
			catch(ColunaIncompativelException e)
			{
				throw new ColunaIncompativelException("Nao e possivel calcular momento nessa coluna");
			}
		}
		return null;
    }
}