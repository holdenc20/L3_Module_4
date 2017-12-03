package threads;

// Below is a completed program that uses brute force to crack a 9-digit password. 
// On average, the program takes about 0.125 seconds to find the password.
// Your goal is to re-write the algorithm using Threads. Try to shorten the time it takes 
// to find the code to be as little as possible.
// Let's see who can crack the code the fastest!

// Pro-tip: Do not include the creation of the threads as part of the time. 

import java.util.Random;

//public class BruteForceCracker {
//	static long code = (long)(new Random().nextDouble() * 1_000_000_000);
//	
//	static long startTime;
//	static long endTime;
//	static float elapsedTime;
//	static int i=0;
//	public static boolean found=false;
//	public static void main(String[] args) {
//		System.out.println("Starting Brute Force Checker");
//		System.out.println(code);
//		startTime = System.currentTimeMillis();
//			dodo();
//		}
//	public static void dodo() {
//		if(found==false) {
//		i=i+1000000;
//		new Thread(()->checkCode(i)).start();
//		if(i>99900000) {found=true;}
//		System.out.println(i);
//		dodo();
//		}
//	}
//	public static void done(){
//		found=true;
//		endTime = System.currentTimeMillis();
//		elapsedTime = (float)(endTime - startTime);
//		elapsedTime /= 1000.f;
//		System.out.println("Total time taken: " + elapsedTime + " seconds");
//	}
//	public static void checkCode(long p){
//		for(long b=p;b<p-1000000+p;b--) {
//			//System.out.println(b);
//		if(b == code){
//			System.out.println("ss");
//			done();
//		}
//		}
//	}
//}

//
public class BruteForceCracker {

static long code = (long)(new Random().nextDouble() * 1_000_000_000);
	static boolean done=false;
	static long startTime;
static long endTime;
	static float elapsedTime;
	
	public static void main(String[] args) {
		System.out.println("Starting Brute Force Checker");
		startTime = System.currentTimeMillis();
		new Thread(()->betweenHigh()).start();
		new Thread(()->betweenLow()).start();
		
		
	}
	public static void betweenHigh() {
		int ctr = 500000000;
		while(!checkCode(ctr++)) {}
		
		done();
		}
	public static void betweenLow() {
		int ctr = 0;
		while(!checkCode(ctr++)) {}
		
		done();
		}
	public static void done() {
		if(done==false) {
		endTime = System.currentTimeMillis();
		elapsedTime = (float)(endTime - startTime);
		elapsedTime /= 1000.f;
		System.out.println("Total time taken: " + elapsedTime + " seconds");
		done=true;
	}
	}
	public static boolean checkCode(long p){
		if(p == code){
			System.out.println(p);
			return true;
}else{
			return false;
		}
	}
}
