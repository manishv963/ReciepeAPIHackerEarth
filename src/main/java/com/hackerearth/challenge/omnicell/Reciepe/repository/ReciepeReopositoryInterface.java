package com.hackerearth.challenge.omnicell.Reciepe.repository;

import java.util.List;

import com.hackerearth.challenge.omnicell.Reciepe.entities.Reciepe;

public interface ReciepeReopositoryInterface {
	
	public String saveReciepe(Reciepe reciepe);
	
	public Reciepe getReciepe(int reciepeId);
	
	public List<Reciepe> allReciepe();
	

}
