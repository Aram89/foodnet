package org.qualitech.foodnet.service;

import org.qualitech.foodnet.domain.Chef;
import org.qualitech.foodnet.domain.ChefStatus;
import org.qualitech.foodnet.exception.AppException;
import org.qualitech.foodnet.exception.ErrorCodes;
import org.qualitech.foodnet.repositories.ChefRepository;
import org.qualitech.foodnet.util.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
@Service
@Transactional
public class ChefServiceImpl implements ChefService {

    private static List<String> onlineUsers;

    public static List<String> getOnlineUsers() {
        return onlineUsers;
    }

    public static void setOnlineUsers(List<String> onlineUsers) {
        ChefServiceImpl.onlineUsers = onlineUsers;
    }

    @Autowired
    ChefRepository repository;

    @Override
    public void createChef(Chef chef) {
        chef.setStatus(ChefStatus.INACTIVE);
        repository.save(chef);
    }

    @Override
    public boolean phoneExists(String phone) {
        return !repository.findByPhone(phone).isEmpty();
    }

    @Override
    public void activateChef(String phone) throws AppException, NoSuchAlgorithmException {
        List <Chef> chefs = repository.findByPhone(phone);
        if(chefs.isEmpty()) {
            throw new AppException(ErrorCodes.WRONG_PHONE);
        }
        Chef chef = chefs.get(0);
        chef.setStatus(ChefStatus.ACTIVE);
        String password = HashUtil.generateRandomString(8);
        chef.setPassword(HashUtil.hash(password));
        String accessToken = HashUtil.generateRandomString(9) + chef.getChefId().toString();
        chef.setAccessToken(accessToken);
        // TODO send sms with password.
    }

    @Override
    public List<Chef> getChefs(int page, int count) {
        PageRequest pageRequest = new PageRequest(page, count);
        return repository.findByStatus(ChefStatus.ACTIVE, pageRequest);
    }

    @Override
    public boolean checkAccessToken(Long chefId, String accessToken) {
        return !repository.getByChefIdAndAccessToken(chefId, accessToken).isEmpty();
    }


}
