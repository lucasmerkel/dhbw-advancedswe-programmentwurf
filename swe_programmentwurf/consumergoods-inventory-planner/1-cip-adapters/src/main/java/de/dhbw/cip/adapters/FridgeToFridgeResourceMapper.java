package de.dhbw.cip.adapters;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import de.dhbw.cip.domain.Fridge;

@Component
public class FridgeToFridgeResourceMapper implements Function<Fridge, FridgeResource> {

    @Override
    public FridgeResource apply(Fridge fridge) {
        return map(fridge);
    }

    private FridgeResource map(Fridge fridge) {
    	return new FridgeResource(fridge.getId(), fridge.getDescription(), fridge.getClass().getSimpleName());
    }

}
