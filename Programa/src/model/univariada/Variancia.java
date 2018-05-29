package model.univariada;

import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.RoundingMode;

import model.univariada.MomentoCentral;
import model.univariada.Univariada;
import model.ColunaIncompativelException;
import model.Tabela;

public class Variancia implements Univariada
{
    public String calcular(int coluna) throws ColunaIncompativelException
	{
        ArrayList<String[]> tabela = Tabela.getTabela();
        int tamanho_tabela = tabela.size();
		if(tabela != null && tamanho_tabela > 1 && coluna >= 0)
		{
			try
			{
				return new MomentoCentral(coluna, 2).calcularMomento().toString();
			}
            catch(ColunaIncompativelException e)
            {
                throw new ColunaIncompativelException("Nao e possivel calcular variancia nessa coluna");
            }
		}
		return null;
	}
}