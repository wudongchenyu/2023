package pers.wdcy.resut.reactor.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import pers.wdcy.resut.reactor.entity.Storage;

public interface StorageRepository extends R2dbcRepository<Storage, Integer>{

}
