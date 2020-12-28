package gestionepatrimonio;

public final class ContantiEuro extends FonteProfitto  {



	public ContantiEuro(double valoretot, String name) {
		super(valoretot, name);
	}


	@Override
	public <T> T accept(VisitorFontiProfitto<T> visitor) {
		return visitor.visitContantiEuro(this);
	}


	@Override
	public int hashCode() {
		return super.hashCode();
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

}
