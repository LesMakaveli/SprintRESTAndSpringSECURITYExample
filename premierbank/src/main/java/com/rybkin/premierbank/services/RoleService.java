package com.rybkin.premierbank.services;

import com.rybkin.premierbank.entities.Role;
import com.rybkin.premierbank.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService
{
    private final RoleRepository roleRepository;

    public Optional<Role> getUserRole() {
        return roleRepository.findByName("ROLE_USER");
    }
}
