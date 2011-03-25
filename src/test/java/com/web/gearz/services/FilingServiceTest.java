package com.web.gearz.services;

import java.net.UnknownHostException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.MongoException;
/**
 * These tests need a local instance of your mongo running..
 * @author sajit
 *
 */
public class FilingServiceTest {

	
	FilingService filingService;
	@Test
	public void shouldConnectToLocal() {
		boolean passFlag = false;
		try {
			filingService.storeContent(0, "samplediv", "hi");
			passFlag = true;
		} catch (MongoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(passFlag);
	}
	
	
	@Test
	public void shouldAddNewObject() throws MongoException, UnknownHostException{
		Assert.assertTrue(FilingService.getCollection().getCount()==0L);
		
		filingService.storeContent(0, "div", "<h1>bBill</h1>");
		
		Assert.assertFalse(FilingService.getCollection().getCount()==0L);
	}
	
	@Test
	public void shouldUpdateExistingObject() throws MongoException, UnknownHostException{
		Assert.assertTrue(FilingService.getCollection().getCount()==0L);
		
		filingService.storeContent(0, "div", "<h1>bBill</h1>");
		Assert.assertEquals(1L, FilingService.getCollection().getCount());
		
		filingService.storeContent(0, "div", "<h1><a>Joe</a><h1>");
		Assert.assertEquals(1L, FilingService.getCollection().getCount());
		
	}
	
	@Test
	public void shouldAddObject2() throws MongoException, UnknownHostException{
		Assert.assertTrue(FilingService.getCollection().getCount()==0L);
		
		filingService.storeContent(0, "div", "<h1>bBill</h1>");
		Assert.assertEquals(1L, FilingService.getCollection().getCount());
		
		filingService.storeContent(0, "div1", "<h1><a>Joe</a><h1>");
		Assert.assertEquals(2L, FilingService.getCollection().getCount());
		
	}
	
	@Test
	public void shouldAddObject3() throws MongoException, UnknownHostException{
		Assert.assertTrue(FilingService.getCollection().getCount()==0L);
		
		filingService.storeContent(0, "div", "<h1>bBill</h1>");
		Assert.assertEquals(1L, FilingService.getCollection().getCount());
		
		filingService.storeContent(1, "div", "<h1><a>Joe</a><h1>");
		Assert.assertEquals(2L, FilingService.getCollection().getCount());
		
	}
	@Test
	public void shouldAddObject4() throws MongoException, UnknownHostException{
		Assert.assertTrue(FilingService.getCollection().getCount()==0L);
		
		filingService.storeContent(0, "div", "<h1>bBill</h1>");
		Assert.assertEquals(1L, FilingService.getCollection().getCount());
		
		filingService.storeContent(1, "div1", "<h1><a>Joe</a><h1>");
		Assert.assertEquals(2L, FilingService.getCollection().getCount());
		
	}
	
	@Test
	public void shouldRetrieveDefaultText() throws MongoException, UnknownHostException{
		
		Assert.assertEquals("Default Text",filingService.getContent(0, "diuv"));
	}
	
	@Test
	public void shouldRetrieveStoredContent() throws MongoException, UnknownHostException{
		String content = "<h1>bBill</h1>";
		filingService.storeContent(0, "div", "<h1>bBill</h1>");
		
		String retrievedContent = filingService.getContent(0, "div");
		
		Assert.assertEquals(content, retrievedContent);
	}
	@After
	public void tearDown() throws MongoException, UnknownHostException{
		FilingService.getCollection().drop();
	}
	@Before
	public void setup(){
		filingService = new FilingService();
		FilingService.setHost("127.0.0.1");
		FilingService.setDb("testDB");
	}
}
