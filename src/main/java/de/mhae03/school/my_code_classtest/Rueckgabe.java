package de.mhae03.school.my_code_classtest;

import java.util.concurrent.Semaphore;

public class Rueckgabe extends Thread {

	private final Semaphore tickets;

	public Rueckgabe(Semaphore tickets) {
		this.tickets = tickets;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep((long) (Math.random() * 2250));
				if (this.tickets.availablePermits() < 100) {
					this.tickets.release();
					System.out.printf("Ein Ticket wurde zurückgegeben. Es gibt jetzt wieder %d Tickets.%n",
							this.tickets.availablePermits());
				}
			} catch (InterruptedException e) {

			}
		}
	}
}
