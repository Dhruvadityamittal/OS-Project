import java.util.*;    //libraries for utilities like Scanner and Runnable and Threads
import java.io.*;      // libraries for input and output like FileOutputStream 

class choices{

	int id;
	String[] list = new String[20];
	
	void mylist(){   // list of processes that could be executed ..
		list[0]="google-chrome";   
		list[1]="firefox";
		list[2]="gedit";
		list[3]="jupyter-notebook";
		list[4]="vi";
		System.out.println("\t\t\t\t\tList of Processes Available for Execution are :\n\n");

		System.out.println("\t\t\t\t\tProcess ID\tProcess Name");

		for(int i=0;i<=4;i++){
			System.out.println( "\t\t\t\t\t  "+ (i+1)+"       \t   " +list[i]);
		}
	}
	String list(int id){      //this process will return the String on which Id is called ..
		//Scanner input = new Scanner(System.in);
		//System.out.print("Enter the ID of the process you want to execute in the follwing table :");
		//int ProcessID =input.nextInt();

		list[0]="google-chrome";
		list[1]="firefox";
		list[2]="gedit";
		list[3]="jupyter-notebook";
		list[4]="vi";
				
		String ProcessName="firefox";   //default process name

		switch(id){

			case 1:ProcessName=list[0];break;
			case 2:ProcessName=list[1];break;
			case 3:ProcessName=list[2];break;
			case 4:ProcessName=list[3];break;
			case 5:ProcessName=list[4];break;
		}
	return ProcessName;
	}
}		

class priority_non{   // this is class for priority scheduling (Non Primitive)

	int temp=0;

	Scanner input= new Scanner(System.in); // Scanning the id of the process ..
	int processes;
	
	
	priority_non(){
		try{
		        System.out.print("\n\n\t\t\t\t\tEnter the number of Processes :");
			processes=input.nextInt();
			int[][] array = new int[5][processes+1]; //declaring a 2D array in which we have differt features and no of processes
			int l=array[1].length;
		
		

		for(int i=1;i<=l-1;i++){
			System.out.print("\t\t\t\t\tEnter the ID of process "+i+" :");
			array[1][i]=input.nextInt();

			System.out.print("\t\t\t\t\tEnter the Priority of the process"+i+" :");
			array[2][i]=input.nextInt();

			System.out.print("\t\t\t\t\tEnter the Burst Time of the Process"+i+" :");
			array[3][i]=input.nextInt();

			//System.out.print("Enter the Arrival Time of the Process"+i+" :");
			//array[4][i]=input.nextInt();
			System.out.println("\n\n");

		}
		for(int i=1;i<=l-1;i++){
			for(int j=1;j<=l-1;j++){
				if(array[2][i]>array[2][j]){  // doing 2D swapping in order to get accurate scheduling times

					temp=array[1][i];
					array[1][i]=array[1][j];
					array[1][j]=temp;

					temp=array[2][i];
					array[2][i]=array[2][j];
					array[2][j]=temp;

					temp=array[3][i];
					array[3][i]=array[3][j];
					array[3][j]=temp;

					/*temp=array[4][i];
					array[4][i]=array[4][j];
					array[4][j]=temp;*/
				}
			}
		}

		System.out.println("\t\t\t\t\tID     Priority     Burst Time   ");  //Printing the results

		for(int i=1;i<=processes;i++){
			System.out.println("\t\t\t\t\t "+array[1][i] +"        "+array[2][i]+"              "+ array[3][i]+"        ");
		}
		String ProcessName;

		choices obj1= new choices();
				
		for(int i=1;i<=processes;i++){
			ProcessName=obj1.list(array[1][i]);
			System.out.println("\t\t\t\t\tExecuting "+ProcessName +" for "+array[3][i]);
			Method obj2= new Method(ProcessName,array[3][i]);	
			obj2.run();
			obj2.kill();					
		}
	}
		catch(Exception e){
			System.out.println("\t\t\t\t\tException handled at inputting the number of processes please try again later");
		}
	}

}		
class sjf{ // this is class for Shortest Job First scheduling (Non Primitive)
	int temp=0;
	Scanner input= new Scanner(System.in);
	int processes;
	
	
	sjf(){
		System.out.print("\t\t\t\t\tEnter the number of Processes :");

		processes=input.nextInt();
		int[][] array = new int[3][processes+1];
		int l=array[1].length;

		System.out.println(l);


		for(int i=1;i<=l-1;i++){
			System.out.print("\t\t\t\t\tEnter the ID of process "+i+" :");
			array[1][i]=input.nextInt();
			System.out.print("\t\t\t\t\tEnter the Burst Time of the Process"+i+" :");
			array[2][i]=input.nextInt();
			System.out.println("\n\n");

		}
		for(int i=1;i<=l-1;i++){
			for(int j=1;j<=l-1;j++){
				if(array[2][i]>array[2][j]){

					temp=array[1][i];
					array[1][i]=array[1][j];
					array[1][j]=temp;

					temp=array[2][i];
					array[2][i]=array[2][j];
					array[2][j]=temp;
					System.out.println("\n\n");
				}
			}
		}

		System.out.println("\t\t\t\t\tID   Burst Time  ");
		for(int i=1;i<=processes;i++){
			System.out.println("\t\t\t\t\t "+array[1][i] +"        "+array[2][i]);
		}
		String ProcessName;
		choices obj1= new choices();
				
		for(int i=1;i<=processes;i++){
			ProcessName=obj1.list(array[1][i]);
			System.out.println("\t\t\t\t\tExecuting "+ProcessName +" for "+array[2][i]+" seconds");
			Method obj2= new Method(ProcessName,array[2][i]);	
			obj2.run();
			obj2.kill();						
		}
			
	}
}		
		
