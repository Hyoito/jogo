package models;

public class ChosenWord {
		
	private int id; 
	private String word;

	public ChosenWord() {
	
	}
	
	public ChosenWord(int cId, String cWord) {
		
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public String getWord() {
		return word;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}