package de.dhbw.cip.plugins.persistence.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;

import de.dhbw.cip.domain.ConsumerGood;

public interface PersistenceConsumerGoodRepository extends JpaRepository<ConsumerGood, Long> {
}
