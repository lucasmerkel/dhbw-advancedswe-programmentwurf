package de.dhbw.cip.plugins.persistence.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;

import de.dhbw.cip.domain.Fridge;

public interface SpringDataFridgeRepository extends JpaRepository<Fridge, Long> {
}
