package com.practice.interviewbit.arrays;

import java.util.ArrayList;

public class MinStepsInfiniteGrid {
	
	/**
	 * 
	 * Distance between 2 points in a grid can be calculated by considering both x and y coordinates on same level and then take max of absolute difference between x coordinates and y coordinates
	 */
	
	// X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
	// solution on interview bit
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
    	if(X == null || Y == null || X.size() < 2)
    		return 0;
    	
    	int steps = 0;
    	for(int i = 0; i < X.size(); i++){
    		steps = steps + Math.max(Math.abs(X.get(i)-Y.get(i)), Math.abs(X.get(i+1)-Y.get(i+1)));
    	}
    	
    	return steps;
    }
	
	// X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    // my solution
    public int coverPointsV1(ArrayList<Integer> X, ArrayList<Integer> Y) {
    	
    	if(X == null || Y == null)
    		return 0;
    	
    	if(X.size() < 2 || Y.size() < 2){
    		return 0;
    	}
    	
    	int steps = 0;
    	
    	for(int i = 0; i < X.size(); i++){
    		
    		int x1 = X.get(i);
    		int y1 = Y.get(i);
    		
    		if(i+1 == X.size())
    			return steps;
    		
    		
    		int x2 = X.get(i+1);
    		int y2 = Y.get(i+1);
    		
    		// go up
    		if(x1 > x2){
    			// go left
    			if(y1 > y2){
    				steps = moveUpLeft(x1, x2, y1, y2, steps);
    			}
    			// go right
    			else if(y1 < y2){
    				steps = moveUpRight(x1, x2, y1, y2, steps);
    			}
    			// same column
    			else{
    				steps = steps + (x1-x2);
    			}
    		} 
    		
    		// go down
    		else if(x1 < x2){
    			// go left
    			if(y1 > y2){
    				steps = moveUpRight(x2, x1, y2, y1, steps);
    			}
    			// go right
    			else if(y1 < y2){
    				steps = moveUpLeft(x2, x1, y2, y1, steps);
    			}
    			// same column
    			else{
    				steps = steps + (x2-x1);
    			}
    		} 
    		
    		// same row
    		else{
    			if(y1 > y2){
    				steps = steps + (y1-y2);
    			} else{
    				steps = steps + (y2-y1);
    			}
    		}
    		
    		
    	}
    	
    	
    	
		return steps;
    	
    }
    
    private int moveUpLeft(int x1, int x2, int y1, int y2, int steps){
    	int x = x1;
		int y = y1;
		
		while(x > x2 && y > y2){
			steps++;
			x--;
			y--;
		}
		
		if(x==x2){
			steps = steps + (y-y2);
		} else if(y==y2){
			steps = steps + (x-x2);
		}
		
		return steps;
    }
    
    private int moveUpRight(int x1, int x2, int y1, int y2, int steps){
    	int x = x1;
		int y = y1;
		
		while(x > x2 && y < y2){
			steps++;
			x--;
			y++;
		}
		
		if(x==x2){
			steps = steps + (y2-y);
		} else if(y==y2){
			steps = steps + (x-x2);
		}
		
		return steps;
    }

}
