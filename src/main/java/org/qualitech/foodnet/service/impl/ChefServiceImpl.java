package org.qualitech.foodnet.service.impl;

import org.apache.logging.log4j.LogManager;
import org.qualitech.foodnet.domain.Chef;
import org.qualitech.foodnet.domain.json.PartnerStatus;
import org.qualitech.foodnet.repositories.ChefRepository;
import org.qualitech.foodnet.service.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
@Service
@Transactional
public class ChefServiceImpl extends PartnerServiceImpl implements ChefService  {

    // Logger.
    private  static org.apache.logging.log4j.Logger logger = LogManager.getLogger(ChefServiceImpl.class);

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
    public List<Chef> getChefs(int page, int count) {
        PageRequest pageRequest = new PageRequest(page, count);
        return repository.findByStatus(PartnerStatus.ACTIVE, pageRequest);
    }

}
