package de.dhbwka.inventurplaner.plugins;
import org.springframework.data.jpa.repository.JpaRepository;

import de.dhbwka.inventurplaner.domain.ConsumerGoods;

public interface SpringDataConsumerGoodsRepository extends JpaRepository<ConsumerGoods, Long> {

}
