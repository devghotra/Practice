package com.practice.sort;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ShuffleArray {
	public static void shuffle(int[] ar) {
		Random rnd = ThreadLocalRandom.current();
		for (int i = ar.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			int a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		}
		System.out.println("Shuffled: ");
		for(int i : ar){
			System.out.print(i+" ");
		}
		System.out.println("");
	}

}
