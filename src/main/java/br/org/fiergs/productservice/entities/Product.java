package br.org.fiergs.productservice.entities;

import br.org.fiergs.productservice.entities.enumeration.ProductType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "CAD_PRODUCT")
@SequenceGenerator(name = "seqCad_Product", sequenceName = "SEQCAD_PRODUCT", allocationSize = 1)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqCad_Product")
    private Long id;

    @NotEmpty(message = "Código é obrigatório!")
    private String code;

    @NotEmpty(message = "Descrição é obrigatória!")
    private String description;

    private String descriptionEnglish;

    private String descriptionSpanish;

    private ProductType productType;

    private boolean incomeTax;

    private double weight;

    private Date manufacturing;

    private String taxClass;

    private String pharmacyAgreement;

    private String DCBAgreement;

    private String NCMAgreement;

    private String obs;
}
