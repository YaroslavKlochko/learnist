package com.learnist.database.service;

import com.learnist.database.repository.RoleRepository;
import com.learnist.domain.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role findRoleByName(final String name){
        return roleRepository.findRoleByName(name);
    }
}
