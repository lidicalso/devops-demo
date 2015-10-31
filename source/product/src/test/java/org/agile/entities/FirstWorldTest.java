package org.agile.entities;

import junit.framework.TestCase;

public class FirstWorldTest extends TestCase {
	
	private FirstWorld world;
	
	public void testAging(){
		world = new FirstWorld("NewTestWorld");
		assertEquals((Long)0l, world.getWorldAge());
		world.age();
		assertEquals((Long)1l, world.getWorldAge());
	}

}
