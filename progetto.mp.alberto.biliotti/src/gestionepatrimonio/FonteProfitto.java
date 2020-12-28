package gestionepatrimonio;

public abstract class FonteProfitto {
	
	private double valoretot;
	
	private String name;

	public FonteProfitto(double valoretot, String name) {
		this.valoretot = valoretot;
		this.name=name;
	}
	
	
	public double getValoretot() {
		return valoretot;
	}


	public String getName() {
		return name;
	}


	public abstract <T>  T accept(VisitorFontiProfitto<T> visitor);

}
