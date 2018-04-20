package mvc.model;

import java.util.ArrayList;

/* 
public class BookList extends ArrayList{ 
     
    public static BookList booklist = new BookList(); 
     
    public BookList() 
    { 
        try { 
            String filename = "D:\\Users\\alext\\workspace\\first\\book.txt"; 
            File file = new File(filename); 
            BufferedReader reader = new BufferedReader(new FileReader(file)); 
            String temp; 
            while((temp = reader.readLine()) != null) 
            { 
                String bookname = temp.split(",")[0]; 
                String author = temp.split(",")[1]; 
                String pricestr = temp.split(",")[2]; 
                float price = Float.parseFloat(pricestr); 
                Book book = new Book(bookname,author,price); 
                this.booklist.add(book); 
            } 
            reader.close(); 
        } catch (FileNotFoundException e) { 
            // TODO Auto-generated catch block 
            e.printStackTrace(); 
        } catch (NumberFormatException e) { 
            // TODO Auto-generated catch block 
            e.printStackTrace(); 
        } catch (IOException e) { 
            // TODO Auto-generated catch block 
            e.printStackTrace(); 
        } 
    } 
 
} 
*/  
  
public class BookList{  
      
    public static ArrayList<Book> booklist = new ArrayList<Book>();  
  
}  
