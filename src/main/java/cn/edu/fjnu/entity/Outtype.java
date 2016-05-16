package cn.edu.fjnu.entity;

public class Outtype {
	private int id;
	private String outtypeNumber;
	private String outtypeName;
	private String note;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOuttypeNumber() {
		return outtypeNumber;
	}
	public void setOuttypeNumber(String outtypeNumber) {
		this.outtypeNumber = outtypeNumber;
	}
	public String getOuttypeName() {
		return outtypeName;
	}
	public void setOuttypeName(String outtypeName) {
		this.outtypeName = outtypeName;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Outtype [id=" + id + ", outtypeNumber=" + outtypeNumber + ", outtypeName=" + outtypeName + ", note="
				+ note + "]";
	}
	
	
}