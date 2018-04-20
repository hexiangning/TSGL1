package gui.ui;
import gui.model.Book;

import java.awt.BorderLayout;  
import java.awt.EventQueue;  
  
import javax.swing.JFrame;  
import javax.swing.JPanel;  
import javax.swing.JScrollPane;  
import javax.swing.border.EmptyBorder;  
import javax.swing.JTable;  
import javax.swing.table.DefaultTableModel;  
  
import javax.swing.JButton;  
import java.awt.event.ActionListener;  
import java.util.ArrayList;  
import java.awt.event.ActionEvent;  
  
public class PrintUI extends JFrame {  
  
    private JPanel contentPane;  
    private JTable table;  
    private JButton button;  
  
    /** 
     * Launch the application. 
     */  
    public static void main(String[] args) {  
        EventQueue.invokeLater(new Runnable() {  
            public void run() {  
                try {  
                    ArrayList<Book> booklist = null;  
                    PrintUI frame = new PrintUI(booklist);  
                    frame.setVisible(true);  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
        });  
    }  
  
    /** 
     * Create the frame. 
     */  
    public PrintUI(ArrayList<Book> booklist) {  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setBounds(100, 100, 450, 300);  
        contentPane = new JPanel();  
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));  
        setContentPane(contentPane);  
        contentPane.setLayout(null);  
        int high = booklist.size();  
        Object[][] obj = new Object[high][4];  
        for (int j = 0; j < booklist.size(); j++)    
        {    
            Book book = (Book)booklist.get(j);    
            System.out.println("编号"+book.getBookid()+" 书名："+book.getBookname()+" 作者："+book.getAuthor()+" 单价："+book.getPrice()+"元/本");  
            obj[j][0] = Integer.toString(book.getBookid());  
            obj[j][1] = book.getBookname();  
            obj[j][2]   = book.getAuthor();  
            obj[j][3] = book.getPrice() + "";  
        }  
        table = new JTable();  
        table.setModel(new DefaultTableModel(  
            obj,  
            new String[] {  
                "\u7F16\u53F7", "\u4E66\u540D", "\u4F5C\u8005", "\u4EF7\u683C"  
            }  
        ));  
        table.setBounds(54, 211, 306, -186);  
        JScrollPane scroll = new JScrollPane(table);  
        scroll.setLocation(0, 0);  
        scroll.setSize(428,208);  
        contentPane.add(scroll);  
          
        button = new JButton("\u8FD4\u56DE\u4E3B\u83DC\u5355");  
        button.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent arg0) {  
                MenuUI menu = new MenuUI();  
                menu.setVisible(true);  
                PrintUI.this.dispose();  
            }  
        });  
        button.setBounds(271, 215, 123, 29);  
        contentPane.add(button);  
        this.setVisible(true);  
    }  
}  