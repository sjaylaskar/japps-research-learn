/**
 * Id: RandomizedGoogleFormSubmitter.java 05-Apr-2023 12:35:57 am SubhajoyLaskar
 * Copyright (©) 2023 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.etx;

import java.time.Duration;
import java.time.LocalDate;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.japps.learn.util.LogUtil;
import com.japps.learn.util.Loggable;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Form;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * The randomized google form submitter.
 *
 * @author Subhajoy Laskar
 * @revision 1.0.
 */
public final class RandomizedGoogleFormSubmitter implements Loggable {

	/** The log. */
	private static final LogUtil LOG = LogUtil.newInstance(RandomizedGoogleFormSubmitter.class);

	/** The form id. */
	private static final String FORM_ID = "1FAIpQLSd0qXEK0RrY200A7zXuFLwAIThRoS7IqMBpdK94ypJHyzr-_Q";

	/** The base form url. */
	private static final String BASE_FORM_URL = "https://docs.google.com/forms/d/e/" + FORM_ID + "/formResponse";

	/** The base answer. */
	private static final String BASE_ANSWER = "Ram Reddy The Fire Boy";

	/** The base dob. */
	private static final LocalDate BASE_DOB = LocalDate.of(0001, 1, 1);

	/** The start request count. */
	private static final int START_REQUEST_COUNT = 1;

	/** The end request count. */
	private static final int END_REQUEST_COUNT = 10000;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {

		try {
			LOG.info("Start form submission now...");
			for (int requestCount = START_REQUEST_COUNT; requestCount <= END_REQUEST_COUNT; requestCount++) {
				try {
					final Response response = sendRequest(requestCount);
					LOG.info("Request count: " + requestCount + ", Response: " + response + ", Response status: " + response.getStatus());
				} catch (final Exception exception) {
					LOG.error("Request count: " + requestCount + ", Error: " + ExceptionUtils.getStackTrace(exception));
				} finally {
					Thread.sleep(Duration.ofMillis(2000));
				}
			}
		} catch (final Exception exception) {
			LOG.error(ExceptionUtils.getStackTrace(exception));
		} finally {
			LOG.info("End form submission now...");
		}
	}

	/**
	 * Send request.
	 *
	 * @param requestCount the request count
	 * @return the string
	 */
	private static Response sendRequest(final int requestCount) {
		final String url = BASE_FORM_URL;

		final Client client = ClientBuilder.newClient();
		final WebTarget webTarget = client.target(url);

		return webTarget.request(MediaType.APPLICATION_FORM_URLENCODED)
				.accept("text/html", "application/xhtml+xml", "application/xml", "image/avif", "image/webp",
						"image/apng", "*/*", "application/signed-exchange")
				.acceptEncoding("gzip", "deflate", "br").acceptLanguage("en-US", "en")
				.header("Connection", "keep-alive").header("Content-Type", MediaType.APPLICATION_FORM_URLENCODED)
				.header("Referer", "https://docs.google.com/forms/d/e/" + FORM_ID + "/viewform")
				.header("cookie",
						"S=spreadsheet_forms=ubiD997xDewVLMVpQQcuK9DtlCXZji4BabFrLylHX5Y; COMPASS=spreadsheet_forms=CjIACWuJV165zyNDPBgx1gbr3qgWO-L7TQHYrmDmAecUzIqfsDi0FSl5UzRwvEWpOqcpehCx4rGhBho0AAlriVdNk8pSc3M00Cf3U8rV9Y6ecC1Pvw4bu3ww2O0BVzxIc4N_rMaTOheG9Cs1PEXAGg==; AEC=AUEFqZeoAuaGAJONuookl7y0PYezy6XcwHukeaJxrNb9QgwZpqzMcjPVrg; NID=511=Inl2TNDWeB0UWbRMv9MN_2vu2NDUxT5I_oWWx4rdffuRax_7XOtu7BQDtvJy4UGuaxOhLn6ScsGZsyruFQK-lJHBMjrt8e6w90mubeY_SqMxxDq8PG7TDAfRhT-R2vQJP8XAasygA7P1ROGVhVVuA7_IpCfonmYz4hGZN0LVpr0; 1P_JAR=2023-04-04-17")
				.header("user-agent",
						"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36")
				.post(Entity.form(generatePayload(requestCount)));
	}

	/**
	 * Generate payload.
	 *
	 * @param requestCount the request count
	 * @return the payload.
	 */
	private static Form generatePayload(final int requestCount) {
		final String answer = BASE_ANSWER + requestCount;
		final LocalDate dob = BASE_DOB.plusYears(requestCount - 1);

		return new Form()
				.param("entry.1990482872", answer)
				.param("entry.747531399", answer)
				.param("entry.2043831464", answer)
				.param("entry.204658740", answer)
				.param("entry.1234149616", answer)
				.param("entry.304329398", answer)
				.param("entry.1042674165", answer)
				.param("entry.2122311954", answer)
				.param("entry.1935721435", answer)
				.param("entry.820901228", answer)
				.param("entry.1597342054", answer)
				.param("entry.1326250898", answer)
				.param("entry.310071334", answer)
				.param("entry.1300035437", answer)
				.param("entry.1528841672_year", String.valueOf(dob.getYear()))
				.param("entry.1528841672_month", String.valueOf(dob.getMonthValue()))
				.param("entry.1528841672_day", String.valueOf(dob.getDayOfMonth()));
	}

}
