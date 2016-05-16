package cn.edu.fjnu.entity;

public class Intype {
	private int id;
	private String intypeNumber;
	private String intypeName;
	private String note;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIntypeNumber() {
		return intypeNumber;
	}
	public void setIntypeNumber(String intypeNumber) {
		this.intypeNumber = intypeNumber;
	}
	public String getIntypeName() {
		return intypeName;
	}
	public void setIntypeName(String intypeName) {
		this.intypeName = intypeName;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Intype [id=" + id + ", intypeNumber=" + intypeNumber + ", intypeName=" + intypeName + ", note=" + note
				+ "]";
	}
	
}
