package de.dhbw.cip;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.util.Optional;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

import de.dhbw.cip.domain.ConsumerGoodRepository;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

public class ConsumerGoodGuiControllerTest {

	@Test
	public void storeNewConsumerGoodTest() {
	    //Arange
		String eanCodeParameter = "eancode=12345678901";
		String foodDescriptionParameter = "description=Tomatoes";
		String bestBeforeDateDayParameter = "bestbeforedateday=02";
		String bestBeforeDateMonthParameter = "bestbeforedatemonth=04";
		String bestBeforeDateYearParameter = "bestbeforedateyear=2022";
		String quantityValueParameter = "quantityvalue=1";
		String quantityParameter = "quantity=Stk.";
		String storageParameter = "storage=FridgeInTheBasement";
		String storageTypeParameter = "storagetype=Fridge";
		
	    HttpUriRequest request = new HttpPost( "http://localhost:8083/api/consumergoods/add?" + eanCodeParameter + "&" + foodDescriptionParameter + "&"
	    		+ bestBeforeDateDayParameter + "&" + bestBeforeDateMonthParameter + "&" + bestBeforeDateYearParameter 
	    		+ "&" + quantityValueParameter + "&" + quantityParameter + "&" + storageParameter + "&" + storageTypeParameter);

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
		String eanCodeParameter = "eancode=12345678901";
		String foodDescriptionParameter = "description=Tomatoes";
		String bestBeforeDateDayParameter = "bestbeforedateday=02";
		String bestBeforeDateMonthParameter = "bestbeforedatemonth=04";
		String bestBeforeDateYearParameter = "bestbeforedateyear=2022";
		String quantityValueParameter = "quantityvalue=1";
		String quantityParameter = "quantity=";
		String storageParameter = "storage=Fridge";
		String storageTypeParameter = "storagetype=Fridge";
		
	    HttpUriRequest request = new HttpPost( "http://localhost:8083/api/consumergoods/add?" + eanCodeParameter + "&" + foodDescriptionParameter + "&"
	    		+ bestBeforeDateDayParameter + "&" + bestBeforeDateMonthParameter + "&" + bestBeforeDateYearParameter 
	    		+ "&" + quantityValueParameter + "&" + quantityParameter + "&" + storageParameter + "&" + storageTypeParameter);

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
		String eanCodeParameter = "eancode=";
		String foodDescriptionParameter = "description=Tomatoes";
		String bestBeforeDateDayParameter = "bestbeforedateday=02";
		String bestBeforeDateMonthParameter = "bestbeforedatemonth=04";
		String bestBeforeDateYearParameter = "bestbeforedateyear=2022";
		String quantityValueParameter = "quantityvalue=1";
		String quantityParameter = "quantity=Stk.";
		String storageParameter = "storage=Fridge";
		String storageTypeParameter = "storagetype=Fridge";
		
	    HttpUriRequest request = new HttpPut( "http://localhost:8083/api/consumergoods/update?" + eanCodeParameter + "&" + foodDescriptionParameter + "&"
	    		+ bestBeforeDateDayParameter + "&" + bestBeforeDateMonthParameter + "&" + bestBeforeDateYearParameter 
	    		+ "&" + quantityValueParameter + "&" + quantityParameter + "&" + storageParameter + "&" + storageTypeParameter);

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
		final ConsumerGoodRepository consumerGoodsRepositoryMock = Mockito.mock(ConsumerGoodRepository.class);
		Mockito.when(consumerGoodsRepositoryMock.outsourceConsumerGoodsWith(id)).thenReturn(false);
		
		//Arange
		String eanCodeParameter = "eancode=5";
		
	    HttpUriRequest request = new HttpDelete( "http://localhost:8083/api/consumergoods/delete?" + eanCodeParameter);

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
		
		//Verify
		verify(consumerGoodsRepositoryMock, Mockito.times(1));
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