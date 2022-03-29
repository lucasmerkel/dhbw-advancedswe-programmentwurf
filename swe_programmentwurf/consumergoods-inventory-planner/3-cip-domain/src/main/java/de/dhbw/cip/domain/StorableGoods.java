package de.dhbw.cip.domain;

public interface StorableGoods {

	public String getDescription();

	public StorableGoods getInstance();
	
	public void setDescription(String description);
	
	public void setBestBeforeDate(BestBeforeDate bbd);
	
	public BestBeforeDate getBestBeforeDate();
}
