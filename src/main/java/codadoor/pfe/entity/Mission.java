package codadoor.pfe.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mission")
public class Mission {

    @Id
    @GeneratedValue
    private Long id;

    private String visitDates;

    private String pickupAddress;
    private String additionalAddress;
    private Long postalCode;
    private String city;
    private String numTel;
    
    @Column(name = "mission_status")
    private String missionStatus= "Not Started";

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "driver_id")
    private User driver;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getMissionStatus() {
        return missionStatus;
    }

    public void setMissionStatus(String missionStatus) {
        this.missionStatus = missionStatus;
    }

   

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public String getAdditionalAddress() {
        return additionalAddress;
    }

    public void setAdditionalAddress(String additionalAddress) {
        this.additionalAddress = additionalAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public Long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Long postalCode) {
        this.postalCode = postalCode;
    }

    public void setDriverId(Long driverId) {
        if (driverId != null) {
            this.driver = new User();
            this.driver.setId(driverId);
        } else {
            this.driver = null;
        }
    }

    public void setVisitDates(List<Date> visitDates) {
        if (visitDates == null || visitDates.isEmpty()) {
            this.visitDates = null;
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Date date : visitDates) {
            sb.append(date.toString()).append(",");
        }
        this.visitDates = sb.substring(0, sb.length() - 1);
    }

    
    public List<Date> getVisitDates() {
        List<Date> dates = new ArrayList<>();
        if (visitDates == null || visitDates.isEmpty()) {
            return dates;
        }
        String[] dateStrings = visitDates.split(",");
        for (String dateString : dateStrings) {
            dates.add(Date.valueOf(dateString));
        }
        return dates;
    }
}
