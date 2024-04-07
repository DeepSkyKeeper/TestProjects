package dsk.redone.models;

import lombok.*;

//@Getter
//@Setter

//@AllArgsConstructor
//@NoArgsConstructor
//@RequiredArgsConstructor
@Data
//@EqualsAndHashCode(exclude ={"curId"})
@ToString (of={"id","value","nominal","date"})
@NoArgsConstructor
public class ExRate {
    private String id;
    private String date;
    private String nominal;
    private String value;

}
