package it.tasgroup.xtderp.xtdplatform.admin;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
public interface User extends Serializable {

    String userName();

    String password();

    String displayName();

    Date startDate();

    Date endDate();

    boolean active();

    List<Role> roles();
}