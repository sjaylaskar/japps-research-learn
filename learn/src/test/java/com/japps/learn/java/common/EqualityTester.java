/**
 * Id: EqualityTester.java 14-Sep-2023 6:03:53 am SubhajoyLaskar
 * Copyright (©) 2023 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.java.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

/**
 * The EqualityTester.
 *
 * @author Subhajoy Laskar
 * @revision 1.0.
 */
public final class EqualityTester {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {

		final String s = null;
		System.out.println(s + "8");

		final Person<String> p1 = new Person<>("P1", 1);
		final Person<Integer> p2 = new Person<>(2, 2);
		final Person<Integer> p3 = new Person<>(2, 2);
		final Person<Boolean> p4 = new Person<>(null, 2);

		final List<Person<?>> persons = List.of(p1, p2, p3, p4);

		final LinkedHashSet<Person<?>> uniquePersons = new LinkedHashSet<>(persons);
		System.out.println(new ArrayList<>(uniquePersons));

		System.out.println(persons.stream().distinct().toList());
	}

}

class Person<T extends Serializable> {

	private final T value;

	private final int id;

	/**
	 * @param value
	 * @param id
	 */
	public Person(final T value, final int id) {
		this.value = value;
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, value);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if ((obj == null) || (getClass() != obj.getClass())) {
			return false;
		}
		final Person other = (Person) obj;
		return (id == other.id) && Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return "Person [value=" + value + ", id=" + id + "]";
	}


}