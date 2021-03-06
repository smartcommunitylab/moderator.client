/*******************************************************************************
 * Copyright 2012-2013 Trento RISE
 * 
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 * 
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 ******************************************************************************/
package eu.trentorise.smartcampuse.moderatorservice;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import eu.trentorise.smartcampus.moderatorservice.model.ContentToModeratorService;
import eu.trentorise.smartcampus.moderatorservice.model.State;
import eu.trentorise.smartcampus.moderatoservice.ModeratorService;
import eu.trentorise.smartcampus.moderatoservice.exception.ModeratorServiceException;

public class TestModeratorClient {

	private ModeratorService moderatorConnector;


	@Before
	public void init() {
		moderatorConnector = new ModeratorService(Constants.MODERATOR_SRV_URL);

	}

	@Test
	public void testModerator() throws Exception {
		Object result2,result1;
		
		long testtime=System.currentTimeMillis();
		ContentToModeratorService testContent=new ContentToModeratorService(Constants.TEST_APP_ID, "1", "provatest", "1");
		
		result2 = moderatorConnector.addContentToManualFilterByApp(Constants.CLIENT_AUTH_TOKEN, Constants.TEST_APP_ID,testContent);
		Assert.assertNotNull(result2);
		System.out.println(result2);
		
		result1 = moderatorConnector.getContentByObjectId(Constants.CLIENT_AUTH_TOKEN, Constants.TEST_APP_ID,String.valueOf(testContent.getObjectId()));
		Assert.assertNotNull(result1);
		System.out.println(((List<ContentToModeratorService>)result1).size());
		
		result2 = moderatorConnector.addContentNoteByApp(Constants.CLIENT_AUTH_TOKEN, Constants.TEST_APP_ID,((List<ContentToModeratorService>)result1).get(0).get_id(),"prova note");
		Assert.assertNotNull(result2);
		System.out.println(result2);
		
		result2 = moderatorConnector.changeStatoManualFilterByApp(Constants.CLIENT_AUTH_TOKEN, Constants.TEST_APP_ID,((List<ContentToModeratorService>)result1).get(0).get_id(),State.APPROVED);
		Assert.assertNotNull(result2);
		System.out.println(result2);
		
		result2 = moderatorConnector.getAllManualContent(Constants.CLIENT_AUTH_TOKEN, Constants.TEST_APP_ID);
		Assert.assertNotNull(result2);
		System.out.println(((List<ContentToModeratorService>)result2).size());	
		
		result2 = moderatorConnector.getAllKeywordFilterContent(Constants.CLIENT_AUTH_TOKEN, Constants.TEST_APP_ID);
		Assert.assertNotNull(result2);
		System.out.println(((List<ContentToModeratorService>)result2).size());	
		
		result2 = moderatorConnector.getAllManualContentByData(Constants.CLIENT_AUTH_TOKEN, Constants.TEST_APP_ID,testtime);
		Assert.assertNotNull(result2);
		System.out.println(((List<ContentToModeratorService>)result2).size());	
		
		result2 = moderatorConnector.getContentByDateWindow(Constants.CLIENT_AUTH_TOKEN, Constants.TEST_APP_ID,testtime,testtime+900000);
		Assert.assertNotNull(result2);
		System.out.println(((List<ContentToModeratorService>)result2).size());	
		
		
		
		
		moderatorConnector.deleteByObjectId(Constants.CLIENT_AUTH_TOKEN, Constants.TEST_APP_ID,String.valueOf(testContent.getObjectId()));
	
		
	}
	
	@Test
	public void test() throws SecurityException, ModeratorServiceException {
		List<ContentToModeratorService> contentByDateWindow = moderatorConnector.getContentByDateWindow(Constants.CLIENT_AUTH_TOKEN, "ifame", 0L, System.currentTimeMillis());
		Assert.assertNotNull(contentByDateWindow);
	}
}
