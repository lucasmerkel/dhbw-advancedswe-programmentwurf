package de.dhbw.cip.plugins.persistence.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;

import de.dhbw.cip.domain.FoodShelf;

public interface PersistenceFoodShelfRepository extends JpaRepository<FoodShelf, Long> {
}
