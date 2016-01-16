import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class Calculator
	{
	Frame f;
	//htututu
	TextField tf;
	String input[]={"1","4","7",".","2","5","8","0","3","6","9","=","+","-","*","/","C","%",")","(","sin","cos","tan"};
	Button b[]=new Button[17];
	Calculator(String s)
		{
		f=new JFrame(s);
		f.setSize(380,300);
		f.setVisible(true);
		int p=60;
		int q=110;
		for (int i=0;i<17;i++)
			{
			b[i]=new Button(input[i]);
			b[i].setBounds(p,q,30,30);
			q=q+40;
			if (q>230)
				{
				q=110;
				p=p+50;
				
				}
			f.add(b[i]);
			f.setLayout(null);
			b[i].addActionListener(new PressButton(this));
			}
		
		tf=new TextField();
		tf.setBounds(30,50,240,40);
		f.add(tf);
		f.setBackground(Color.LIGHT_GRAY);
				
		f.addWindowListener(new CloseWindow());
		}

	public static void main(String... args)
		{
		new Calculator("Calculator");
		}
	}
	
class PressButton implements ActionListener
	{
	//String input[]={"1","4","7",".","2","5","8","0","3","6","9","=","+","-","*","/"};
	Calculator c;
	static String s1[]=new String [120];
	static String oper[]=new String[120];
	static double s2[]=new double [120];
	static int p=1;
	static int count1=0;
	
	PressButton(Calculator c)
		{
		this.c=c;
		for(int i=0;i<120;i++)
			{
			s1[i]="";
			oper[i]="";
			}
		s1[0]="+";
		
		}
	public static String removeAt(String s,int x)
		{
		String sa=s.substring(0,x);
		String sb=s.substring(x+1);
		String sc=sa+sb;
		return sc;
		}
	static int count;
	public void actionPerformed(ActionEvent e)
		{
		
		if (e.getSource()==c.b[0])
			{
			s1[p]=s1[p]+"1";
			c.tf.setText(s1[p]);
			//System.out.println("hello");
			}
		if (e.getSource()==c.b[1])
			{
			s1[p]=s1[p]+"4";
			c.tf.setText(s1[p]);
			
			}
		if (e.getSource()==c.b[2])
			{
			s1[p]=s1[p]+"7";
			c.tf.setText(s1[p]);
			
			}
		if (e.getSource()==c.b[3])
			{
			for(int i=0;i<s1[p].length();i++)
				{
				if (s1[p].charAt(i)=='.')
					{
					s1[p]=removeAt(s1[p],i);
					}
				}
			s1[p]=s1[p]+".";
			c.tf.setText(s1[p]);
			}
		if (e.getSource()==c.b[4])
			{
			s1[p]=s1[p]+"2";
			c.tf.setText(s1[p]);
			
			}
		if (e.getSource()==c.b[5])
			{
			s1[p]=s1[p]+"5";
			c.tf.setText(s1[p]);
			
			}
		if (e.getSource()==c.b[6])
			{
			s1[p]=s1[p]+"8";
			c.tf.setText(s1[p]);
			
			}
		if (e.getSource()==c.b[7])
			{
			s1[p]=s1[p]+"0";
			c.tf.setText(s1[p]);
			
			}
		if (e.getSource()==c.b[8])
			{
			s1[p]=s1[p]+"3";
			c.tf.setText(s1[p]);
			
			}
		if (e.getSource()==c.b[9])
			{
			s1[p]=s1[p]+"6";
			c.tf.setText(s1[p]);
			
			}
		if (e.getSource()==c.b[10])
			{
			s1[p]=s1[p]+"9";
			c.tf.setText(s1[p]);
			
			}
		
		if (e.getSource()==c.b[12])
			{
			if(s1[p-1].charAt(s1[p-1].length()-1)=='+')
				{
				//do nothing
				}
			if(s1[p-1].charAt(s1[p-1].length()-1)=='-')
				{
				s1[p-1]=s1[p-1].replace('-','+');
				}
			if(s1[p-1].charAt(s1[p-1].length()-1)=='*')
				{
				s1[p-1]=s1[p-1].replace('*','+');
				}
			if (s1[p-1].charAt(s1[p-1].length()-1)=='/')
				{
				s1[p-1]=s1[p-1].replace('/','+');
				}
			else
				{
				s1[p]=s1[p]+"+";
				c.tf.setText(s1[p]);
				p++;
				}
		
			}
		if (e.getSource()==c.b[13])
			{
			if (s1[p-1].charAt(s1[p-1].length()-1)=='+')
				{
				s1[p-1]=s1[p-1].replace('+','-');
				}
			if(s1[p-1].charAt(s1[p-1].length()-1)=='-')
				{
				//do nothing
				}
			if(s1[p-1].charAt(s1[p-1].length()-1)=='*')
				{
				s1[p-1]=s1[p-1].replace('*','-');
				}
			if(s1[p-1].charAt(s1[p-1].length()-1)=='/')
				{
				s1[p-1]=s1[p-1].replace('/','-');
				}
			else
				{
				s1[p]=s1[p]+"-";
				c.tf.setText(s1[p]);
				p++;
				}
			
			}
		if (e.getSource()==c.b[14])
			{
			if(s1[p-1].charAt(s1[p-1].length()-1)=='+')
				{
				s1[p-1]=s1[p-1].replace('+','*');
				}
			if(s1[p-1].charAt(s1[p-1].length()-1)=='-')
				{
				s1[p-1]=s1[p-1].replace('-','*');
				}
			if(s1[p-1].charAt(s1[p-1].length()-1)=='*')
				{
				//do nothing
				}
			if(s1[p-1].charAt(s1[p-1].length()-1)=='/')
				{
				s1[p-1]=s1[p-1].replace('/','*');
				}
			else
				{
				s1[p]=s1[p]+"*";
				c.tf.setText(s1[p]);
				p++;
				}
			
			}
		if (e.getSource()==c.b[15])
			{
			if(s1[p-1].charAt(s1[p-1].length()-1)=='+')
				{
				s1[p-1]=s1[p-1].replace('+','/');
				}
			if(s1[p-1].charAt(s1[p-1].length()-1)=='-')
				{
				s1[p-1]=s1[p-1].replace('-','/');
				}
			if(s1[p-1].charAt(s1[p-1].length()-1)=='*')
				{
				s1[p-1]=s1[p-1].replace('*','/');
				}
			if(s1[p-1].charAt(s1[p-1].length()-1)=='/')
				{
				//do nothing
				}
			if(s1[p-1].charAt(s1[p-1].length()-1)=='h')
				{
				//do nothing
				}
			else
				{
				s1[p]=s1[p]+"/";
				c.tf.setText(s1[p]);
				p++;
				}
			
			}
		
			
		if (e.getSource()==c.b[11])
			{
			s1[p]=s1[p]+"=";
			for(int i=1;i<s1.length;i++)
				{
				if (s1[i]!="")
					{
					if(s1[i].charAt(s1[i].length()-1)=='+'||s1[i].charAt(s1[i].length()-1)=='-'||s1[i].charAt(s1[i].length()-1)=='*'||s1[i].charAt(s1[i].length()-1)=='/'||s1[i].charAt(s1[i].length()-1)=='=')//||s1[i].charAt(s1[i].length()-1)==')')
						{
						
						
						oper[i]=s1[i].substring((s1[i].length())-1);
						s1[i]=s1[i].substring(0,(s1[i].length())-1);
						s2[i]=Double.parseDouble(s1[i]);
						}
					
					}
				
				}
			double temp=s2[1];
			
			for(int i=2;i<s1.length;i++)
				{
				/*if(s1[i-1].charAt((s1[i-1].length())-1)=='=')
					{
					break;
					}*/
				if (s1[i]!="")
					{
					if (oper[i-1].charAt(0)=='+')
						{
						temp=temp+s2[i];
						}
					if (oper[i-1].charAt(0)=='-')
						{
						temp=temp-s2[i];
						}
					if (oper[i-1].charAt(0)=='*')
						{
						temp=temp*s2[i];
						}
					try
						{
						if (oper[i-1].charAt(0)=='/')
							{
							temp=temp/s2[i];
							}
						}
					catch(ArithmeticException h)
						{
						c.tf.setText("divided by 0");
						
						}
					
					}
				
				}
			String temp1=String.valueOf(temp);
			c.tf.setText(temp1);
			
			p++;
			s1[p]=c.tf.getText();
			
			}
		if (e.getSource()==c.b[16])
			{
			c.tf.setText("");
			for(int i=0;i<120;i++)
				{
				s1[i]="";
				oper[i]="";
				s2[i]=0;
				}
			p=1;
			s1[0]="+";
			}
		/*if (e.getSource()==c.b[18])
			{
			s1[p]=s1[p]+")";
			c.tf.setText(s1[p]);
			}
		if (e.getSource()==c.b[19])
			{
			s1[p]=s1[p]+"(";
			c.tf.setText(s1[p]);
			}
		if (e.getSource()==c.b[20])
			{
			s1[p]=s1[p]+"sin(";
			c.tf.setText(s1[p]);
			}*/
		}
		
		
	}
	
class CloseWindow extends WindowAdapter
	{
	public void windowClosing(WindowEvent e)
			{
			System.exit(0);
			}
	}	