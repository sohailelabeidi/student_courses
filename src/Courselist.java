import java.util.Scanner;
public class Courselist {
	
	Course head;
	Course location,predloc;
	Scanner read=new Scanner(System.in);
	
	void findresult(String key)
	{
		location=head;
		predloc=null;
		while(location!=null)
		{
			if(location.CourseNo.equalsIgnoreCase(key)==true)
			{
				System.out.println("This Course exist!");
				break;
			}
				else
				{
					predloc=location;
					location=location.next;
				}
		}
	}
	
	void insertresult(String name,double mark)
	{
		Course ptr= new Course();
		ptr.CourseNo=name;
		ptr.Mark=mark;
		ptr.next=head;
		head=ptr;
		
	}
	
	

}
