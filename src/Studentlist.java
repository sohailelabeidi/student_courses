import java.util.Scanner;

public class Studentlist {
	 Snode head;
	 Snode location;
	 Snode predloc;
	Scanner read=new Scanner(System.in);
	
	public Studentlist()
	{
		head=null;
	}
	
	void creatlist()
	{
		head=null;
	}
	
	void destroylist()
	{
		head=null;
		System.out.println("list destroy seccessfully");
	}
	
	boolean emptylist()
	{
		if(head==null) 
			return true;
			
		else
			return false;
	}
	
	void findStudent(int key)
	{
		location=head;
		predloc=null;
		while(location!=null)
		{
			if(location.id==key)
				break;
			else
				if(location.id>key)
					location=null;
				else
				{
					predloc=location;
					location=location.next;
				}
		}
	}
	
	void InsertStudent()
	{
		Snode pt;
		System.out.println("ENTER ID FROM (4000 to 4800):");
		int id = read.nextInt();
		if(id<4000 || id>4800)
			return;
		findStudent(id);
		if(location!=null)
		{
			System.out.println("ID EXIST!");
			return;
		}
		
			
			System.out.println("ENTER NAME:");
			String name = read.next();
			System.out.println("ENTER DEPARMENT:");
			String depart = read.next();
			 pt=new Snode(id,name,depart);
			if(predloc==null)
			{
				pt.next=head;
				head=pt;
			}
			else
			{
				pt.next=predloc.next;
				predloc.next=pt;
			}
			System.out.println("Student is registered");
	}
	
	void RetriveStudent(int no)
	{
		findStudent(no);
		if(location==null)
			System.out.println("Student not found");
		else
			System.out.println("ID:"+location.id);
			System.out.println("NAME:"+location.name);
			System.out.println("DEPARTMENT:"+location.depart);
			System.out.println("UNITS NUMBER:"+location.unitno);

	}
	
	void ModifyStudent(int no)
	{
		findStudent(no);
		if(location==null)
			System.out.println("Student not found");
		else
		{
			System.out.println("ENTER NEW NAME: ");
			location.name=read.next();
			System.out.println("ENTER NEW DEPARTMENT:");
			location.depart=read.next();
			System.out.println("Student information has been modified");
		}
	}
	
	void DeleteStudent(int no)
	{
		findStudent(no);
		if(location==null)
			System.out.println("The Student is not registered");
		
		if(location.unitno!=0)
			return;

			if(predloc==null)
				head=location.next;
			else
				predloc.next=location.next;
		System.out.println("Student:"+no+" seccessfully deleted");
	}
	
	void InsertResult(int no)
	{
		double m;
		String cn;
		boolean flag=true;
		findStudent(no);
		if(location==null)
		{
			System.out.println("Student not found");
			return;
		}
		
			System.out.println("ENTER COURSE NUMBER:");
			cn=read.next();
			System.out.println("ENTER MARK:");
			m=read.nextDouble();
			if(m<0 || m>100)
			{
				System.out.println("You can only enter marks from 0 to 100");
				return;
			}

			Course ptr=location.course.head;
			while(ptr!=null)
			{
				if(ptr.CourseNo.equals(cn))
					flag=false;
				ptr=ptr.next;
			}
		
			if(flag==false)
			{
				System.out.println("This course exist");
				return;
			}
			if(m<50)
			{
				System.out.println("The result will not be added because the student has failed");
				return;
			}
			if(location.unitno>=132)
			{
				System.out.println("The result cannot be entered because the student is a graduate");
				return;
			}
			
			location.course.insertresult(cn, m);
			location.unitno+=3;
			System.out.println("The result has been entered successfully");
			
		}
	
	void printStudents()
	{
		Snode p=head;
		System.out.println("ID"+"\t Name"+"\t Department"+"\t Units Number");
		while(p!=null) 
		{
			System.out.print(+p.id+"\t");
			System.out.print(p.name+"\t");
			System.out.print("\t"+p.depart+"\t"+"\t");
			System.out.println(p.unitno+"\t"+"\t"+"\t");
		p=p.next;
		}
	}
	
	void printStudentResult(int no)
	{
		findStudent(no);
		if(location==null)
			System.out.println("Student not found");
		else
		{
			System.out.print("COURSE NUMBER"+"\t");
			System.out.println("COURSE MARK"+"\t");
			Course p=location.course.head;
			while(p!=null)
			{
				
				System.out.print( p.CourseNo+"\t");
				System.out.println( "\t"+p.Mark);
				p=p.next;
			}
		}
	}

}
