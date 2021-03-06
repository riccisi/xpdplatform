package it.tasgroup.xtderp.xtdplatform.prototype.model;


import it.tasgroup.xtderp.xtdplatform.core.metadata.annotation.XtdFormula;
import it.tasgroup.xtderp.xtdplatform.core.metadata.annotation.XtdMenu;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@Entity
@ToString
@EqualsAndHashCode(of = {"name","surname","birth"})
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@XtdMenu("menu.registry.customer")
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotBlank private String name;
    @NotBlank private String surname;
    private Date birth;
    private int test = 1;

    public Customer(final String name, final String surname, final Date birth) {
        this.name = name;
        this.surname = surname;
        this.birth = new Date(birth.getTime());
    }

    @XtdFormula
    public final int age() {
        final LocalDate birthday = this.birth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        final LocalDate now = LocalDate.now();
        final Period period = Period.between(birthday, now);
        return period.getYears();
    }

    @XtdFormula
    public final String fullName() {
        return String.format("%s %s", this.name, this.surname);
    }

    public final void process() {
        this.test += 1;
    }
}