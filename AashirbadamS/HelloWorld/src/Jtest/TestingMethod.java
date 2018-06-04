package Jtest;

import org.junit.Test;

import Jtest.Player;
import static org.junit.Assert.*;


public class TestingMethod {
	
	 private static final Player player = new Player("Mike");
	
	 @Test
	    public void testEmptyBeforeaddingplayer() {
		 
	     
	    }
	 
	 @Test
	 public void testAddQueueTailsa()
	    {
	        Integer ExpectedIndex = 0;	        
	        assertEquals(ExpectedIndex, player.playerName);
	    }
	 
	 @Test
	 public void testremovefromqueuefromhead() {
    	
	 }


 

}