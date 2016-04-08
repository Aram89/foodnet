package org.qualitech.foodnet.service;

import com.twilio.sdk.TwilioRestException;
import org.qualitech.foodnet.domain.Partner;
import org.qualitech.foodnet.exception.AppException;

import java.security.NoSuchAlgorithmException;

/**
 * @author Aram Kirakosyan.
 */
public interface PartnerService {

    void create(Partner partner);
    boolean phoneExists(String phone);
    boolean checkAccessToken(Long partnerId, String accessToken);
    void activate(String phone) throws AppException, NoSuchAlgorithmException, TwilioRestException;
    Partner login(String phone, String password) throws NoSuchAlgorithmException, AppException;
}
