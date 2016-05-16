package org.qualitech.foodnet.repositories;

import org.qualitech.foodnet.domain.Partner;
import org.qualitech.foodnet.domain.json.WorkStatus;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * @author Aram Kirakosyan.
 */

public interface PartnerRepository extends CrudRepository <Partner, Long>, Repository<Partner, Long> {

    List<Partner> findByPhone(String phone);
    List<Partner> getByPartnerIdAndAccessToken(Long partnerId, String accessToken);
    List<Partner> findByPartnerId(Long partnerId);

    @Modifying
    @Query("update Partner p set p.workStatus = :workStatus where p.partnerId = :partnerId")
    void updateWorkStatus(@Param("partnerId") long partnerId, @Param("workStatus")WorkStatus workStatus);

    @Modifying
    @Query("update Partner p set p.workStatusUpdateTime = :workStatusUpdateTime where p.partnerId = :partnerId")
    void updateWorkStatusUpdateTime(@Param("partnerId") long partnerId, @Param("workStatusUpdateTime")Date workStatusUpdateTime);

}
