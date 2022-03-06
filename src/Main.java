import java.util.Scanner;
public class Main {
	public static void main(String[] args)
	{
		Scanner read=new Scanner(System.in);
		int x = 0;
		int id;
		String name;
		String depart;
		Studentlist list=new Studentlist();
		while(x!=8)
		{
		System.out.println("Enter the operation");
		System.out.println("1)Insert Student"+"\t" +"2)retrive Student");
		System.out.println("3)Modify Student"+"\t" + "4)Delete Student");
		System.out.println("5)Insurt Result"+ "\t" + "        6)Print Student");
		System.out.println("7)Print Result"+ "\t"+ "        8)exit");
		x=read.nextInt();
		switch(x)
		{
		case 1:
			list.InsertStudent();
			break;
			
		case 2:
			System.out.println("enter the ID you want to retrive:");
			int n=read.nextInt();
			list.RetriveStudent(n);
			break;
		
		case 3:
			System.out.println("Enter the ID you want to modify:");
			int c=read.nextInt();
			list.ModifyStudent(c);
			break;
			
		case 4:
			System.out.println("Enter the ID you want to delete:");
			int d=read.nextInt();
			list.DeleteStudent(d);
			break;
			
		case 5:
			System.out.println("Enter the ID for which you want to add a result:");
			int i=read.nextInt();
			list.InsertResult(i);
			break;
			
		case 6:
			list.printStudents();
			break;
			
		case 7:
			System.out.println("Enter the ID whose results you want to print:");
			int r=read.nextInt();
			list.printStudentResult(r);
			break;
			
		case 8:
			break;
			
			
		}
		}

}
}
