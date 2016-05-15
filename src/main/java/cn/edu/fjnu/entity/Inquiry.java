package cn.edu.fjnu.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import cn.edu.fjnu.validator.ValidGroup1;
import cn.edu.fjnu.validator.ValidGroup2;

public class Inquiry {
	private int id;
	private String number;
	@NotNull(message="{date.isNull}",groups={ValidGroup1.class})
	private Date date;
	@NotEmpty(message="{dateBefore.isNull}",groups={ValidGroup2.class})
	private String dateBefore;
	@NotEmpty(message="{dateAfter.isNull}",groups={ValidGroup2.class})
	private String dateAfter;
	private String type;
	private String sup;
	private String trustee;
	private String operator;
	private String items;
	private int sumNum;
	private float sumMoney;
	private String note;

	//定义itemsCustom
	private Items itemsCustom;
	
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDateBefore() {
		return dateBefore;
	}
	public void setDateBefore(String dateBefore) {
		this.dateBefore = dateBefore;
	}
	public String getDateAfter() {
		return dateAfter;
	}
	public void setDateAfter(String dateAfter) {
		this.dateAfter = dateAfter;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSup() {
		return sup;
	}
	public void setSup(String sup) {
		this.sup = sup;
	}
	public String getTrustee() {
		return trustee;
	}
	public void setTrustee(String trustee) {
		this.trustee = trustee;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public int getSumNum() {
		return sumNum;
	}
	public void setSumNum(int sumNum) {
		this.sumNum = sumNum;
	}
	public float getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(float sumMoney) {
		this.sumMoney = sumMoney;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Items getItemsCustom() {
		return itemsCustom;
	}
	public void setItemsCustom(Items itemsCustom) {
		this.itemsCustom = itemsCustom;
	}
	@Override
	public String toString() {
		return "Inquiry [id=" + id + ", number=" + number + ", date=" + date + ", dateBefore=" + dateBefore
				+ ", dateAfter=" + dateAfter + ", type=" + type + ", sup=" + sup + ", trustee=" + trustee
				+ ", operator=" + operator + ", items=" + items + ", sumNum=" + sumNum + ", sumMoney=" + sumMoney
				+ ", note=" + note + ", itemsCustom=" + itemsCustom + "]";
	}
	
	
	
}
