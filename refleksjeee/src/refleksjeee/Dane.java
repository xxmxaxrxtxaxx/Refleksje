package refleksjeee;


public class Dane {
	private String tytul;
	private int tempo;
	private int rytm;
	private String album;
	private String wykonawca;
	private String text="90909";
	
	public String getTytul() {
		return tytul;
	}
	public void setTytul(String tytul) {
		this.tytul = tytul;
	}
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	public int getRytm() {
		return rytm;
	}
	public void setRytm(int rytm) {
		this.rytm = rytm;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getWykonawca() {
		return wykonawca;
	}
	public void setWykonawca(String wykonawca) {
		this.wykonawca = wykonawca;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

}
