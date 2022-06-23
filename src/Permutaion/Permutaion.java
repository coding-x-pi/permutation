package Permutaion;

import java.util.Scanner;

public class Permutaion {

	static int sizenumber=0;
	public static int total =0;
	public static int rows1=0;
	public static char[] indexcount=null;
	public static void main(String[] args) {

		//StringBuffer arr = new StringBuffer();
		// ask for the length of the password
		System.out.println("Enter the length of the password.....");
		Scanner sc = new Scanner(System.in);
		 sizenumber = sc.nextInt();
		// crating a arrays
		System.out.println("Enter the types include in the password ONE BY ONE\n"
				+ "\t1.UpperCase\t2.LowerCase\t3.SpecialCharaters\t4.Digit");
		int control;
		int sizeofArray = 0;
		char[] passArr = null;
		char[] previousArray = null;
		do {
			/*
			 * UpperCase charaters are 26 i.e for 65 to 90 
			 * LoweCase charaters are for 97 to 122 
			 * special charaters are from 32-47,58-64,91-96,123-126
			 * Digit charaters are from 48-57
			 */
			
			switch (sc.nextInt()) {
			case 1:
				previousArray= passArr;
				if (passArr==null) {
					passArr = new char[sizeofArray + 26];
					for (int i = 0; i < passArr.length; i++) {
						passArr[i] = (char) (65 + i);
					}
				}
				sizeofArray = passArr.length;
//				System.out.println(passArr[3]);
				
				break;

			case 2:
				if(passArr!=null)
				previousArray= passArr;
				
				passArr = new char[sizeofArray + 26];
				
				//copying the previous array to the present new size array;
				for (int i = 0; i < previousArray.length; i++) {
					passArr[i]=previousArray[i];
				}
				
				
				int count = 0;
				for (int i = previousArray.length; i < passArr.length; i++,count++) {
					passArr[i] = (char) (97 + count);
				}
				sizeofArray = passArr.length;
				break;
				
			case 3:
				if(passArr!=null)
				previousArray= passArr;
				passArr = new char[sizeofArray + 33];
				int position=0;
				//copying the previous array to the present new size array;
				for (int i = 0; i < previousArray.length; i++) {
					passArr[i]=previousArray[i];
					position=i;
					
				}
				
				
				int count1 = 32,t=32;
				for (int i = previousArray.length; i < passArr.length; i++,count1++) {
					if(count1<48) {
					passArr[i] = (char) ( count1);
					if(count1==47) {
						count1=58;
					}
					}
					if(count1<65&&count1>57) {
						passArr[i] = (char) ( count1);
						if(count1==64) {
							count1=91;
						}
					}
					
					if(count1<97&&count1>90) {
						passArr[i] = (char) ( count1);
						if(count1==96) {
							count1=123;
						}
					}
					if(count1<127&&count1>122) {
						passArr[i] = (char) ( count1);
					}
//				if(32+count1==48)
					}
				
				sizeofArray = passArr.length;

				break;
			case 4:
				if(passArr!=null)
				previousArray= passArr;
				
				passArr = new char[sizeofArray + 10];
				
				//copying the previous array to the present new size array;
				for (int i = 0; i < previousArray.length; i++) {
					passArr[i]=previousArray[i];
				}
				
				
				int count11 = 0;
				for (int i = previousArray.length; i < passArr.length; i++,count11++) {
					passArr[i] = (char) (48 + count11);
				}
				sizeofArray = passArr.length;
				break;
			default:
				break;
			}

			System.out
					.println("Are you sure that you have included the types in the password. Enter 1 for yes 0 for no");
			
			control = sc.nextInt();
			if(control==0) {
				System.out.println("\t1.UpperCase\t2.LowerCase\t3.SpecialCharaters\t4.Digit");
			}
		} while (control == 0);

		System.out.println("Finally the present array contains:");
		for (int i = 0; i < passArr.length; i++) {
			System.out.println(passArr[i]);
		}
		//
//		try {
			replicate(passArr, sizeofArray, sizenumber);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		

	}
	
	
	
	//-----------------------------------------------------------------
	//-----------------------------------------------------------------
	//-----------------------------------------------------------------
	//-----------------------------------------------------------------
	private static void replicate(char[] input,int rows,int replicas) {
		char[][] dataset= new char[rows][replicas]; 
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < replicas; j++) {
				dataset[i][j]=input[i];
			}
		}
		
		int[] replicate =new int[replicas];
		//main part of the permutations
		for (int i = 0; i < replicate.length; i++) {
			replicate[i]=0;
		}
		
		int position=replicate.length-1,col=0;
		
		while(replicate[0]!=rows) {
			
			
			while(replicate[position]!=rows) {
				for(int i=0;i<replicate.length;i++) {
					
				System.out.print(dataset[replicate[i]][i]);
				
				}
				total++;
				System.out.println(" "+total);
				
				replicate[position]++;
			}
			
			
			setup(position-1, replicate, rows);
			
			
			
			//use while or do while or for loop instead of if flow
		/*	
			for (int i = 0; i < replicate.length; i++) {
				if(replicate[i]==rows) {
					replicate[i]=0;
					i--;
					replicate[i]++;
					if(replicate[i]==replicate.length) {
						replicate[i]=0;
						i--;
						replicate[i]++;
					}
					position=replicate.length-1;
				}
			}
			*/
		//the following code is fine for the size is 2	
//			if(replicate[position]==rows) {
//				replicate[position]=0;
//				position--;
//				replicate[position]++;
//				position=replicate.length-1;
//			}else {
//				replicate[position]++;
//			}
			
			

		//the following code is fine for the size is 2	
//			if(replicate[position]==rows) {
//				replicate[position]=0;
//				position--;
//				replicate[position]++;
//				position=replicate.length-1;
//			}else {
//				replicate[position]++;
//			}
			
		}
		
		
		
		
		
	}
	public static void setup(int start,int[] rep, int fullSize) {
		
		rep[rep.length-1]=0;
		
		
		for (int i = start; i >=0; i++) {
			if (rep[i]!=fullSize-1) {
				rep[i]++;rep[i+1]=0;
				
				return;
			}
			if (rep[i]==fullSize-1 && i!=0) {
				setup(i-1,rep,fullSize);return;
			}else {
				
				System.out.println("The permutaion done are: "+total);
				System.exit(0);
			}
		}
	}

}
