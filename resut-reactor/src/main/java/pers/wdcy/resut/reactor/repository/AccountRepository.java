package pers.wdcy.resut.reactor.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import pers.wdcy.resut.reactor.entity.Account;

public interface AccountRepository extends R2dbcRepository<Account, Integer>{

}
