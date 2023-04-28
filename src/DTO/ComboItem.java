package DTO;

public class ComboItem {
	public String key;
	public String value;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public ComboItem(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	public ComboItem() {
		super();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.value;
	}
}
