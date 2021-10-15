package com.hackerearth.challenge.omnicell.Reciepe.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackerearth.challenge.omnicell.Reciepe.entities.Reciepe;
import com.hackerearth.challenge.omnicell.Reciepe.repository.ReciepeReopositoryImpl;

@Service("reciepeService")
public class ReciepeService {

	private final ReciepeReopositoryImpl reciepeReopository;
	
	public ReciepeService(@Qualifier("reciepeReopository") ReciepeReopositoryImpl reciepeReopository) {
		this.reciepeReopository = reciepeReopository;
		
	}
	
	public Reciepe getReciepeObject(int reciepeId) {
		return reciepeReopository.getReciepe(reciepeId);
		
	}
	
	public String addReciepe(Reciepe reciepe) {
		return reciepeReopository.saveReciepe(reciepe);
		
	}
	public List<Reciepe> getAllReciepe(){
		return reciepeReopository.allReciepe();
		
	}
	
	@PostConstruct
	public void loadRecipesFromAPI() throws IOException {
		
		URL url = new URL("https://s3-ap-southeast-1.amazonaws.com/he-public-data/reciped9d7b8c.json");

		// Open a connection(?) on the URL(??) and cast the response(???)
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// Now it's "open", we can set the request method, headers etc.
		connection.setRequestProperty("accept", "application/json");

		// This line makes the request
		InputStream responseStream = connection.getInputStream();

		// Manually converting the response body InputStream to APOD using Jackson
		ObjectMapper mapper = new ObjectMapper();
		Reciepe[] reciepeList = mapper.readValue(responseStream, Reciepe[].class);
		for(Reciepe r : reciepeList) {
			reciepeReopository.saveReciepe(r);
		}
		// Finally we have the response
		System.out.println(reciepeList.length);
	}
}
