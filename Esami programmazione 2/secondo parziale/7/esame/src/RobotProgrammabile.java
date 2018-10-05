import java.util.ArrayList;
import java.util.Collection;

public class RobotProgrammabile {
	
	private PuntoXY posizione;
	private Collection<Mossa> programma;
	private ISupervisore supervisore;
	
	public RobotProgrammabile(ISupervisore supervisore) {
		this.supervisore = supervisore;
		posizione=new PuntoXY(0,0);
		programma=new ArrayList<>();
		if(supervisore==null || !supervisore.posizioneValida(posizione))
			throw new RobotException();
	}

	public PuntoXY getPosizione() {
		return posizione;
	}
	
	 public void aggiungiMossa(Mossa mossa) {
		 if(mossa!=null)
			 programma.add(mossa);
	 }
	
	 public void aggiungiMossa(Mossa[]mosse) {
		 for(int i=0;i<mosse.length;i++) {
			 aggiungiMossa(mosse[i]);
		 }	 
	 }
	 
	 public int numeroMosse() {
		 return programma.size();
	 }
	 
	 public boolean eseguiProgramma() {
		 for(Mossa i: programma ) {
			 posizione=i.esegui(posizione);
			 if(!supervisore.posizioneValida(posizione))
				 throw new RobotException();
		 }
		 return(supervisore.obiettivoRaggiunto(posizione));
	 }
}