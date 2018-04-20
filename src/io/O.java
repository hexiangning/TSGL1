package io;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class O {
	 public void load(Mainbook mainClass)//读取文件  
	    {  
	        try {  
	            String filename = "D:\\tsgl\\book.txt";//也可以用d:/xxx/xxx的形式  
	            File file = new File(filename);  
	            if(!file.exists()){
	            	  file.createNewFile();
	            	  }
	            BufferedReader reader = new BufferedReader(new FileReader(file));  
	            String temp;  
	            while((temp = reader.readLine()) != null)  
	            {  
	                String bookname = temp.split(",")[0];  
	                String author = temp.split(",")[1];  
	                String pricestr = temp.split(",")[2];  
	                double price = Double.parseDouble(pricestr);
	                Book book = new Book(bookname,author,price);  
	                mainClass.list.add(book);  
	                mainClass.count++;  
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
	      
	    public void save(Mainbook mainClass)//写入文件  
	    {  
	        String fileName = "D:\\tsgl\\book.txt";  
	        String allbook="";  
	        for(int i = 0; i < mainClass.list.size(); i++)  
	        {  
	            Book book = (Book)mainClass.list.get(i);  
	            String temp = book.getBookname() + "," + book.getAuthor() + "," + book.getPrice() + "\r\n";  
	            allbook += temp;  
	        }  
	        try {  
	            File file1 = new File(fileName);  
	            FileWriter fileWriter;  
	            fileWriter = new FileWriter(file1);  
	            fileWriter.write(allbook);  
	            fileWriter.close();  
	        } catch (IOException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	          
	    }  
	  
}
