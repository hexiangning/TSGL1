package datebase.ui;

import java.util.Scanner;  

import datebase.control.Operator;
  
public class MainClass {  
      
    public MainClass()  
    {  
          
        Scanner scan = new Scanner(System.in);  
        printMenu();  
          
        while(true)  
        {  
            //读取用户输入  
            int choice = scan.nextInt();  
              
            if(choice == 6)  
            {  
                System.out.println("成功退出系统，欢迎再次光临！");  
                break;  
            }  
            switch(choice)  
            {  
            case 1: addBook(); break;  
            case 2: deleteBoo(); break;  
            case 3: changeBoo(); break;  
            case 4: findBoo(); break;  
            case 5: clearBoo(); break;  
            default: System.out.println("输入非法"); printMenu(); continue;  
            }  
        }  
          
          
       
    }  
    void printMenu()  
    {  
        //打印菜单  
        System.out.println("欢迎...");  
        System.out.println("增加图书...1");  
        System.out.println("删除图书...2");  
        System.out.println("修改图书...3");  
        System.out.println("查询图书...4");  
        System.out.println("清空图书...5");  
        System.out.println("退出系统...6");   
    }  
      
    void clearBoo()  
    {  
        Operator operator = new Operator();  
        boolean isSuccess = operator.clearBook();  
        if(isSuccess)  
        {  
            System.out.println("清空成功！");  
        }  
        else  
        {  
            System.out.println("清空失败！");  
        }  
    }  
      
    void addBook()  
    {  
        Scanner scan = new Scanner(System.in);  
        System.out.println("请输入图书名：");  
        String bookname = scan.next();  
        System.out.println("请输入作者：");  
        String author = scan.next();  
        System.out.println("请输入单价：");  
        float price = scan.nextFloat();  
        Operator operator = new Operator();  
        boolean isSuccess = operator.addBook(bookname, author, price);  
        if(isSuccess)  
        {  
            System.out.println("增加成功！");  
        }  
        else  
        {  
            System.out.println("增加失败！");  
        }  
        operator.printAllbook();  
    }  
      
    void deleteBoo()  
    {  
        Scanner scan = new Scanner(System.in);  
        String name = "";  
        while(true)  
        {  
            System.out.println("请输入按哪种方法删除图书：1、编号/2、书名/3、返回主菜单");  
            int choose = scan.nextInt();  
            int id = -1;  
            if(choose == 1)  
            {  
                System.out.println("请输入要删除的书的编号：");  
                id = scan.nextInt();  
                Operator operator = new Operator();  
                //System.out.println(id);  
                if(id > -1)  
                {  
                    boolean isSuccess = operator.deleteBook(id,name);  
                    if(isSuccess)  
                        System.out.println("删除成功！");  
                    else  
                        System.out.println("删除失败！");  
                    operator.printAllbook();  
                }  
                else  
                {  
                    System.out.println("输入错误！");  
                }  
            }  
            else if(choose == 2)  
            {  
                System.out.println("请输入您要删除的书名：");  
                name = scan.next();  
                Operator operator = new Operator();  
                if(name != "")  
                {  
                    boolean isSuccess = operator.deleteBook(id,name);  
                    if(isSuccess)  
                        System.out.println("删除成功！");  
                    else  
                        System.out.println("删除失败！");  
                    operator.printAllbook();  
                }  
                else  
                {  
                        System.out.println("未查找到您想要的书名");  
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
      
    void changeBoo()  
    {  
        Scanner scan = new Scanner(System.in);  
        String name = "";  
        while(true)  
        {  
            System.out.println("请输入按哪种方法修改图书：1、编号/2、书名/3、返回主菜单");  
            int choose = scan.nextInt();  
            int id = -1;  
            if(choose == 1)  
            {  
                System.out.println("请输入要修改的书的编号：");  
                id = scan.nextInt();  
                Operator operator = new Operator();  
                if(id > -1)  
                {  
                    System.out.println("请输入你要修改什么书名：");  
                    String str = scan.next();  
                    boolean isSuccess = operator.changeBoo(id,str,name);  
                    if(isSuccess)  
                        System.out.println("修改成功！");  
                    else  
                        System.out.println("修改失败！");  
                      
                    operator.printAllbook();  
                }  
                else  
                {  
                    System.out.println("输入错误！");  
                }  
            }  
            else if(choose == 2)  
            {  
                System.out.println("请输入您要修改的书名：");  
                name = scan.next();  
                Operator operator = new Operator();  
                if(name != "")  
                {     
                    System.out.println("请输入你要修改为什么书名：");  
                    String str = scan.next();  
                    boolean isSuccess = operator.changeBoo(id,str,name);  
                    if(isSuccess)  
                        System.out.println("修改成功！");  
                    else  
                        System.out.println("修改失败！");  
                    operator.printAllbook();  
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
      
    void findBoo()  
    {  
        Scanner scan = new Scanner(System.in);  
        Operator operator = new Operator();  
        String name = "";  
        int id = -1;  
        while(true)  
        {  
            System.out.println("请输入按哪种方法查找图书：1、编号/2、书名/3、返回主菜单");  
            int choose = scan.nextInt();  
            if(choose == 1)  
            {  
                System.out.println("请输入要查找的书的编号：");  
                id = scan.nextInt();  
                if(id > -1)  
                {  
                    operator.findBoo(id,name);  
                }  
                else  
                {  
                    System.out.println("输入错误！");  
                }  
            }  
            else if(choose == 2)  
            {  
                System.out.println("请输入您要查找的书名：");  
                name = scan.next();  
                if(name != "")  
                {  
                    operator.findBoo(id,name);  
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
      
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        new MainClass();  
    }  
  
}  