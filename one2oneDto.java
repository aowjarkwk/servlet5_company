package servlet5_company;

public class one2oneDto {
	int one2one_idx;
	String one2one_name;
	String one2one_phone;
	String one2one_address;
	String one2one_title;
	public int getOne2one_idx() {
		return one2one_idx;
	}
	public void setOne2one_idx(int one2one_idx) {
		this.one2one_idx = one2one_idx;
	}
	public String getOne2one_name() {
		return one2one_name;
	}
	public void setOne2one_name(String one2one_name) {
		this.one2one_name = one2one_name;
	}
	public String getOne2one_phone() {
		return one2one_phone;
	}
	public void setOne2one_phone(String one2one_phone) {
		this.one2one_phone = one2one_phone;
	}
	public String getOne2one_address() {
		return one2one_address;
	}
	public void setOne2one_address(String one2one_address) {
		this.one2one_address = one2one_address;
	}
	public String getOne2one_title() {
		return one2one_title;
	}
	public void setOne2one_title(String one2one_title) {
		this.one2one_title = one2one_title;
	}
	public String getOne2one_content() {
		return one2one_content;
	}
	public void setOne2one_content(String one2one_content) {
		this.one2one_content = one2one_content;
	}
	public String getOne2one_date() {
		return one2one_date;
	}
	public void setOne2one_date(String one2one_date) {
		this.one2one_date = one2one_date;
	}
	String one2one_content;
	String one2one_date;
	public one2oneDto(int one2one_idx, String one2one_name, String one2one_phone, String one2one_address,
			String one2one_title, String one2one_content, String one2one_date) {
		super();
		this.one2one_idx = one2one_idx;
		this.one2one_name = one2one_name;
		this.one2one_phone = one2one_phone;
		this.one2one_address = one2one_address;
		this.one2one_title = one2one_title;
		this.one2one_content = one2one_content;
		this.one2one_date = one2one_date;
	}
	public one2oneDto() {
		super();
	}
	
}
