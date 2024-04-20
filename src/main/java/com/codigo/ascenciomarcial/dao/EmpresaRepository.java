package com.codigo.ascenciomarcial.dao;

import com.codigo.ascenciomarcial.entity.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Long> {
}
