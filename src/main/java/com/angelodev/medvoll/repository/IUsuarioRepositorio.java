package com.angelodev.medvoll.repository;

import com.angelodev.medvoll.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUsuarioRepositorio extends JpaRepository<Usuario, Long> {

    UserDetails findByLogin(String username);
}
