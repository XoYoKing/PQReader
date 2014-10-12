package com.peng.pqreader.DB;

import java.util.ArrayList;
import java.util.List;

import com.peng.pqreader.bean.Book;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BookDAO {
	private BookSQLiteOpenHelpar helpar;

	/**
	 * 
	 * @param context�����Ļ���
	 */
	public BookDAO(Context context) {
		helpar = new BookSQLiteOpenHelpar(context);
	}

	/**
	 * 
	 * @param bookʵ��
	 *            ���һ���鵽���ݿ�
	 * @return
	 */
	public long add(Book book) {
		SQLiteDatabase db = helpar.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("bookname", book.getBookname());
		values.put("author", book.getAuthor());
		values.put("booklength", book.getBooklength());
		values.put("readlength", 0);
		values.put("state", 0);
		values.put("readtime", book.getReadtime());
		values.put("bookpath", book.getBookpath());
		long rowid = db.insert("book", null, values);
		return rowid;
	}
	
	
		public Book find(String name){
			SQLiteDatabase db=helpar.getReadableDatabase();
			Cursor cursor=db.query("book", null, "bookname=?", new String[]{name}, null, null, null);
			if(cursor.moveToNext()){
				String bookname = cursor.getString(0);
				String author = cursor.getString(1);
				int booklength = cursor.getInt(2);
				int readlength = cursor.getInt(3);
				int state = cursor.getInt(4);
				String readtime = cursor.getString(5);
				String bookpath = cursor.getString(6);
				Book book = new Book(bookname, author, booklength, readlength,
						state, readtime, bookpath);
				cursor.close();
				db.close();
				return book;
			}
			return null;
		}
	

	/**
	 * �������ݿ������е���
	 * 
	 * @return
	 */
	public List<Book> findAll() {
		SQLiteDatabase db = helpar.getReadableDatabase();
		Cursor cursor = db.query("book", null, null, null, null, null, null);
		List<Book> books = new ArrayList<>();
		while (cursor.moveToNext()) {
			String bookname = cursor.getString(0);
			String author = cursor.getString(1);
			int booklength = cursor.getInt(2);
			int readlength = cursor.getInt(3);
			int state = cursor.getInt(4);
			String readtime = cursor.getString(5);
			String bookpath = cursor.getString(6);
			Book book = new Book(bookname, author, booklength, readlength,
					state, readtime, bookpath);
			books.add(book);
		}
		cursor.close();
		db.close();
		return books;
	}

	/**
	 * �޸������Ϣ
	 * 
	 * @param name����
	 * @param length���Ķ��ĳ���
	 * @param state���״̬
	 */
	public void updateState(String name, int length, int state) {
		SQLiteDatabase db = helpar.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("readlength", length);
		values.put("state", state);
		db.update("book", values, "bookname=?", new String[] { name });
		db.close();
	}

	/**
	 * @param name����
	 * @return
	 */
	public int delete(String name) {
		SQLiteDatabase db = helpar.getWritableDatabase();
		int id = db.delete("book", "bookname=?", new String[] { name });
		db.close();
		return id;
	}
}
