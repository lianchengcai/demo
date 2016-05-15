package cn.edu.fjnu.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import cn.edu.fjnu.validator.ValidGroup2;

public class Supply {
	private int id;
	private String sup;
	private String number;
	@NotEmpty(message="{dateBefore.isNull}",groups={ValidGroup2.class})
	private String dateBefore;
	@NotEmpty(message="{dateAfter.isNull}",groups={ValidGroup2.class})
	private String dateAfter;
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

	public String getSup() {
		return sup;
	}

	public void setSup(String sup) {
		this.sup = sup;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
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

	

	
	
}
