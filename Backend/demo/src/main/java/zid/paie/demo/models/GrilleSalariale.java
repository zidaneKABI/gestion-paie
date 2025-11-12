package zid.paie.demo.models;

import lombok.Data;

@Data
public class GrilleSalariale {
    private Long id;
 
    private String niveau;
    private String echelon;
    private Double salaireDeBase;
    private Double salaireAnnuel;
    private Double primeAnciennete;


}
