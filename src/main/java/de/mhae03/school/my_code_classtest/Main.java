package de.mhae03.school.my_code_classtest;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		final Semaphore tickets = new Semaphore(100);
		new Kasse(tickets).start();
		new Online(tickets).start();
		new Rueckgabe(tickets).start();
	}

}
