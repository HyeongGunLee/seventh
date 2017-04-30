package test.shared;

import static org.junit.Assert.*;

import org.junit.Test;

import seventh.shared.BroadcastListener;

public class BroadcastListenerTest {

	/*
	 * purpose : test BroadcastListener function in Broadcaster class.
	 * input : mtu:20, groupAddress:192.168.25.53, port:80
	 * expected output : X, cause the function is only made for creation.
	 */
	@Test
	public void testBroadcastListener() {
		BroadcastListener test = new BroadcastListener(20,"192.168.25.53",80);
	}

	/*
	 * purpose : test AddOnMessageReceivedListener function in Broadcaster class.
	 * input : mtu:20, groupAddress:192.168.25.53, port:80, null for OnMessageREceivedListener
	 * expected output : X, cause the function is only made for creation.
	 */
	@Test
	public void testAddOnMessageReceivedListener() {
		BroadcastListener test = new BroadcastListener(20,"192.168.25.53",80);
		test.addOnMessageReceivedListener(null);
	}
	/*
	 * purpose : test start function in Broadcaster class.
	 * input : mtu:20, groupAddress:192.168.25.53, port:80.
	 * expected output : X, cause the function is only made for creation.
	 */
	@Test
	public void testStart() {
		BroadcastListener test = new BroadcastListener(20,"192.168.25.53",80);
		try {
			test.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * purpose : test close function in Broadcaster class.
	 * input : mtu:20, groupAddress:192.168.25.53, port:80.
	 * expected output : X, cause the function is only made for creation.
	 */
	@Test
	public void testClose() {
		BroadcastListener test = new BroadcastListener(20,"192.168.25.53",80);
		try {
			test.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