class fcfs{// this is class for First Come First Serve scheduling (Non Primitive)
	int temp=0;
	Scanner input= new Scanner(System.in);
	int processes;
	
	
	fcfs(){
		System.out.print("\t\tEnter the number of Processes :");

		processes=input.nextInt();
		int[][] array = new int[5][processes+1];
		int l=array[1].length;

		System.out.println(l);


		for(int i=1;i<=l-1;i++){
			System.out.print("\t\t\t\t\tEnter the ID of process "+i+" :");
			array[1][i]=input.nextInt();
			System.out.print("\t\t\t\t\tEnter the Burst Time of the Process"+i+" :");
			array[2][i]=input.nextInt();
			System.out.print("\t\t\t\t\tEnter the Arrival Time of the Process"+i+" :");
			array[3][i]=input.nextInt();
			System.out.println("\n\n");

		}
		for(int i=1;i<=l-1;i++){
			for(int j=1;j<=l-1;j++){
				if(array[3][i]<array[3][j]){

					temp=array[1][i];
					array[1][i]=array[1][j];
					array[1][j]=temp;

					temp=array[2][i];
					array[2][i]=array[2][j];
					array[2][j]=temp;

					temp=array[3][i];
					array[3][i]=array[3][j];
					array[3][j]=temp;

				}
			}
		}

		System.out.println("\t\tID     Priority       Arrival Time");
		for(int i=1;i<=processes;i++){
			System.out.println("\t\t\t\t\t "+array[1][i] +"        "+array[2][i]+"              "+ array[3][i]);
		}
		String ProcessName;
		choices obj1= new choices();
				
		for(int i=1;i<=processes;i++){
			ProcessName=obj1.list(array[1][i]);
			System.out.println("\t\t\t\t\tExecuting "+ProcessName +" for "+array[3][i]+" seconds");
			Method obj2= new Method(ProcessName,array[2][i]);	
			obj2.run();
			obj2.kill();						
		}
			
	}
}
	
class Method implements Runnable{  // this is the key method that is called by all the above classes to perform operations on threads
	FileOutputStream  f1; // Making a fileoutput stream object for our log file ..

	String str;		
	String ProcessName;
	Runtime r= Runtime.getRuntime();
	Process p=null;
	int time;
	
	Method(String ProcessName,int time){
		try{
			f1 = new FileOutputStream("log.txt");
		}
		catch(Exception e){   //catching the required Exception
			System.out.println("\t\t\t\t\tErrror in File OutPut Stream");
		}
		Thread thread=new Thread();
		this.ProcessName= ProcessName;
		this.time=time;
	}
	public void run(){ //method for running the process for given time .. 
		try{
			str ="User Started the Process :"+ProcessName+"\n\n";
		        byte[] b=str.getBytes();
			f1.write(b);
			p=r.exec(ProcessName);
			//Thread.sleep(time*1000);    
			int ptime=time*1000;
			time =time*1000;
			System.out.println("");
			for(ptime=0;ptime<=time/2;ptime=ptime+0){
				System.out.print("-----");
				Thread.sleep(ptime);
				ptime=ptime+1000;
				
			}
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|  "+ ProcessName);
			System.out.println("|");
			System.out.println("|");

//			System.out.println(P);
			System.out.println("");
			for(ptime=0;ptime<=time/2;ptime=ptime+0){
				
				Thread.sleep(ptime);
				System.out.print("-----");
				ptime=ptime+1000;
			}
			System.out.println("\n\n");
//
		}
		
		catch(Exception e){
			System.out.println("\t\t\t\t\tError in Method");
		}
	}
	void kill(){            //method for killing the processes after they are complete ..
		try{
			String str ="User Killed the Process :"+ProcessName+"\n\n";
			byte b[]=str.getBytes();
			f1.write(b);
			p.destroy();
		}
			
		catch(Exception e){
			System.out.println("\t\t\t\t\tError in Kill");
		}
	}
}

public class proj1{         // main java file 
	public static void main(String args[]){
		try{
			FileOutputStream  f1;

			int choice;
			Scanner input = new Scanner(System.in);
			System.out.println("\t\t\t\t\tS.No\tScheduling Type");
			System.out.println("\t\t\t\t\t 1  \tPriority Scheduling");	
			System.out.println("\t\t\t\t\t 2  \tShortest Job Scheduling");	
			System.out.println("\t\t\t\t\t 3  \tFirst Come First Serve Scheduling");	

			System.out.print("\n\n\t\t\t\t\tEnter the S.No of the Type of Scheduling you want to Execute :");

			choice = input.nextInt();
			System.out.println("\n\n");
			choices obj4 = new choices();
			obj4.mylist();

			if(choice>3 || choice<1){
				System.out.println("\t\t\t\t\tPlease enter a valid input!!.Please run the code again\n");
			}
			else{
				switch(choice){
				case 1: priority_non obj1 = new priority_non();break;
				case 2: sjf obj2=new sjf();break;
				case 3: fcfs obj3=new fcfs();break;
				}		
			}
		}
		catch(Exception e){
			System.out.println("\t\t\t\t\tError in input :Please run the code again ");
		}
	}
}
