package de.mhae03.school.my_code_classtest;

import java.util.concurrent.Semaphore;

public class Kasse extends Thread {

	private final Semaphore tickets;

	public Kasse(Semaphore tickets) {
		this.tickets = tickets;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep((long) (Math.random() * 1500));
				this.tickets.acquire();
				System.out.printf("Ein Ticket wurde vor Ort gekauft. Es gibt noch %d Tickets.%n",
						this.tickets.availablePermits());
			} catch (InterruptedException e) {

			}
		}
	}

}
