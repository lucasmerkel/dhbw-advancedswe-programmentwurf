package de.dhbwka.inventurplaner.adapters;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import de.dhbwka.inventurplaner.domain.BestBeforeDate;
import de.dhbwka.inventurplaner.domain.Fridge;

@Component
public class FridgeToFridgeRessourceMapper implements Function<FridgeRessource, Fridge> {

	//both methods for mapping domain class to ressource class
	public FridgeRessource applyToRessource(Fridge fridge) {
        return mapToRessource(fridge);
    }

    private FridgeRessource mapToRessource(Fridge fridge) {
    	//TODO no new object, instead update Ressource object
    	return new FridgeRessource(fridge.getDescription());
    }
    
    //both methods for mapping ressource class to domain class
	public Fridge applyToDomain(FridgeRessource fridgeRessource) {
        return mapToDomain(fridgeRessource);
    }

    private Fridge mapToDomain(FridgeRessource fridgeRessource) {
        return new Fridge(fridgeRessource.getDescription());
    }

	public Fridge apply(FridgeRessource t) {
		// TODO Auto-generated method stub
		return null;
	}
}
