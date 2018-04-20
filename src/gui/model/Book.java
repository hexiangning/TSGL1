package gui.model;

public class Book {  
    private String bookname;  
    private String author;  
    private float price;  
    int bookid;
    public Book(String bookname, String author, float price)  
    {  
        this.bookname = bookname;  
        this.author = author;  
        this.price = price;  
    }  
  
    public Book(int iD, String bookName2, String author2, float price2) {
		// TODO Auto-generated constructor stub
    	this.bookname = bookName2;  
        this.author = author2;  
        this.price = price2;  
        this.bookid=iD;
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
  
    public float getPrice() {  
        return price;  
    }  
  
    public void setPrice(float price) {  
        this.price = price;  
    }
    public void setBookid(int bookid) {  
        this.bookid=bookid;  
    }
	public int getBookid() {
		// TODO Auto-generated method stub
		return bookid;
	}  
  
}  