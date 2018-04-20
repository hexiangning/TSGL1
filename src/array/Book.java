package array;

public class Book {
private String bookname;
private String author;
private double price;

public Book() {
	super();
	// TODO Auto-generated constructor stub
}

public Book(String bookname, String author, double price) {
	
	this.bookname = bookname;
	this.author = author;
	this.price = price;
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
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}

@Override
public String toString() {
	return " bookname=" + bookname + ", author=" + author
			+ ", price=" + price + "]";
}

public void setBook(String bookname, String author, double price) {
	// TODO Auto-generated method stub
	
}

}
