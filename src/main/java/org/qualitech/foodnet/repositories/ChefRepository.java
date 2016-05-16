package org.qualitech.foodnet.repositories;

import org.qualitech.foodnet.domain.Chef;
import org.qualitech.foodnet.domain.json.PartnerStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
public interface ChefRepository extends CrudRepository<Chef, Long>, Repository<Chef, Long> {

    @Query(value = "SELECT c.name, c.partnerId, c.surName FROM Chef c WHERE c.partnerId >= :start AND c.partnerId < :end")
    List<Chef> findChefs(@Param("start")int start,@Param("end") int end);

    List<Chef> findByStatus(PartnerStatus status, Pageable pageable);

//    @Query(value = "SELECT c.chefId FROM Chef c JOIN Dish d ON d.chefId = c.chefId JOIN DishOrder ds ON ds.dishId = d.dishId WHERE ds.ordersId = :orderId")
//    List<Chef> findChefByOrder(@Param("orderId")String orderId);


}
