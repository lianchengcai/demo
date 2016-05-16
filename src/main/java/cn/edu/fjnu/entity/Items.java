package cn.edu.fjnu.entity;

public class Items {
	private int id;
	private String number;
	private String name;
	private String sort;
	private String model;
	private String piece;
	private float price;
	private int totalNum;
	private float totalMoney;
	private int higher;
	private int lower;
	private String sup;
	private String note;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getPiece() {
		return piece;
	}
	public void setPiece(String piece) {
		this.piece = piece;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public float getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}
	public int getHigher() {
		return higher;
	}
	public void setHigher(int higher) {
		this.higher = higher;
	}
	public int getLower() {
		return lower;
	}
	public void setLower(int lower) {
		this.lower = lower;
	}
	public String getSup() {
		return sup;
	}
	public void setSup(String sup) {
		this.sup = sup;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Items [id=" + id + ", number=" + number + ", name=" + name + ", sort=" + sort + ", model=" + model
				+ ", piece=" + piece + ", price=" + price + ", totalNum=" + totalNum + ", totalMoney=" + totalMoney
				+ ", higher=" + higher + ", lower=" + lower + ", sup=" + sup + ", note=" + note + "]";
	}
	
	
	
}