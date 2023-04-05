/**
 * Id: FormFieldType.java 05-Apr-2023 10:14:12 am SubhajoyLaskar
 * Copyright (©) 2023 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.etx.gform;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * The form field type.
 *
 * @author Subhajoy Laskar
 * @revision 1.0.
 */
public enum FormFieldType {

	/** The name. */
	NAME("1990482872"),

	/** The nickname. */
	NICKNAME("747531399"),

	/** The fav dessert. */
	FAV_DESSERT("2043831464"),

	/** The what you would do with 10cr. */
	WHAT_YOU_WOULD_DO_WITH_10CR("204658740"),

	/** The alt profession. */
	ALT_PROFESSION("1234149616"),

	/** The celebrity crush. */
	CELEBRITY_CRUSH("304329398"),

	/** The invention. */
	INVENTION("1042674165"),

	/** The brand new name. */
	BRAND_NEW_NAME("2122311954"),

	/** The what would you rite a book about. */
	WHAT_WOULD_YOU_WRITE_A_BOOK_ABOUT("1935721435"),

	/** The role model. */
	ROLE_MODEL("820901228"),

	/** The fav actor. */
	FAV_ACTOR("1597342054"),

	/** The fav movie. */
	FAV_MOVIE("1326250898"),

	/** The fav song. */
	FAV_SONG("310071334"),

	/** The describe yourself 3 words. */
	DESCRIBE_YOURSELF_3_WORDS("1300035437"),

	/** The dob year. */
	DOB_YEAR("1528841672_year"),

	/** The dob month. */
	DOB_MONTH("1528841672_month"),

	/** The dob day. */
	DOB_DAY("1528841672_day");

	/** The prefix form field name entry. */
	private static final String PREFIX_FORM_FIELD_NAME_ENTRY = "entry.";

	/** The form field code. */
	private String formFieldCode;

	/**
	 * Instantiates a new form field type.
	 *
	 * @param formFieldCode the form field code
	 */
	FormFieldType(final String formFieldCode) {
		this.formFieldCode = formFieldCode;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	String fieldName() {
		return name();
	}

	/**
	 * Gets the code.
	 *
	 * @return the formFieldCode
	 */
	String code() {
		return PREFIX_FORM_FIELD_NAME_ENTRY + formFieldCode;
	}

	/**
	 * Checks if is not name.
	 *
	 * @return true, if is not name
	 */
	boolean isNotName() {
		return !equals(NAME);
	}

	/**
	 * Form fields.
	 *
	 * @return the form fields.
	 */
	static Set<FormFieldType> formFields() {
		return new HashSet<>(Arrays.asList(FormFieldType.values()));
	}
}
