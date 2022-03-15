package de.dhbw.cip.plugins.persistence.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;

import de.dhbw.cip.domain.FoodShelf;

public interface SpringDataFoodShelfRepository extends JpaRepository<FoodShelf, Long> {
}
