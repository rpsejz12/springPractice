package model.board;

import java.util.Date;

public class BoardVO {
	private int pk;
	private String id;
	private String title;
	private String content;
	private Date wdate;
	public int getPk() {
		return pk;
	}
	public void setPk(int pk) {
		this.pk = pk;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	
	@Override
	public String toString() {
		return "BoardVO [pk=" + pk + ", id=" + id + ", title=" + title + ", content=" + content + ", wdate=" + wdate
				+ "]";
	}
	
	
	

}
