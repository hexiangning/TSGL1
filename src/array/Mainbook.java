package array;

import java.util.Scanner;

import org.junit.Test;

public class Mainbook {
	public static final int size=10;
	Book[] list=new Book[size];
	int count = 0;  
	public Mainbook(){
		Scanner scan = new Scanner(System.in);  
        
        printMenu();  
          
        while(true)  
        {  
            //读取用户输入  
            int choice = scan.nextInt();  
              
            if(choice == 5)  
            {  
                System.out.println("成功退出系统，欢迎再次光临！");  
                break;  
            }  
            switch(choice)//switch形式  
            {  
            case 1: addBook(); break;  
            case 2: deleteBoo(); break;  
            case 3: changeBoo(); break;  
            case 4: findBoo(); break;  
            default: System.out.println("输入非法"); printMenu(); continue;//这个continue 是continue的while，  
            }  
        }  
	}
	@Test
	public void printMenu() {
		
		System.out.println("欢迎...");  
        System.out.println("增加图书...1");  
        System.out.println("删除图书...2");  
        System.out.println("修改图书...3");  
        System.out.println("查询图书...4");  
        System.out.println("退出系统...5"); 
	}
	@Test
	public void addBook() {
		// TODO Auto-generated method stub
		 if (count < size)  
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
	            list[count] = book;  
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
                    for(int i = id; i < count - 1 ; i++)//用for循环的形式实现对数组的删除  
                        list[i]=list[i+1];  
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
                    for(int j = id; j<count-1; j++)//用for循环的形式实现对数组的删除  
                    {  
                        list[j]=list[j+1];  
                    }  
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
	                    System.out.println("你要查找的书名为："+list[id].getBookname()+" 作者："+list[id].getAuthor()+" 单价："+list[id].getPrice()+"元/本");  
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
	                    System.out.println("查找成功，您查找到的书为第"+(id+1)+"本书！"+"书名为："+list[id].getBookname()+" 作者："+list[id].getAuthor()+" 单价："+list[id].getPrice()+"元/本");          
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
                    System.out.println("原书名为："+list[id].getBookname()+" 请输入你要修改为什么书名：");  
                    String str = scan.next();  
                    System.out.println("请输入作者：");  
                    String author = scan.next();  
                    System.out.println("请输入单价：");  
                    double price = scan.nextDouble();  
                    list[id].setBook(str,author,price);  
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
                    System.out.println("原书名为："+list[id].getBookname()+" 请输入你要修改为什么书名：");  
                    String str = scan.next();  
                   
                    System.out.println("请输入作者：");  
                    String author = scan.next();  
                    System.out.println("请输入单价：");  
                    double price = scan.nextDouble();  
                    list[id].setBook(str,author,price);  
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
            System.out.println("第"+(i+1)+"本书名："+list[i].getBookname()+" 作者："+list[i].getAuthor()+" 单价："+list[i].getPrice()+"元/本");  
        }  
		
	}
	
	public int nameFind(String name) {
		// TODO Auto-generated method stub
		 int id = -1;  
	        for(int i = 0; i < count; i++)  
	        {  
	            if(list[i].getBookname().equals(name))  
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
		new Mainbook();
	}
}
