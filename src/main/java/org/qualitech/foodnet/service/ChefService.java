package org.qualitech.foodnet.service;

import org.qualitech.foodnet.domain.Chef;
import org.qualitech.foodnet.exception.AppException;
import org.springframework.data.domain.Page;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
public interface ChefService {

    void createChef(Chef chef);
    boolean phoneExists(String phone);
    public boolean checkAccessToken(Long chefId, String accessToken);
    public void activateChef(String phone) throws AppException, NoSuchAlgorithmException;
    public List<Chef> getChefs(int start, int end);

}
