package model;

import java.lang.Exception;

public class ColunaIncompativelException extends Exception
{
	public ColunaIncompativelException()
	{
		super();
	}

	public ColunaIncompativelException(String mensagem)
	{
		super(mensagem);
	}

	public ColunaIncompativelException(String mensagem, Throwable causa) 
	{ 
		super(mensagem, causa); 
	}
  	public ColunaIncompativelException(Throwable causa) 
  	{ 
  		super(causa); 
  	}
}