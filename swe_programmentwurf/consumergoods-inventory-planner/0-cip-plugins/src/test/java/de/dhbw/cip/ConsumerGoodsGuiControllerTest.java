package de.dhbw.cip;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Optional;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

import de.dhbw.cip.domain.ConsumerGoodsRepository;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

public class ConsumerGoodsGuiControllerTest {

	@Test
	public void storeNewConsumerGoodTest() {
	    //Arange
		String foodDescriptionParameter = "description=Tomatoes";
		String bestBeforeDateDayParameter = "bestbeforedateday=02";
		String bestBeforeDateMonthParameter = "bestbeforedatemonth=04";
		String bestBeforeDateYearParameter = "bestbeforedateyear=2022";
		String quantityValueParameter = "quantityvalue=1";
		String quantityParameter = "quantity=Stk.";
		String storageParameter = "storage=Fridge";
		
	    HttpUriRequest request = new HttpPost( "http://localhost:8083/api/consumergoods/add?" + foodDescriptionParameter + "&"
	    		+ bestBeforeDateDayParameter + "&" + bestBeforeDateMonthParameter + "&" + bestBeforeDateYearParameter 
	    		+ "&" + quantityValueParameter + "&" + quantityParameter + "&" + storageParameter);

	    //Act
	    Optional<CloseableHttpResponse> httpResponse = Optional.empty();
		try {
			httpResponse = Optional.of(HttpClientBuilder.create().build().execute( request ));
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    //Assert
		if(!httpResponse.isEmpty()) assertEquals(HttpStatus.OK.value(), httpResponse.get().getStatusLine().getStatusCode());
	}
	
	@Test
	public void checkBadRequestWhileStoreNewConsumerGood() {
	    //Arange
		String foodDescriptionParameter = "description=Tomatoes";
		String bestBeforeDateDayParameter = "bestbeforedateday=02";
		String bestBeforeDateMonthParameter = "bestbeforedatemonth=04";
		String bestBeforeDateYearParameter = "bestbeforedateyear=2022";
		String quantityValueParameter = "quantityvalue=1";
		String quantityParameter = "quantity=";
		String storageParameter = "storage=Fridge";
		
	    HttpUriRequest request = new HttpPost( "http://localhost:8083/api/consumergoods/add?" + foodDescriptionParameter + "&"
	    		+ bestBeforeDateDayParameter + "&" + bestBeforeDateMonthParameter + "&" + bestBeforeDateYearParameter 
	    		+ "&" + quantityValueParameter + "&" + quantityParameter + "&" + storageParameter);

	    //Act
	    Optional<CloseableHttpResponse> httpResponse = Optional.empty();
		try {
			httpResponse = Optional.of(HttpClientBuilder.create().build().execute( request ));
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    //Assert
		if(!httpResponse.isEmpty()) assertEquals(HttpStatus.BAD_REQUEST.value(), httpResponse.get().getStatusLine().getStatusCode());
	}
	
	@Test
	public void checkBadRequestWhileUpdateNewConsumerGood() {
	    //Arange
		String idParameter = "id=";
		String foodDescriptionParameter = "description=Tomatoes";
		String bestBeforeDateDayParameter = "bestbeforedateday=02";
		String bestBeforeDateMonthParameter = "bestbeforedatemonth=04";
		String bestBeforeDateYearParameter = "bestbeforedateyear=2022";
		String quantityValueParameter = "quantityvalue=1";
		String quantityParameter = "quantity=Stk.";
		String storageParameter = "storage=Fridge";
		
	    HttpUriRequest request = new HttpPut( "http://localhost:8083/api/consumergoods/update?" + idParameter + "&" + foodDescriptionParameter + "&"
	    		+ bestBeforeDateDayParameter + "&" + bestBeforeDateMonthParameter + "&" + bestBeforeDateYearParameter 
	    		+ "&" + quantityValueParameter + "&" + quantityParameter + "&" + storageParameter);

	    //Act
	    Optional<CloseableHttpResponse> httpResponse = Optional.empty();
		try {
			httpResponse = Optional.of(HttpClientBuilder.create().build().execute( request ));
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    //Assert
		if(!httpResponse.isEmpty()) assertEquals(HttpStatus.BAD_REQUEST.value(), httpResponse.get().getStatusLine().getStatusCode());
	}
	
	@Test
	public void checkErroMessageWhileOutsourceNewConsumerGood() {
		long id = 5;
		//Capture
		final ConsumerGoodsRepository consumerGoodsRepositoryMock = Mockito.mock(ConsumerGoodsRepository.class);
		Mockito.when(consumerGoodsRepositoryMock.outsourceConsumerGoodsWith(id)).thenReturn(false);
		
		//Arange
		String idParameter = "id=5";
		
	    HttpUriRequest request = new HttpDelete( "http://localhost:8083/api/consumergoods/delete?" + idParameter);

	    //Act
	    Optional<CloseableHttpResponse> httpResponse = Optional.empty();
		try {
			httpResponse = Optional.of(HttpClientBuilder.create().build().execute( request ));
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    //Assert
		if(!httpResponse.isEmpty()) assertEquals(HttpStatus.NOT_FOUND.value(), httpResponse.get().getStatusLine().getStatusCode());
	}
	
	@Test
	public void checkNoErrorMessageIfNoConsumerGoodIsStoredTest() {
	    //Arange
	    HttpUriRequest request = new HttpGet( "http://localhost:8083/api/consumergoods/getAll");

	    //Act
	    Optional<CloseableHttpResponse> httpResponse = Optional.empty();
		try {
			httpResponse = Optional.of(HttpClientBuilder.create().build().execute( request ));
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    //Assert
		if(!httpResponse.isEmpty()) assertEquals(HttpStatus.OK.value(), httpResponse.get().getStatusLine().getStatusCode());
	}
}