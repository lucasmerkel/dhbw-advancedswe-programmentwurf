package de.dhbwka.inventurplaner.adapters;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import de.dhbwka.inventurplaner.domain.BestBeforeDate;

@Component
public class BestBeforeDateToBestBeforeDateRessourceMapper implements Function<BestBeforeDateRessource, BestBeforeDate> {

	//both methods for mapping domain class to ressource class
	public BestBeforeDateRessource applyToRessource(BestBeforeDate bbd) {
        return mapToRessource(bbd);
    }

    private BestBeforeDateRessource mapToRessource(BestBeforeDate bbd) {
    	//TODO no new object, instead update Ressource object
    	return new BestBeforeDateRessource(bbd.getDay(), bbd.getMonth(), bbd.getYear());
    }
    
    //both methods for mapping ressource class to domain class
	public BestBeforeDate applyToDomain(BestBeforeDateRessource bbdRessource) {
        return mapToDomain(bbdRessource);
    }

    private BestBeforeDate mapToDomain(BestBeforeDateRessource bbdRessource) {
        return new BestBeforeDate(bbdRessource.getDay(), bbdRessource.getMonth(), bbdRessource.getYear());
    }

	public BestBeforeDate apply(BestBeforeDateRessource t) {
		// TODO Auto-generated method stub
		return null;
	}
}
