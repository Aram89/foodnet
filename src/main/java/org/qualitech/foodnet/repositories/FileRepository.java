package org.qualitech.foodnet.repositories;

import org.qualitech.foodnet.domain.File;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Aram Kirakosyan.
 */
public interface FileRepository extends CrudRepository<File, Long> {
}
