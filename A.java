class B
{
	abstract void display();
	void display1()
	{
		System.out.println("display1");
	}
}
class A extends B
{
	void display()
	{
		System.out.println("display");
	}
	public static void main(String[] args) {
		A a=new A();
		a.display();
		a.display1();
	}
}