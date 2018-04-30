package test.java.com.revature.maptesting;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import main.java.com.revature.maptesting.myMap;

public class MapTest {
	
	private myMap tester;
	
	@Before
	public void setMap() {
		this.tester = new myMap();
	}
	
	@Test
	public void testAddKey() {
		tester.addKey("key1",1);
		assertEquals(1,tester.retrieveValue("key1"));
	}
	
	@Test
	public void testRemoveKey() {
		tester.addKey("key1",1);
		tester.removeKey("key1");
		assertEquals(null,tester.retrieveKeyIndex("key1"));
	}
	
	@Test
	public void testRetrieveKey() {
		assertEquals(1, tester.retrieveKeyIndex("key1"));
	}

}
