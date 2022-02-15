package de.dhbw.plugins.persistence.hibernate.book;

import org.springframework.data.jpa.repository.JpaRepository;

import de.dhbw.cleanproject.domain.book.ConsumerGoods;

public interface SpringDataConsumerGoodsRepository extends JpaRepository<ConsumerGoods, Long> {
}
