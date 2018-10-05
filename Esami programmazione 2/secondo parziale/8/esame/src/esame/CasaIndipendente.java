package esame;

public class CasaIndipendente extends AreaAbitabile {
	
	private String indirizzo;
	private int superficie;
	
	
	public CasaIndipendente(String comune, String indirizzo, int superficie) throws AreaAbitabileException {
		super(comune);
		if( indirizzo==null|| superficie<0)
			throw new AreaAbitabileException();
		this.indirizzo = indirizzo;
		this.superficie = superficie;
		
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public int getSuperficie() {
		return superficie;
	}

	@Override
	public int getSuperficieTotale() {
		return this.getSuperficie();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CasaIndipendente other = (CasaIndipendente) obj;
		if (indirizzo == null) {
			if (other.indirizzo != null)
				return false;
		} else if (!indirizzo.equals(other.indirizzo)) return false;
		
		return true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" "+ indirizzo;
	}

	
	
}