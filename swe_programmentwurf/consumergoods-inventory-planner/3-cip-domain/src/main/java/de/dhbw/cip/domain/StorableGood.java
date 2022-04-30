package de.dhbw.cip.domain;

public interface StorableGood {

	public String getDescription();

	public StorableGood getInstance();
	
	public BestBeforeDate getBestBeforeDate();
}
