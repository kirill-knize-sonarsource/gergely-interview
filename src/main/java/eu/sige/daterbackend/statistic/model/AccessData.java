package eu.sige.daterbackend.statistic.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "accesses")
public class AccessData {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Basic(fetch = FetchType.LAZY)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date access;

    public Date getAccess() {
        return access;
    }

    @PrePersist
    private void onCreate(){
        access = new Date(System.currentTimeMillis());
    }

}
