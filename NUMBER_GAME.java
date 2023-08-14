import java.util.*;
public class NUMBER_GAME {
	public static void main(String[] args) {
		Random rd=new Random();
		Scanner sc=new Scanner(System.in);
		int num=rd.nextInt(100);
		int maxAttempts=10;
		
		while(true) {
			for(int i=1;i<=maxAttempts;i++) {
				
				System.out.println("enter your guess number in between 0 to 100:");
				int guess=sc.nextInt(); 
				
				if(guess>num) {
					 System.out.println("too high");
				 }
				 else if(guess<num) {
					 System.out.println("too low");
				 }
				 else if(guess==num) {
					 System.out.println("currect guess..");
					 System.out.println("your score is:"+(100-(i*10)));
					 break;
				 }
				if(i==maxAttempts) {
					System.out.println("Sorry, you've reached the maximum number of attempts. The number was " + num);
				}
			}
			System.out.println("do you want to play again? (yes/no):");
			String ans=sc.next().toLowerCase();
			if(ans.equals("no")){
				break;
			}
		}
	}
 
}
