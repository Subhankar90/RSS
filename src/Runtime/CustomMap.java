package Runtime;
public class CustomMap {
	
	public String key;
	public String value;
	
	
	public CustomMap(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
