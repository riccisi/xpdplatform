package it.tasgroup.xtderp.xtdplatform.prototype.model;


import it.tasgroup.xtderp.xtdplatform.core.metadata.annotation.XtdFormula;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @NotBlank private String name;
    @NotBlank private String surname;
    private Date birth;
    private Integer age;
    private int test = 1;

    public Customer() {}

    public Customer(final String name, final String surname, final Date birth, final Integer age) {
        this.name = name;
        this.surname = surname;
        this.birth = new Date(birth.getTime());
        this.age = age;
    }

    @XtdFormula
    public final String fullName() {
        return String.format("%s %s", this.name, this.surname);
    }

    public final void process() {
        this.test += 1;
    }
}