package org.qualitech.foodnet.service.impl;

import org.qualitech.foodnet.service.CourierService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Aram Kirakosyan.
 */
@Service
@Transactional
public class CourierServiceImpl extends PartnerServiceImpl implements CourierService {
}
