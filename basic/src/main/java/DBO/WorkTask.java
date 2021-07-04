package DBO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Locale;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@PrimaryKeyJoinColumn (name = "TASK_ID")
public class WorkTask extends Task {
    @Column(name = "cost")
    private Double cost;


}
