package br.com.rf.springreactive.runner;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.rf.springreactive.model.Car;
import br.com.rf.springreactive.repository.CarRepository;
import reactor.core.publisher.Flux;

@Component
class DummyData implements CommandLineRunner {

	private final CarRepository carRepository;

	DummyData(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		carRepository.deleteAll()
				.thenMany(Flux
						.just("Koenigsegg One:1", "Hennessy Venom GT", "Bugatti Veyron Super Sport",
								"SSC Ultimate Aero", "McLaren F1", "Pagani Huayra", "Noble M600", "Aston Martin One-77",
								"Ferrari LaFerrari", "Lamborghini Aventador")
						.map(model -> new Car(UUID.randomUUID().toString(), model)).flatMap(carRepository::save))
				.subscribe(System.out::println);

		// Disposable subscribe = Mono.fromCallable(() ->
		// System.currentTimeMillis())
		// .repeat()
		// .parallel(2)
		// .runOn(Schedulers.parallel())
		// .doOnNext(d -> System.out.println("I'm on thread: " +
		// Thread.currentThread()))
		// .sequential()
		// .subscribe();
	}
}