import java.util.*;
public class student_Grade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the number of subjects:");
		int sub=sc.nextInt();
		
		//variable declaration
		String[] subs=new String[sub];
		int[] marks=new int[sub];
		int total=0;
		
		//taking the marks of sub and marks
		System.out.println("Enter the name of the subject plus it's marks:\n");
		for(int i=0;i<sub;i++) {
			
			System.out.println("Subject number:"+(1+i));
			
			for(int j=i;j==i;j++) {
				System.out.print("Subject name:");
				subs[i]=sc.next();
			}
			
			for(int k=i;k==i;k++) {
				System.out.print("Subject marks:");
				marks[i]=sc.nextInt();
				total+=marks[i];
			}System.out.println();
		}
		int avg=total/sub;
		
		//Grade Calculation.......
		if(avg>=35) {
			System.out.println("Result is Pass with percentage of : "+avg);
			if(avg>=90&&avg<=100) {
				System.out.println("Grade O");
			}else if(avg>=80&&avg<=89) {
				System.out.println("Grade A");
			}else if(avg>=70&&avg<=79) {
				System.out.println("Grade B");
			}else if(avg>=60&&avg<=69) {
				System.out.println("Grade C");
			}else if(avg>=50&&avg<=59) {
				System.out.println("Grade D");
			}else if(avg<=49) {
				System.out.println("Grade AB");
			}
		} else {
			System.out.println("Result is Fail with percentage of : "+avg);
		}
		
		sc.close();
	}

}
