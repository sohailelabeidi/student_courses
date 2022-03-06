

public class Snode {
	int id;
	String name;
	String depart;
	int unitno;
	Snode next;
	Courselist course;
	
	public Snode(int id,String name,String depart)
	{
		this.unitno=0;
		this.course=new Courselist();
		this.id=id;
		this.name=name;
		this.depart=depart;
				
	}
	

}
