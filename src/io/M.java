package io;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

public class M {
	 static ArrayList<Book> list=new ArrayList<Book>();
	int count = 0;  
	public M(){
		Scanner scan = new Scanner(System.in);  
        
        printMenu();  
        IO io = new IO();   
//        io.load(this);    
        while(true)  
        {  
            //读取用户输入  
            int choice = scan.nextInt();  
              
            if(choice == 5)  
            {  
//                io.save(this);  
                System.out.println("成功退出系统，欢迎再次光临！");  
                break;  
            }  
            switch(choice)//switch形式  
            {  
            case 1: addBook(); break;  
            case 2: deleteBoo(); break;  
            case 3: changeBoo(); break;  
            case 4: findBoo(); break;  
            case 6: findAll();break;
            default: System.out.println("输入非法"); printMenu(); continue;//这个continue 是continue的while，  
            }  
        }  
	}
	private void findAll() {
		// TODO Auto-generated method stub
		printAllBook();
	}
	@Test
	public void printMenu() {
		
		System.out.println("欢迎...");  
        System.out.println("增加图书...1");  
        System.out.println("删除图书...2");  
        System.out.println("修改图书...3");  
        System.out.println("查询图书...4");  
        System.out.println("退出系统...5"); 
        System.out.println("差所有...6"); 

	}
	@Test
	public void addBook() {
		// TODO Auto-generated method stub
		 if (count <= list.size())  
	        {  
	            System.out.println("当前共有:"+count+"本书!");  
	            Scanner scan = new Scanner(System.in);  
	            System.out.println("请输入图书名：");  
	            String bookname = scan.next();  
	            System.out.println("请输入作者：");  
	            String author = scan.next();  
	            System.out.println("请输入单价：");  
	            double price = scan.nextDouble();  
	            Book book = new Book(bookname,author,price);  
	            list.add(book);
	            count++;  
	            System.out.println("增加成功！");  
	            printAllBook();  
	        }  
	        else  
	        {  
	            System.out.println("图书库已满！");  
	        }  
	}
	@Test
	public void deleteBoo() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);  
        while(true)  
        {  
            System.out.println("请输入按哪种方法删除图书：1、id/2、书名/3、返回主菜单");  
            int choose = scan.nextInt();  
            if(choose == 1)  
            {  
                System.out.println("请输入要删除第几本书：");  
                int id = scan.nextInt();  
                id = orderFind(id);  
                //System.out.println(id);  
                if(id > -1)  
                {  
                    list.remove(id);
                    count--;  
                    System.out.println("删除成功！");  
                    printAllBook();  
                }  
                else  
                {  
                    System.out.println("输入错误！");  
                }  
            }  
            else if(choose == 2)  
            {  
                System.out.println("请输入您要删除的书名：");  
                String name = scan.next();  
                int id = nameFind(name);  
                if(id > -1)  
                {  
                    list.remove(id);
                    count --;  
                    System.out.println("删除成功！");  
                    printAllBook();  
                }  
                else  
                {  
                        System.out.println("未查找到您想要的书名");  
                }     
            }  
            else if(choose == 3)  
            {  
                printMenu();  
                break; //这个break会跳出当前循环，从而实现跳出当前函数，返回上一级循环，即主菜单。  
            }  
            else  
            {  
                System.out.println("输入非法！");  
            }  
        }  
	}
	@Test
	public void findBoo() {
		// TODO Auto-generated method stub
		 Scanner scan = new Scanner(System.in);  
	        while(true)  
	        {  
	            System.out.println("请输入按哪种方法查找图书：1、序号/2、书名/3、返回主菜单");  
	            int choose = scan.nextInt();  
	            if(choose == 1)  
	            {  
	                System.out.println("请输入要查找第几本书：");  
	                int number = scan.nextInt();  
	                int id = orderFind(number);  
	                if(id > -1)  
	                {  
	                	Book book=list.get(id);
	                    System.out.println("你要查找的书名为："+book.getBookname()+" 作者："+book.getAuthor()+" 单价："+book.getPrice()+"元/本");  
	                }  
	                else  
	                {  
	                    System.out.println("输入错误！");  
	                }  
	            }  
	            else if(choose == 2)  
	            {  
	                System.out.println("请输入您要查找的书名：");  
	                String name = scan.next();  
	                int id = nameFind(name);  
	                if(id > -1)  
	                {  
	                	Book book=list.get(id);
	                    System.out.println("你要查找的书名为："+book.getBookname()+" 作者："+book.getAuthor()+" 单价："+book.getPrice()+"元/本");          
	                }  
	            }  
	            else if(choose == 3)  
	            {  
	                printMenu();  
	                break;  
	            }  
	            else  
	            {  
	                System.out.println("输入非法！");  
	            }  
	        }  
	}
	@Test
	public void changeBoo() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);  
        while(true)  
        {  
            System.out.println("请输入按哪种方法修改图书：1、序号/2、书名/3、返回主菜单");  
            int choose = scan.nextInt();  
            if(choose == 1)  
            {  
                System.out.println("请输入要修改第几本书：");  
                int number = scan.nextInt();  
                int id = orderFind(number);  
                if(id > -1)  
                {  
                	Book book=list.get(id);
                    System.out.println("原书名为："+book.getBookname()+" 请输入你要修改为什么书名：");   
                    String str = scan.next();  
                    System.out.println("请输入作者：");  
                    String author = scan.next();  
                    System.out.println("请输入单价：");  
                    double price = scan.nextDouble();  
                    book.setBook(str,author,price);  
                    list.add(book);
                    System.out.println("修改成功！");  
                    printAllBook();  
                }  
                else  
                {  
                    System.out.println("输入错误！");  
                }  
            }  
            else if(choose == 2)  
            {  
                System.out.println("请输入您要修改的书名：");  
                String name = scan.next();  
                int id = nameFind(name);  
                if(id > -1)  
                {  
                	Book book=list.get(id);
                    System.out.println("原书名为："+book.getBookname()+" 请输入你要修改为什么书名：");  
                    String str = scan.next();  
                   
                    System.out.println("请输入作者：");  
                    String author = scan.next();  
                    System.out.println("请输入单价：");  
                    double price = scan.nextDouble();  
                    book.setBook(str,author,price);  
                    list.add(book);
                    System.out.println("修改成功！");  
                    printAllBook();       
                }  
            }  
            else if(choose == 3)  
            {  
                printMenu();  
                break;  
            }  
            else  
            {  
                System.out.println("输入非法！");  
            }  
        }  
	}
	@Test
	public void printAllBook() {
		// TODO Auto-generated method stub
		for (int i = 0; i < count; i++)  
        { 
			Book book=list.get(i);
        
            System.out.println("第"+(i+1)+"本书名："+book.getBookname()+" 作者："+book.getAuthor()+" 单价："+book.getPrice()+"元/本");  
        }  
		
	}
	
	public int nameFind(String name) {
		// TODO Auto-generated method stub
		 int id = -1;  
	        for(int i = 0; i < count; i++)  
	        {  
	        	Book book=list.get(i);
	        	
	            if(book.getBookname().equals(name))  
	            {  
	                id = i;  
	                break;  
	            }  
	            else if(i<count)  
	                continue;  
	            else  
	            {  
	                System.out.println("未查找到您想要的书名");  
	                break;  
	            }  
	        }  
	        return id; 
	}

	public int orderFind(int number) {
		// TODO Auto-generated method stub
		 if(number <= count)  
	        {  
	            int id = number - 1;  
	            return id;  
	        }  
	        else  
	            return -1;  
	}
	public static void main(String[] args) {
		new M();
	}
}
