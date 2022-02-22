package de.dhbw.plugins.persistence.hibernate.book;

import org.springframework.data.jpa.repository.JpaRepository;

import de.dhbw.cleanproject.domain.book.Fridge;

public interface SpringDataFridgeRepository extends JpaRepository<Fridge, Long> {
}
