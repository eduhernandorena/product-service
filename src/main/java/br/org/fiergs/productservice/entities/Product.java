package br.org.fiergs.productservice.entities;

import br.org.fiergs.productservice.entities.enumeration.ProductType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Código não pode ser vazio!")
    private String code;

    @NotEmpty(message = "Descrição não pode ser vazia!")
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
