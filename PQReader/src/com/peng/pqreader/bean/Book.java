package com.peng.pqreader.bean;


/**
 * 
 * @author android �������ʵ��
 */
public class Book {
	private String bookname;// ����
	private String author;// ����
	private int booklength;// ����ܳ���
	private int readlength;// ���Ķ��ĳ���
	private int state;//״̬ 0�������Ķ�  1���Ѷ���
	private String readtime;// ����Ķ�ʱ��
	private String bookpath;//��Ĵ洢·��
	/**
	 * 
	 * @param bookname����
	 * @param author����
	 * @param booklength����ܳ���
	 * @param readlength���Ķ��ĳ���
	 * @param state ״̬ 0�������Ķ�  1���Ѷ���
	 * @param readtime����Ķ�ʱ��
	 */
	public Book(String bookname, String author, int booklength, int readlength, int state,
			String readtime,String bookpath) {
		super();
		this.bookname = bookname;
		this.author = author;
		this.booklength = booklength;
		this.readlength = readlength;
		this.state=state;
		this.readtime = readtime;
		this.bookpath=bookpath;
	}
	
	
	public Book() {
		super();
	}


	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getBooklength() {
		return booklength;
	}

	public void setBooklength(int booklength) {
		this.booklength = booklength;
	}

	public int getReadlength() {
		return readlength;
	}

	public void setReadlength(int readlength) {
		this.readlength = readlength;
	}

	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	public String getReadtime() {
		return readtime;
	}

	public void setReadtime(String readtime) {
		this.readtime = readtime;
	}


	public String getBookpath() {
		return bookpath;
	}


	public void setBookpath(String bookpath) {
		this.bookpath = bookpath;
	}

}
