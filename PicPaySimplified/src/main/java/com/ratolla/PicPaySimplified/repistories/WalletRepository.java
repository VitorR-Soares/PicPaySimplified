package com.ratolla.PicPaySimplified.repistories;


import com.ratolla.PicPaySimplified.domain.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface WalletRepository extends JpaRepository<Wallet, UUID> {
    Optional<Wallet> findByCpfCnpjOrEmail(String cpfcnpj, String email);
}
