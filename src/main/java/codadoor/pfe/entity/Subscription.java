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
    private String addionalAddress;
    private Number postalCode;
    private String city;
    private String numTel;
    private String planName;
    private double price;
    private boolean paid;
    private String visitDates; // Store visitDates as a string
    @OneToOne
    private User user;
    
    public void setVisitDates(List<Date> visitDates) {
        // Convert list of dates to a string
        StringBuilder sb = new StringBuilder();
        for (Date date : visitDates) {
            sb.append(date.toString()).append(",");
        }
        this.visitDates = sb.toString();
    }
    
    public List<Date> getVisitDates() {
        // Convert string to list of dates
        List<Date> dates = new ArrayList<>();
        if (visitDates != null && !visitDates.isEmpty()) {
            String[] dateStrings = visitDates.split(",");
            for (String dateString : dateStrings) {
                dates.add(Date.valueOf(dateString));
            }
        }
        return dates;
    }
}
