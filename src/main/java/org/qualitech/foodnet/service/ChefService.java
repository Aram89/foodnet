package org.qualitech.foodnet.service;

import org.qualitech.foodnet.domain.Chef;

import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
public interface ChefService extends PartnerService {

    List<Chef> getChefs(int start, int end);
}
