package org.qualitech.foodnet.service;

import org.qualitech.foodnet.domain.Chef;
import org.qualitech.foodnet.repositories.ChefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Aram Kirakosyan.
 */
@Transactional
@Service
public class ChefServiceImpl implements ChefService {

    @Autowired
    ChefRepository repository;

    @Override
    public void createChef(Chef chef) {
        repository.save(chef);
    }

    @Override
    public boolean phoneExists(String phone) {
        boolean phoneExists = !repository.findByPhone(phone).isEmpty();
        System.out.println(phoneExists);
        return !repository.findByPhone(phone).isEmpty();
    }
}
