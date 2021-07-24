package servlet5_company;

public class CommunityDto {
	int notice_idx;
	String notice_title;
	String notice_content;
	String notice_member_id;
	String notice_date;
	public CommunityDto() {
		super();
	}
	public CommunityDto(int notice_idx, String notice_title, String notice_content, String notice_member_id,
			String notice_date) {
		super();
		this.notice_idx = notice_idx;
		this.notice_title = notice_title;
		this.notice_content = notice_content;
		this.notice_member_id = notice_member_id;
		this.notice_date = notice_date;
	}
	public int getNotice_idx() {
		return notice_idx;
	}
	public void setNotice_idx(int notice_idx) {
		this.notice_idx = notice_idx;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public String getNotice_member_id() {
		return notice_member_id;
	}
	public void setNotice_member_id(String notice_member_id) {
		this.notice_member_id = notice_member_id;
	}
	public String getNotice_date() {
		return notice_date;
	}
	public void setNotice_date(String notice_date) {
		this.notice_date = notice_date;
	}

}
