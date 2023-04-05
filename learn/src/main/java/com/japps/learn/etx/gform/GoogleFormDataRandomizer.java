/**
 * Id: GoogleFormDataRandomizer.java 05-Apr-2023 12:35:54 pm SubhajoyLaskar
 * Copyright (©) 2023 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.etx.gform;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * The GoogleFormDataRandomizer.
 *
 * @author Subhajoy Laskar
 * @revision 1.0.
 */
public final class GoogleFormDataRandomizer {

	/**
	 * Instantiates a new google form data randomizer.
	 */
	private GoogleFormDataRandomizer() {

	}

	/** The data name. */
	private static final Set<String> DATA_NAME
	= Set.of("Ankush", "Narayan", "Ravi", "Swami", "Shiva", "Sanjukta", "Bharath", "Sindhu", "Vidya", "Hassan", "Mahesh", "Rahul", "Manjushree", "Abhinay", "Mahendhar", "Venkat The Ram Reddy Fire Boy", "Veera", "Vamshi", "Sai Keerthana", "Nagesh Kamma", "Raju", "Naresh", "Pritam");

	/** The data nickname. */
	private static final Set<String> DATA_NICKNAME
	= Set.of("Chunnu", "Munnu", "Fluffy", "Luffy", "RamReddy", "Beera White", "Priti", "Chawanprash", "Ramu", "Bunty", "Chunmun", "Nagu", "Venky", "Keerti", "Anku", "Billu", "Tiger", "Pathaan", "Aag kaa golaa", "Dracula", "Toofaan", "Mohanlaal", "Babloo", "Babli", "Badmaash", "Nautanki", "Gajbendar", "Kilobyte", "Terabyte", "Gigabyte", "Megabyte", "Petabyte");

	/** The data fav dessert. */
	private static final Set<String> DATA_FAV_DESSERT
	= Set.of("Ice cream on coke", "Meethaa paan", "Sahara desert", "Rasgullaah", "Roshogullaah", "Kaalaa jaamun", "Gulaab jaamun", "Jalebi", "Choco lava cake", "Donuts", "Choco muffin");

	/** The data 10cr todo. */
	private static final Set<String> DATA_10CR_TODO
	= Set.of("Daaru peeke talli hoyenge", "Buy a farmhouse for party every weekend", "Go on trip", "Buy a strip club", "Propose Mia Khalifa", "Invest it", "Go to Norway", "Arrange a trip to Moon", "Travelling and backpacking", "Have fun all day", "Drink beera white every hour", "Invest it to double or triple");

	/** The data alt profession. */
	private static final Set<String> DATA_ALT_PROFESSION
	= Set.of("Actor", "Actress", "Cricketer", "Footballer", "Drug peddler", "Escort", "Basketball player", "Chef", "Prime Minister of India", "Bodyguard", "Singer", "Dancer", "Plumber", "Doctor", "Teacher", "Professor", "Mathematician", "Lawyer", "Halwaai", "Farmer", "Painter");

	/** The data celeb crush. */
	private static final Set<String> DATA_CELEB_CRUSH
	= Set.of("Mia Khalifa", "Sunny Leone", "Johnny Sins", "Alexis Amore", "Anna Torv", "Swathi Naidu", "Silk Smitha", "Priyanka Chopra", "Katrina Kaif", "Hrithik", "Shahrukh", "Rajesh Khanna", "Shahid Kapoor", "Siddhart Malhotra", "Allu Arjun", "Shakti Kapoor", "Reshma", "Poonam Pandey", "Elizabeth Hurley", "Tanushree Dutta", "Riya Sen", "RamReddy The Fire Boy", "Flora Saini", "Anveshi Jain", "Sridevi");

	/** The data invention. */
	private static final Set<String> DATA_INVENTION
	= Set.of("Whiskey paan", "Herbal viagra", "Invisible condom", "Palang tod daaru", "Time machine", "Teleportation device");

