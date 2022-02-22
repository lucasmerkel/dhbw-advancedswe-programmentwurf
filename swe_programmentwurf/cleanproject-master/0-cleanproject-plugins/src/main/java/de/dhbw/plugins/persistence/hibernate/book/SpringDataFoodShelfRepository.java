package de.dhbw.plugins.persistence.hibernate.book;

import org.springframework.data.jpa.repository.JpaRepository;

import de.dhbw.cleanproject.domain.book.FoodShelf;

public interface SpringDataFoodShelfRepository extends JpaRepository<FoodShelf, Long> {
}
