package by.etc.code_review.module6.task04.entity;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Harbor {

	private String name;
	private BlockingQueue<Pier> piers;
	private Semaphore semaphore;
	private int numberOfPiers;
	private BlockingQueue<Cargo> storage;

	public Harbor(String name, int numberOfPiers, int storageCapacity) {
		this.name = name;
		piers = new ArrayBlockingQueue<>(numberOfPiers);
		storage = new ArrayBlockingQueue<>(storageCapacity);
		semaphore = new Semaphore(numberOfPiers, true);
		this.numberOfPiers = numberOfPiers;
		createPiers();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private void createPiers() {
		for (int i = 0; i < numberOfPiers; i++) {
			piers.add(new Pier());
		}
	}

	public Pier getPier() {
		Pier pier = null;

		try {
			if (semaphore.tryAcquire(500, TimeUnit.MILLISECONDS)) {
				pier = piers.poll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return pier;

	}

	public void releasePier(Pier pier) {
		try {
			piers.put(pier);
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public void addCargo(Cargo cargo) {
		try {
			storage.put(cargo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Cargo takeCargo() {
		Cargo cargo = null;
		try {
			cargo = storage.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return cargo;
	}

	public BlockingQueue<Pier> getPiers() {
		return piers;
	}

	public BlockingQueue<Cargo> getStorage() {
		return storage;
	}

	@Override
	public String toString() {
		return name + " Harbor";
	}
}
