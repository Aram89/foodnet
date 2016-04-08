package org.qualitech.foodnet.service;

import com.twilio.sdk.TwilioRestException;
import org.qualitech.foodnet.domain.Chef;
import org.qualitech.foodnet.exception.AppException;
import org.springframework.data.domain.Page;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
public interface ChefService extends PartnerService {

    List<Chef> getChefs(int start, int end);

}
