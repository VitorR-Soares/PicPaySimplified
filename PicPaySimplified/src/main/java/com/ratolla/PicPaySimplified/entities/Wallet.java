package com.ratolla.PicPaySimplified.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tbl_wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "cpf_cnpj", unique = true)
    private String cpfCnpj;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "balance")
    private BigDecimal balance = BigDecimal.ZERO;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private WalletType walletType;

    public Wallet(String fullname, String cpfCnpj, String email, String password, WalletType walletType) {
        this.fullname = fullname;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.password = password;
        this.walletType = walletType;
    }

    public Wallet() {
    }

    public boolean isWalletTypeUser(){
        return this.walletType.equals(WalletType.Enum.USER.get());
    }

    public boolean isBalanceEnough(BigDecimal value){
        return value.doubleValue() <= this.balance.doubleValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Objects.equals(id, wallet.id) && Objects.equals(fullname, wallet.fullname) && Objects.equals(cpfCnpj, wallet.cpfCnpj) && Objects.equals(email, wallet.email) && Objects.equals(password, wallet.password) && Objects.equals(balance, wallet.balance) && Objects.equals(walletType, wallet.walletType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullname, cpfCnpj, email, password, balance, walletType);
    }

    public Long getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public WalletType getWalletType() {
        return walletType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setWalletType(WalletType walletType) {
        this.walletType = walletType;
    }
}
