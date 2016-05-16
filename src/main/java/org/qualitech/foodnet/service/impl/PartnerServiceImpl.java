package org.qualitech.foodnet.service.impl;

import com.twilio.sdk.TwilioRestException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qualitech.foodnet.domain.Partner;
import org.qualitech.foodnet.domain.json.PartnerStatus;
import org.qualitech.foodnet.domain.json.WorkStatus;
import org.qualitech.foodnet.exception.AppException;
import org.qualitech.foodnet.exception.ErrorCodes;
import org.qualitech.foodnet.repositories.PartnerRepository;
import org.qualitech.foodnet.service.PartnerService;
import org.qualitech.foodnet.util.HashUtil;
import org.qualitech.foodnet.util.SmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
@Service
@Transactional
public class PartnerServiceImpl implements PartnerService {

    Logger logger = LogManager.getLogger(PartnerServiceImpl.class);

    @Autowired
    PartnerRepository repository;

    @Override
    public void create(Partner partner) {
        partner.setStatus(PartnerStatus.INACTIVE);
        repository.save(partner);
    }

    @Override
    public boolean phoneExists(String phone) {
        return !repository.findByPhone(phone).isEmpty();
    }

    @Override
    public void activate(String phone) throws AppException, NoSuchAlgorithmException, TwilioRestException {
        List<Partner> partners = repository.findByPhone(phone);
        if(partners.isEmpty()) {
            throw new AppException(ErrorCodes.WRONG_PHONE);
        }
        Partner partner = partners.get(0);
        partner.setStatus(PartnerStatus.ACTIVE);
        String password = HashUtil.generateRandomString(8);
        partner.setPassword(HashUtil.hash(password));
        String accessToken = HashUtil.generateRandomString(9) + partner.getPartnerId().toString();
        partner.setAccessToken(accessToken);
        repository.save(partner);
        SmsSender.send(phone, " Your account activated!, Password : " + password +
                ". You can login using your phone and password");
        logger.info("Sms was sent to : " + phone);
    }

    @Override
    public Partner login(String phone, String password) throws NoSuchAlgorithmException, AppException {
        List<Partner> partners = repository.findByPhone(phone);
        if (partners.size() != 1) {
            throw new AppException(ErrorCodes.WRONG_PHONE);
        }
        if (partners.get(0).getPassword() == null) {
            throw new AppException(ErrorCodes.INACTIVE_ACCOUNT);
        }
        String pass = partners.get(0).getPassword();
        if (!HashUtil.hash(password).equals(pass)) {
            throw new AppException(ErrorCodes.WRONG_PASSWORD);
        }
        Partner partner = partners.get(0);
        Partner loggedPartner = new Partner();
        loggedPartner.setPartnerId(partner.getPartnerId());
        loggedPartner.setAccessToken(partner.getAccessToken());
        return loggedPartner;
    }

    @Override
    public void updateWorkStatus(Long partnerId, WorkStatus workStatus) {
        repository.updateWorkStatus(partnerId, workStatus);
    }

    @Override
    public void updateWorkStatusUpdateTime(Long partnerId, Date date) {
        repository.updateWorkStatusUpdateTime(partnerId, date);
    }

    @Override
    public boolean checkAccessToken(Long chefId, String accessToken) {
        return !repository.getByPartnerIdAndAccessToken(chefId, accessToken).isEmpty();
    }

}
