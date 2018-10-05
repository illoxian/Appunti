import java.util.ArrayList;

public class Document extends DocumentItem {

	private ArrayList<DocumentItem> sezioni;
	
	public Document(DocumentItem begin) {
		if(begin==null)
			throw new NonValidDocumentException();
		this.sezioni = new ArrayList<DocumentItem>();
		sezioni.add(begin);
	}
	@Override
	
	public String getText() {
		String risultato="";
		for(DocumentItem i: sezioni)
			risultato+=i.getText();
		return risultato;
	}

	

	@Override
	public void update(DocumentItem other) throws ModifyingLockedDocumentException {
		if(isLocked())
			throw new ModifyingLockedDocumentException();
		sezioni.add(other);
	}
	
	public void update(DocumentItem other, int cursor) throws ModifyingLockedDocumentException {
		if(this.isLocked())
			throw new ModifyingLockedDocumentException();
		if(cursor>=0 && cursor<sezioni.size())
			sezioni.get(cursor).update(other);
		else
			update(other);
	}
}