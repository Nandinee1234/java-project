package com.project.java.models;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.List;
import com.project.java.dao.impl.Bookdaoimpl;
import com.project.java.dao.Bookdao;
import com.project.java.dao.impl.Studentdaoimpl;
import com.project.java.dao.Studentdao;
import com.project.java.dao.impl.BookTransactiondaoimpl;
import com.project.java.dao.BookTransactiondao;
public class Menu {
	public static void displayMenu() throws NumberFormatException, IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Bookdao bookdao=new Bookdaoimpl();
		Studentdao studentdao=new Studentdaoimpl();
		BookTransactiondaoimpl bookTransactiondaoimpl = new BookTransactiondaoimpl() ; 
		BookTransactiondao bookTransactiondao = new BookTransactiondaoimpl();
		
		int ch;
		do {
			 System.out.println("1.BookInfo");
			 System.out.println("2.StudentInfo");
			 System.out.println("3.BookTransactionInfo"); 
			 System.out.println("4.Exit");
			 
			 System.out.println("Enter your Choice :");
			 
			 ch=Integer.parseInt(br.readLine());
			
			 switch(ch)
			    {
			 
			 case 1:{
				 int ch1;
				    
				    
				    do {
	    System.out.println("1.Add Book");
	    System.out.println("2.View Book");
	    System.out.println("3.View All Books");
	    System.out.println("4.Update Book");
	    System.out.println("5.Delete Book");
	    System.out.println("6.Exit");
	    
	    
	    System.out.println("Enter your Choice :");
	  
	    ch1=Integer.parseInt(br.readLine());
	    
	    switch(ch1) {
	    case 1:{
	    	System.out.println("Enter Book Id :");
	    	int bid=Integer.parseInt(br.readLine());
	    	System.out.println("Enter Book Name :");
	    	String bname=br.readLine();
	    	System.out.println("Enter Author :");
	    	String authore=br.readLine();
	    	System.out.println("Enter publication");
	    	String publication=br.readLine();
	    	System.out.println("Enter year of publication");
	    	String date1=br.readLine();
	        Date yop=Date.valueOf(date1);
	    	System.out.println("Enter Book Price :");
	    	int price=Integer.parseInt(br.readLine());
	    	System.out.println("Enter Edition");
	    	int edition=Integer.parseInt(br.readLine());
	    	
	    	Book book=new Book(bid,bname,authore, publication,yop, price, edition);
	    	bookdao.addBook(book);
	        break;
	    	
	    }
	    case 2:{
	    	System.out.println("Enter Book Id :");
	    	int bid=Integer.parseInt(br.readLine());
	    	Book book=bookdao.getBookById(bid);
	    	System.out.println(book);
	    	break;
	    }
	    case 3:{
	    	List<Book> blist=bookdao.getAllBooks();
	    	System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "bid", "bname", "authore", "publication","yop","price","edition");
	    	for(Book book:blist)
	    		System.out.println(book);
	    	break;
	    }
	    case 4:{
	    	System.out.println("Enter Book Id :");
	    	int bid=Integer.parseInt(br.readLine());
	    	Book book=bookdao.getBookById(bid);
	    	if(book==null)
	    		return;
	    	System.out.println("Enter Book Name :");
	    	String bname=br.readLine();
	    	System.out.println("Enter Authore:");
	    	String authore=br.readLine();
	    	System.out.println("Enter publication");
	    	String publication=br.readLine();
	    	System.out.println("Enter year of publication");
	    	String date2=br.readLine();
	        Date yop=Date.valueOf(date2);
	    	System.out.println("Enter Book Price :");
	    	int price=Integer.parseInt(br.readLine());
	    	System.out.println("Enter Edition");
	    	int edition=Integer.parseInt(br.readLine());
	    	
	    	
	    	Book book1=new Book(bid,bname,authore,publication,yop, price,edition);
	    	bookdao.updateBook(book1);
	    	break;
	    }
	    case 5:{
	    	System.out.println("Enter Book Id :");
	    	int bid=Integer.parseInt(br.readLine());
	    	Book book=bookdao.getBookById(bid);
	    	if(book==null)
	    		return;
	    	bookdao.deleteBook(bid);
	    	break;
	    }
	    case 6:{
	    	System.out.println("Exit");
	    	break;
	    }
	    default :System.out.println("Please enter a valid choice");
	    }
	    }while(ch1!=6);
				    break;
			 }
	   
	
	    case 2:{
	    	int ch2;
	    	do {
    System.out.println("1.Add Student");
    System.out.println("2.View Student");
    System.out.println("3.View All Students");
    System.out.println("4.Update Student");
    System.out.println("5.Delete Student");
    System.out.println("6.Exit");
   
    
    
    	 System.out.println("Enter your Choice :");
    ch2=Integer.parseInt(br.readLine());
    
    switch(ch2)
    {
    case 1:{
    	System.out.println("Enter Student Id :");
    	int sid=Integer.parseInt(br.readLine());
    	System.out.println("Enter Student Name :");
    	String sname=br.readLine();
    	System.out.println("Enter Contact number :");
    	String contact=br.readLine();
    	System.out.println("Enter Address");
    	String address=br.readLine();
    	System.out.println("Enter email");
    	String email=br.readLine();
    	System.out.println("Enter age");
    	int age=Integer.parseInt(br.readLine());
    	System.out.println("Enter date of birth");
    	String date3=br.readLine();
        Date dob=Date.valueOf(date3);
    	System.out.println("Enter Course");
    	String course=br.readLine();
    	
    	Student student1=new Student(sid,sname,contact,address,email,age,dob,course);
    	studentdao.addStudent(student1);
       break;
    	
    }
    case 2:{
    	System.out.println("Enter Student Id :");
    	int sid=Integer.parseInt(br.readLine());
    	Student student=studentdao.getStudentById(sid);
    	System.out.println(student);
    	break;
    }
    case 3:{
    	List<Student> slist=studentdao.getAllStudent();
    	System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s  %-15s\n", "sid", "sname", "contact", "address","email","age","dob","course");
    	for(Student student:slist)
    		System.out.println(student);
    	break;
    }
    case 4:{
    	System.out.println("Enter Student Id :");
    	int sid=Integer.parseInt(br.readLine());
    	Student student=studentdao.getStudentById(sid);
    	if(student==null)
    		return;
   
    	System.out.println("Enter Student Name :");
    	String sname=br.readLine();
    	System.out.println("Enter Contact number :");
    	String contact=br.readLine();
    	System.out.println("Enter Address");
    	String address=br.readLine();
    	System.out.println("Enter email");
    	String email=br.readLine();
    	System.out.println("Enter age");
    	int age=Integer.parseInt(br.readLine());
    	System.out.println("Enter date of birth");
    	String date3=br.readLine();
        Date dob=Date.valueOf(date3);
    	System.out.println("Enter Course");
    	String course=br.readLine();
    	
    	
    	Student student1=new Student(sid,sname,contact,address,email,age,dob,course);
    	studentdao.updateStudent(student1);
    	break;
    }
    case 5:{
    	System.out.println("Enter Student Id :");
    	int sid=Integer.parseInt(br.readLine());
    	Student student=studentdao.getStudentById(sid);
    	if(student==null)
    		return;
    	studentdao.deleteStudent(sid);
    	break;
    }
    case 6:{
    	System.out.println("Exit");
    	break;
    }
    default :System.out.println("Please enter a valid choice");
    }
    }while(ch2!=6);
	    	break;
	    }
    
    
    case 3:{
    	int ch3;
    	do {
    System.out.println("1.Add BookTransaction");
    System.out.println("2.View BookTransaction");
    System.out.println("3.View All BookTransactions");
    System.out.println("4.Update BookTransaction");
    System.out.println("5.Delete BookTransaction");
    System.out.println("6.Exit");
    
 
    System.out.println("Enter your Choice :");
  
    ch3=Integer.parseInt(br.readLine());
    
    switch(ch3)
    {
    case 1:{
    	System.out.println("Enter BookTransaction Id :");
    	int btid=Integer.parseInt(br.readLine());
    	System.out.println("Enter Book id :");
    	int bid=Integer.parseInt(br.readLine());
    	System.out.println("Enter Student id :");
    	int sid=Integer.parseInt(br.readLine());
    	System.out.println("Enter Date of issue");
    	String date4=br.readLine();
        Date dateofissue=Date.valueOf(date4);
    	System.out.println("Enter Date of return");
    	String date5=br.readLine();
        Date dateofreturn=Date.valueOf(date5);
    	
    	BookTransaction bookTransaction=new BookTransaction(btid,bid,sid, dateofissue,dateofreturn);
    	bookTransactiondaoimpl.addBookTransaction(bookTransaction);
       break;
    	
    }
    case 2:{
    	System.out.println("Enter BookTransaction Id :");
    	int btid=Integer.parseInt(br.readLine());
    	
    	BookTransaction bookTransaction=bookTransactiondao.getBookTransactionById(btid);
    	System.out.println(bookTransaction);
    	break;
    }
    case 3:{
    	List<BookTransaction> btlist=bookTransactiondao.getAllBookTransactions();
		System.out.printf("%-15s %-15s %-15s %-15s %-15s\n", "btid", "bid", "sid", "dateofissue","dateofreturn");
    	for(BookTransaction bookTransaction:btlist)
    		System.out.println(bookTransaction);
    	break;
    }
    case 4:{
    	System.out.println("Enter BookTransation Id :");
    	int btid=Integer.parseInt(br.readLine());
    	BookTransaction bookTransaction=bookTransactiondao.getBookTransactionById(btid);
    	if(bookTransaction==null)
    		return;
    	 
    	System.out.println("Enter Book id :");
    	int bid=Integer.parseInt(br.readLine());
    	System.out.println("Enter Student id :");
    	int sid=Integer.parseInt(br.readLine());
    	System.out.println("Enter Date of issue");
    	String date4=br.readLine();
        Date dateofissue=Date.valueOf(date4);
    	System.out.println("Enter Date of return");
    	String date5=br.readLine();
        Date dateofreturn=Date.valueOf(date5);
    	
        BookTransaction bookTransaction1=new BookTransaction(btid,bid,sid, dateofissue,dateofreturn);
    	bookTransactiondao.addBookTransaction(bookTransaction1);
    	
    	 
    	break;
    }
    case 5:{
    	System.out.println("Enter BookTransaction Id :");
    	int btid=Integer.parseInt(br.readLine());
    	BookTransaction bookTransaction=bookTransactiondao.getBookTransactionById(btid);
    	if(bookTransaction==null)
    		return;
    	bookTransactiondao.deleteBookTransaction(btid);
    	break;
    }
    case 6:{
    	System.out.println("Exit");
    	break;
    }
    default :System.out.println("Please enter a valid choice");
    }
    }while(ch3!=6);
    	break;
    }
    
    case 4:
    {
    	System.out.println("Exit");
    	break;
    }
    default : System.out.println("Please enter a valid choice");
   
	}
}while(ch!=4);
		

	}
}

		