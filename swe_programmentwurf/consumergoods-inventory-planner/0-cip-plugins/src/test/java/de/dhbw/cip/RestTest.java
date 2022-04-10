package de.dhbw.cip;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Optional;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;

import de.dhbw.cip.abstractioncode.Day;
import de.dhbw.cip.abstractioncode.DayOfYear;
import de.dhbw.cip.abstractioncode.Month;
import de.dhbw.cip.abstractioncode.Year;
import de.dhbw.cip.application.ConsumerGoodsManager;
import de.dhbw.cip.domain.BestBeforeDate;
import de.dhbw.cip.domain.ConsumerGoods;
import de.dhbw.cip.domain.Food;
import de.dhbw.cip.domain.Fridge;
import de.dhbw.cip.domain.ConsumerGoods.ConsumerGoodsBuilder;
import de.dhbw.cip.domain.ConsumerGoodsRepository;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

public class RestTest {

	@Test
	public void createTest() {
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
	public void createBadRequestTest() {
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
	public void updateBadRequestTest() {
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
	public void deleteFailureTest() {
	    //Arange
		long id = 5;
		
		final ConsumerGoodsRepository consumerGoodsRepositoryMock = Mockito.mock(ConsumerGoodsRepository.class);
		Mockito.when(consumerGoodsRepositoryMock.outsourceConsumerGoodsWith(id)).thenReturn(false);
		
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
	public void getTest() {
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

/*	@Test
public void createFailureTest() {
    //Arange
	String foodDescriptionParameter = "description=Tomatoes";
	String bestBeforeDateDayParameter = "bestbeforedateday=02";
	String bestBeforeDateMonthParameter = "bestbeforedatemonth=04";
	String bestBeforeDateYearParameter = "bestbeforedateyear=2022";
	String quantityValueParameter = "quantityvalue=1";
	String quantityParameter = "quantity=kg";
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
	if(!httpResponse.isEmpty()) assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), httpResponse.get().getStatusLine().getStatusCode());
}
*/

/*	
@Test
public void updateTest() {
    //Arange
	ConsumerGoods newConsumerGoods = new ConsumerGoodsBuilder("Tomatoes", 3, 3, 2022, "Stk.", 1, "Fridge", "Mockup Fridge").build();
	long id = 5;
	
	final ConsumerGoodsRepository consumerGoodsRepositoryMock = Mockito.mock(ConsumerGoodsRepository.class);
	Mockito.when(consumerGoodsRepositoryMock.findStoredConsumerGoods(id).get()).thenReturn(newConsumerGoods);
	
	String idParameter = "id=5";
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
	if(!httpResponse.isEmpty()) assertEquals(HttpStatus.OK.value(), httpResponse.get().getStatusLine().getStatusCode());
}
*/
/*
@Test
public void updateFailureTest() {
    //Arange
	String idParameter = "id=";
	String foodDescriptionParameter = "description=Tomatoes";
	String bestBeforeDateDayParameter = "bestbeforedateday=02";
	String bestBeforeDateMonthParameter = "bestbeforedatemonth=04";
	String bestBeforeDateYearParameter = "bestbeforedateyear=2022";
	String quantityValueParameter = "quantityvalue=1";
	String quantityParameter = "quantity=kg";
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
	if(!httpResponse.isEmpty()) assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), httpResponse.get().getStatusLine().getStatusCode());
}
*/

/*
@Test
public void deleteTest() {
    //Arange
	long id = 5;
	
	final ConsumerGoodsRepository consumerGoodsRepositoryMock = Mockito.mock(ConsumerGoodsRepository.class);
	Mockito.when(consumerGoodsRepositoryMock.outsourceConsumerGoods(id)).thenReturn(true);
	
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
	if(!httpResponse.isEmpty()) assertEquals(HttpStatus.OK.value(), httpResponse.get().getStatusLine().getStatusCode());
}
*/