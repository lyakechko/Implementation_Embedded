package DBO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Locale;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("W")
@Entity
@Table
public class WorkTask extends Task {
    @Column(name = "cost")
    private Locale cost;


}
