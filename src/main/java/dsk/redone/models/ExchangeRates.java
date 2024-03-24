package dsk.redone.models;

import lombok.*;
import lombok.extern.log4j.Log4j;

//@Getter
//@Setter
//@ToString(of={"name","value"})

//@AllArgsConstructor
//@NoArgsConstructor
//@RequiredArgsConstructor
@Data
@EqualsAndHashCode(exclude ={"valuteID"})
@ToString (of={"name","value"})
@NoArgsConstructor
public class ExchangeRates {
    private String curID;
    private String name;
    private Double value;

}
