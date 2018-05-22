package model;

public interface TabelaObservable {
	public void addObservers(TabelaObserver to);
	public static void notificar() {};
} 