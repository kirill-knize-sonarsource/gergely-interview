package eu.sige.daterbackend.statistic.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "accesses")
public class AccessData {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date access;

    @PrePersist
    private void onCreate(){
        access = new Date(System.currentTimeMillis());
    }

}
