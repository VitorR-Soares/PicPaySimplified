package com.ratolla.PicPaySimplified.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "tbl_wallet_type")
public class WalletType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    public WalletType(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public WalletType() {
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static enum Enum{

        USER(1L, "user"),
        MERCHANT(2L, "merchant");

        private Long id;
        private String description;

        Enum(Long id, String description){
            this.id = id;
            this.description = description;
        }

        public Long getId(){
            return id;
        }

        public WalletType get(){
            return new WalletType(id, description);
        }
    }
}