	/** The data brand new name. */
	private static final Set<String> DATA_BRAND_NEW_NAME
	= Set.of("Khaitaan Pankhaa", "Hatodaa", "Kachraa bhaau", "Ultimate nasheri", "RamReddy-AagKaaGolaa", "Mishti", "Bhootni Ke", "DK Bose", "PK");

	/** The data write a book about. */
	private static final Set<String> DATA_WRITE_A_BOOK_ABOUT
	= Set.of("RamReddySutra", "KaamaSutra", "Meraa naam hai bullaa, rakhtaa hoon khullaaa", "How not to piss off while rejecting or saying no", "Ajab prem ki bahut hi gajab kahaani");

	/** The data role model. */
	private static final Set<String> DATA_ROLE_MODEL
	= Set.of("Mia Khalifa", "Sunny Leone", "Johnny Sins", "Alexis Amore", "Anna Torv", "Swathi Naidu", "Silk Smitha", "Priyanka Chopra", "Katrina Kaif", "Hrithik", "Shahrukh", "Rajesh Khanna", "Shahid Kapoor", "Siddhart Malhotra", "Allu Arjun", "Shakti Kapoor", "Reshma", "Poonam Pandey", "Elizabeth Hurley", "Tanushree Dutta", "Riya Sen", "RamReddy The Fire Boy", "Flora Saini", "Anveshi Jain", "Sridevi");

	/** The data fav actor. */
	private static final Set<String> DATA_FAV_ACTOR
	= Set.of("Anveshi Jain", "Mia Khalifa", "Sunny Leone", "Alexis Amore", "Anna Torv", "Swathi Naidu", "Silk Smitha", "Priyanka Chopra", "Katrina Kaif", "Hrithik", "Shahrukh", "Rajesh Khanna", "Shahid Kapoor", "Siddhart Malhotra", "Allu Arjun", "Shakti Kapoor", "Reshma", "Poonam Pandey", "Elizabeth Hurley", "Tanushree Dutta", "Riya Sen", "RamReddy The Fire Boy", "Flora Saini", "Sridevi");

	/** The data fav movie. */
	private static final Set<String> DATA_FAV_MOVIE
	= Set.of("Gunda", "Loha", "Zindagi 50-50", "Nasha", "Jism", "One night stand", "Kaamsutra", "RamReddySutra", "Ujra Chaman", "Bulla", "Gandi baat", "Prem rog", "Interstellar");

	/** The data fav song. */
	private static final Set<String> DATA_FAV_SONG
	= Set.of("Raat kaa nashaa", "Aashiq banaayaa aapne", "Chintuaa ke didi tauni pyaar kore dou", "Laagaabe lujab lipistick", "Ispiderman tune churaayaa mere dil kaa chain", "Joomaa chummaa de de", "Zara zara touch me touch me", "Love me like you do", "Besharam rang", "Gulaabi aankhein", "Bullaa ki jaanaa main kaun", "Jab bhi koi ladki dekhi", "Jaadu hai nashaa hai", "Aaye ho meri zindagi mein", "Chikni Chameli", "Munni Badnaam Hui");

	/** The data 3 words description. */
	private static final Set<String> DATA_3_WORDS_DESCRIPTION
	= Set.of("Aag kaa golaa", "Innocent but not really", "Cool Friendly Attractive", "Chaman baahar", "Prem pujaari", "Bihari baabu", "Babloo halwaai", "flame baby", "ujraa chaman", "Piyakkar saalaa", "PK", "Cool", "Sweet", "Beautiful", "Ande kaa fanda", "420", "Dil kaa chor", "Agile hard strong", "Naam hai beera", "Pathaan", "Tashan baby", "driller", "official don", "You describe me in 1 word", "Bullaa ki jaanaa main kaun", "Ahang brahmaasmi", "Kaamdev", "Kaminaa", "Kamini", "Baazigar", "Chaman bahaar", "Pandu", "Halkat");

	/** The data dob year. */
	private static final Set<String> DATA_DOB_YEAR
	= new HashSet<>(IntStream.rangeClosed(1900, 2023).mapToObj(Integer::toString).toList());

