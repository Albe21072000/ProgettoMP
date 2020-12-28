package gestionepatrimonio;

public final class Immobile extends FonteProfitto {
	private int metriquadrati;
	
	private double valorealmq;

	public Immobile(int metriquadrati, double valorealmq, String name) {
		super(metriquadrati*valorealmq, name);
		this.metriquadrati=metriquadrati;
		this.valorealmq=valorealmq;
	}
	public int getMetriQuadrati() {
		return metriquadrati;
	}

	public double getValorealmq() {
		return valorealmq;
	}


	@Override
	public <T> T accept(VisitorFontiProfitto<T> visitor) {
		return visitor.visitImmobile(this);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + metriquadrati;
		long temp;
		temp = Double.doubleToLongBits(valorealmq);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Immobile other = (Immobile) obj;
		if (metriquadrati != other.metriquadrati)
			return false;
		if (Double.doubleToLongBits(valorealmq) != Double.doubleToLongBits(other.valorealmq))
			return false;
		return true;
	}


}
