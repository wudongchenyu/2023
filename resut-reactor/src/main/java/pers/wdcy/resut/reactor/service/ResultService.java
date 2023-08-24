package pers.wdcy.resut.reactor.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import pers.wdcy.resut.reactor.entity.Order;
import pers.wdcy.resut.reactor.exception.BusinessException;
import pers.wdcy.resut.reactor.repository.AccountRepository;
import pers.wdcy.resut.reactor.repository.OrderRepository;
import pers.wdcy.resut.reactor.repository.StorageRepository;
import pers.wdcy.resut.reactor.result.Result;
import pers.wdcy.resut.reactor.result.Results;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ResultService {

	private @Autowired AccountRepository accountRepository;
	private @Autowired StorageRepository storageRepository;
	private @Autowired OrderRepository orderRepository;

	@Transactional
	public Mono<Result<Boolean>> increaseOrder() {

		return accountRepository.findById(1).map(account -> {
			account.setMoney(account.getMoney() - 10);
			return account;
		}).flatMap(accountRepository::save).flatMap(account -> storageRepository.findById(1).map(storage -> {
			storage.setCount(storage.getCount() - 10);
			return storage;
		}).flatMap(storageRepository::save).map(storage -> {
			Order order = new Order();
			order.setId(1);
			order.setUserId(account.getUserId());
			order.setCommodityCode(storage.getCommodityCode());
			order.setMoney(10);
			order.setCount(10);
			return order.fresh();
		}).flatMap(orderRepository::save))
		.map(order -> {
			return Objects.nonNull(order);
		})
		.map(Result::success)
		.doOnError(error -> {
			log.error("{}", error.toString());
			throw new BusinessException(Results.ERROR_ORDER_INCREASE);
				});
	}
	
}
