package gestion_equipo_futbol;

public enum Posicion 
{
	PORTERO(2),
	DEFENSA(5),
	CENTROCAMPISTA(5),
	DELANTERO(4);
	private int limitePosiciones;
	Posicion(int limite)
	{	this.limitePosiciones=limite;	}
	public int getLimitePosiciones() 
	{	return limitePosiciones;	}
	public void setLimitePosiciones(int limitePosiciones) 
	{	this.limitePosiciones = limitePosiciones;	}
}
