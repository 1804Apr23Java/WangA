package test.java.com.revature.maptesting;
import java.util.*;
import org.hamcrest.*;
import org.junit.*;

public class MapTest {
	
	private Map tester;
	
	@Before
	public void setMap() {
		this.tester = new Map();
	}
	
	@Test
	public void testAddKeyValuePair() {
		tester.add("");
		assertEquals(1,tester.size(),"Size should be 1"); //check size of map
	}
	
	@Test
	public void testRemoveKey() {
		//remove key
	}
	
	@Test
	public void testRetrieveKey() {
		//retrieve key
	}

}
