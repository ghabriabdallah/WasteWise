package codadoor.pfe.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="subscription")
public class Subscription {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String additionalAddress;
    private Long postalCode;
    private String city;
    private String numTel;
    private String planName;
    private String clearanceType;
    private double price;
    private boolean paid;
    private String visitDates;
    
   


   
    
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
