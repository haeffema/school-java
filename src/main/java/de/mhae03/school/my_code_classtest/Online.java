package de.mhae03.school.my_code_classtest;

import java.util.concurrent.Semaphore;

public class Online extends Thread {

	private final Semaphore tickets;

	public Online(Semaphore tickets) {
		this.tickets = tickets;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep((long) (Math.random() * 3000));
				this.tickets.acquire();
				System.out.printf("Ein Ticket wurde online gekauft. Es gibt noch %d Tickets.%n",
						this.tickets.availablePermits());
			} catch (InterruptedException e) {

			}
		}
	}

}
