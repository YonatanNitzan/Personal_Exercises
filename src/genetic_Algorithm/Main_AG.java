package genetic_Algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class Main_AG {

	public static void main(String[] args) {
		LinkedList<LinkedList<Integer>> solutions = new LinkedList<LinkedList<Integer>>(); 
		LinkedList<Integer> bestSolution = new LinkedList<Integer>();
		int surface = 30, multi = 0, gen = 1;
		boolean check = true;
		
		for(int i = 0; i<10; i++)
		{
			solutions.add(randomAnswer());
		}
		
		while(check)
		{
			System.out.println("gen " + gen);
			solutions = evolution(solutions, surface);
			for (LinkedList<Integer> list: solutions)
			{

				if (multi == 30)
				{
					check = false;
					bestSolution = list;
				}
			}
		gen++;
		}
		System.out.println(bestSolution);
	}

	
	public static LinkedList<Integer> randomAnswer(){
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for(int i = 0; i<2; i++){
			list.add(new Random().nextInt(101));
		}
		
		return list;
	}
	
	public static LinkedList<LinkedList<Integer>> evolution(LinkedList<LinkedList<Integer>> list, int answer){
		int sum, chance, bestChance = 1000;
		Map<Integer, LinkedList<Integer>> best = new HashMap<Integer, LinkedList<Integer>>();
		LinkedList<LinkedList<Integer>> newList = new LinkedList<LinkedList<Integer>>();
		LinkedList<Integer> temp = new LinkedList<Integer>();
		LinkedList<Integer> temp1 = new LinkedList<Integer>();
		
		for (LinkedList<Integer> l: list){
			sum = 0;
			
			for (int i: l){
				sum += i;
			}
			
			chance = Math.abs(answer-sum);
			best.put(chance, l);
		}
		
		while(best.size() > 1)
		{
			for(int i: best.keySet()){
				bestChance = Math.min(bestChance, i);
			}
			
			temp1 = best.get(bestChance);		
			best.remove(bestChance);
			bestChance = 1000;
			
			for(int i: best.keySet()){
				bestChance = Math.min(bestChance, i);
			}
			
			temp = best.get(bestChance);
			best.remove(bestChance);
			bestChance = 1000;
			
			newList.add(mix(temp, temp1));
		}
		
		while(newList.size() < 10)
		{
			newList.add(randomAnswer());
		}
		
		return newList;
	}
	
	public static LinkedList<Integer> mix(LinkedList<Integer> list1, LinkedList<Integer> list2)
	{
		LinkedList<Integer> newList = new LinkedList<Integer>();
		
		for(int i=0; i<4; i++)
			newList.add(list1.get(i));
		
		for(int i=4; i<8; i++)
			newList.add(list2.get(i));
		
		return newList;
	}
}