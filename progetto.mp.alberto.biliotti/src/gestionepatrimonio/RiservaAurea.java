package gestionepatrimonio;

public class RiservaAurea extends FonteProfitto {
	
	private double grammioro;
	
	private final static int valoreoroeuro=50;

	public RiservaAurea(double grammioro, String name) {
		super(grammioro*valoreoroeuro, name);
		this.grammioro=grammioro;
		
	}

	public double getGrammioro() {
		return grammioro;
	}


	@Override
	public <T> T accept(VisitorFontiProfitto<T> visitor) {
		return visitor.visitRiservaAurea(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(grammioro);
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
		RiservaAurea other = (RiservaAurea) obj;
		if (Double.doubleToLongBits(grammioro) != Double.doubleToLongBits(other.grammioro))
			return false;
		return true;
	}

}
