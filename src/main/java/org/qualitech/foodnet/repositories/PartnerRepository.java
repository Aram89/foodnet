package org.qualitech.foodnet.repositories;

import org.qualitech.foodnet.domain.Chef;
import org.qualitech.foodnet.domain.Partner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
public interface PartnerRepository extends CrudRepository <Partner, Long>, Repository<Partner, Long> {

    List<Partner> findByPhone(String phone);
    List<Partner> getByPartnerIdAndAccessToken(Long partnerId, String accessToken);

}
