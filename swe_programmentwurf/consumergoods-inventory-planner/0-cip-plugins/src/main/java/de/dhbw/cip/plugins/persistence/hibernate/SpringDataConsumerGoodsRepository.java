package de.dhbw.cip.plugins.persistence.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;

import de.dhbw.cip.adapters.ConsumerGoodsResource;
import de.dhbw.cip.domain.ConsumerGoods;

public interface SpringDataConsumerGoodsRepository extends JpaRepository<ConsumerGoods, Long> {
}