	/** The data dob month. */
	private static final Set<String> DATA_DOB_MONTH
	= new HashSet<>(IntStream.rangeClosed(1, 12).mapToObj(Integer::toString).toList());

	/** The data dob day. */
	private static final Set<String> DATA_DOB_DAY
	= new HashSet<>(IntStream.rangeClosed(1, 28).mapToObj(Integer::toString).toList());

	/** The form field data set map. */
	private static final Map<FormFieldType, Set<String>> FORM_FIELD_DATA_SET_MAP = new HashMap<>();

	static {
		//FORM_FIELD_DATA_SET_MAP.put(FormFieldType.NAME, DATA_NAME);
		FORM_FIELD_DATA_SET_MAP.put(FormFieldType.NICKNAME, DATA_NICKNAME);
		FORM_FIELD_DATA_SET_MAP.put(FormFieldType.FAV_DESSERT, DATA_FAV_DESSERT);
		FORM_FIELD_DATA_SET_MAP.put(FormFieldType.WHAT_YOU_WOULD_DO_WITH_10CR, DATA_10CR_TODO);
		FORM_FIELD_DATA_SET_MAP.put(FormFieldType.ALT_PROFESSION, DATA_ALT_PROFESSION);
		FORM_FIELD_DATA_SET_MAP.put(FormFieldType.CELEBRITY_CRUSH, DATA_CELEB_CRUSH);
		FORM_FIELD_DATA_SET_MAP.put(FormFieldType.INVENTION, DATA_INVENTION);
		FORM_FIELD_DATA_SET_MAP.put(FormFieldType.BRAND_NEW_NAME, DATA_BRAND_NEW_NAME);
		FORM_FIELD_DATA_SET_MAP.put(FormFieldType.WHAT_WOULD_YOU_WRITE_A_BOOK_ABOUT, DATA_WRITE_A_BOOK_ABOUT);
		FORM_FIELD_DATA_SET_MAP.put(FormFieldType.ROLE_MODEL, DATA_ROLE_MODEL);
		FORM_FIELD_DATA_SET_MAP.put(FormFieldType.FAV_ACTOR, DATA_FAV_ACTOR);
		FORM_FIELD_DATA_SET_MAP.put(FormFieldType.FAV_MOVIE, DATA_FAV_MOVIE);
		FORM_FIELD_DATA_SET_MAP.put(FormFieldType.FAV_SONG, DATA_FAV_SONG);
		FORM_FIELD_DATA_SET_MAP.put(FormFieldType.DESCRIBE_YOURSELF_3_WORDS, DATA_3_WORDS_DESCRIPTION);
		FORM_FIELD_DATA_SET_MAP.put(FormFieldType.DOB_YEAR, DATA_DOB_YEAR);
		FORM_FIELD_DATA_SET_MAP.put(FormFieldType.DOB_MONTH, DATA_DOB_MONTH);
		FORM_FIELD_DATA_SET_MAP.put(FormFieldType.DOB_DAY, DATA_DOB_DAY);
	}

	/**
	 * Data set names.
	 *
	 * @return the sets the
	 */
	public static Set<String> dataSetNames() {
		return Set.copyOf(DATA_NAME);
	}

	/**
	 * Data set.
	 *
	 * @param formFieldType the form field type
	 * @return the data set corresponding to the {@link FormFieldType}.
	 */
	private static Set<String> dataSet(final FormFieldType formFieldType) {
		return FORM_FIELD_DATA_SET_MAP.get(formFieldType);
	}

	/**
	 * Of data.
	 *
	 * @param formFieldType the form field type
	 * @return the data
	 */
	public static String ofData(final FormFieldType formFieldType) {
		final Set<String> dataSet = dataSet(formFieldType);
		return dataSet.stream().skip(new Random().nextInt(dataSet.size())).findAny().orElse("Kuch bhi ho saktaa hai re baba");
	}

}
