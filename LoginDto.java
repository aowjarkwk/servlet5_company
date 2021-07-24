package servlet5_company;

public class LoginDto {

	int member_idx;
	String member_id;
	String member_pw;
	String member_name;
	String member_email;
	int member_email_receive;
	int member_pw_question;
	String member_pw_answer;
	String member_gender;
	String member_birth_date;
	String member_join_date;
	public int getMember_idx() {
		return member_idx;
	}
	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public int getMember_email_receive() {
		return member_email_receive;
	}
	public void setMember_email_receive(int member_email_receive) {
		this.member_email_receive = member_email_receive;
	}
	public int getMember_pw_question() {
		return member_pw_question;
	}
	public void setMember_pw_question(int member_pw_question) {
		this.member_pw_question = member_pw_question;
	}
	public String getMember_pw_answer() {
		return member_pw_answer;
	}
	public void setMember_pw_answer(String member_pw_answer) {
		this.member_pw_answer = member_pw_answer;
	}
	public String getMember_gender() {
		return member_gender;
	}
	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}
	public String getMember_birth_date() {
		return member_birth_date;
	}
	public void setMember_birth_date(String member_birth_date) {
		this.member_birth_date = member_birth_date;
	}
	public String getMember_join_date() {
		return member_join_date;
	}
	public void setMember_join_date(String member_join_date) {
		this.member_join_date = member_join_date;
	}
	public LoginDto(int member_idx, String member_id, String member_pw, String member_name, String member_email,
			int member_email_receive, int member_pw_question, String member_pw_answer, String member_gender,
			String member_birth_date, String member_join_date) {
		super();
		this.member_idx = member_idx;
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_name = member_name;
		this.member_email = member_email;
		this.member_email_receive = member_email_receive;
		this.member_pw_question = member_pw_question;
		this.member_pw_answer = member_pw_answer;
		this.member_gender = member_gender;
		this.member_birth_date = member_birth_date;
		this.member_join_date = member_join_date;
	}
	public LoginDto() {
		super();
	}
}
