package pers.wdcy.resut.reactor.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import pers.wdcy.resut.reactor.entity.Order;

public interface OrderRepository extends R2dbcRepository<Order, Integer>{

}
