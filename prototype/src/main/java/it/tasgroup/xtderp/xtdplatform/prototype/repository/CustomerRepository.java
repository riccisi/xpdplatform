package it.tasgroup.xtderp.xtdplatform.prototype.repository;

import it.tasgroup.xtderp.xtdplatform.prototype.model.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}