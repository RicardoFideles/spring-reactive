package br.com.rf.springreactive.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import br.com.rf.springreactive.model.Car;

public interface CarRepository extends ReactiveMongoRepository<Car, String> {
}
