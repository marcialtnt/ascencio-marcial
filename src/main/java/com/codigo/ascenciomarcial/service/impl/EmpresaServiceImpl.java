package com.codigo.ascenciomarcial.service.impl;

import com.codigo.ascenciomarcial.constants.Constants;
import com.codigo.ascenciomarcial.dao.EmpresaRepository;
import com.codigo.ascenciomarcial.entity.EmpresaEntity;
import com.codigo.ascenciomarcial.service.EmpresaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {
    private final EmpresaRepository empresaRepository;

    @Override
    public EmpresaEntity crear(EmpresaEntity empresaEntity) {
        empresaEntity.setUsuaCrea(Constants.USUARIO);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        empresaEntity.setDateCreate(timestamp);
        return empresaRepository.save(empresaEntity);
    }

    @Override
    public Optional<EmpresaEntity> buscarxId(Long id) {
        return empresaRepository.findById(id);
    }

    @Override
    public List<EmpresaEntity> buscarAll() {
        return empresaRepository.findAll();
    }

    @Override
    public EmpresaEntity actualizar(Long id, EmpresaEntity empresaEntity) {
        Optional<EmpresaEntity> empresaRecuperada = empresaRepository.findById((id));
        if (empresaRecuperada.isPresent()) {
            EmpresaEntity empresa = empresaRecuperada.get();
            empresa.setRazonSocial(empresaEntity.getRazonSocial());
            empresa.setTipoDocumento(empresaEntity.getTipoDocumento());
            empresa.setNumeroDocumento(empresaEntity.getNumeroDocumento());
            empresa.setCondicion(empresaEntity.getCondicion());
            empresa.setDireccion(empresaEntity.getDireccion());
            empresa.setDistrito(empresaEntity.getDistrito());
            empresa.setProvincia(empresaEntity.getProvincia());
            empresa.setDepartamento(empresaEntity.getDepartamento());
            empresa.setEsAgenteRetencion(empresaEntity.getEsAgenteRetencion());
            empresa.setUsuaModif(Constants.USUARIO);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            empresa.setDateModif(timestamp);
            return empresaRepository.save(empresa);
        }
        return null;
    }

    @Override
    public EmpresaEntity borrar(Long id) {
        Optional<EmpresaEntity> empresaRecuperada = empresaRepository.findById(id);
        if (empresaRecuperada.isPresent()) {
            EmpresaEntity empresa = empresaRecuperada.get();
            empresa.setEstado(0);
            empresa.setUsuaDelet(Constants.USUARIO);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            empresa.setDateDelet(timestamp);
            return empresaRepository.save(empresa);
        }
        return null;
    }
}
