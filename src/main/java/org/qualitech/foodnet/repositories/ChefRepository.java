package org.qualitech.foodnet.repositories;

import org.qualitech.foodnet.domain.Chef;
import org.qualitech.foodnet.domain.ChefStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
public interface ChefRepository extends CrudRepository<Chef, Integer>, Repository<Chef, Integer> {

    List<Chef> findByPhone(String phone);
    List <Chef> getByChefIdAndAccessToken(long chefId, String accessToken);

    @Query(value = "SELECT c.name, c.chefId, c.surName FROM Chef c WHERE c.chefId >= :start AND c.chefId < :end")
    List<Chef> findChefs(@Param("start")int start,@Param("end") int end);

    List<Chef> findByStatus(ChefStatus status, Pageable pageable);

//    @Query(value = "SELECT c.chefId FROM Chef c JOIN Dish d ON d.chefId = c.chefId JOIN DishOrder ds ON ds.dishId = d.dishId WHERE ds.ordersId = :orderId")
//    List<Chef> findChefByOrder(@Param("orderId")String orderId);


}
