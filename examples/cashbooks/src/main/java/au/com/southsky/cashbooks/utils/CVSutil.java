package au.com.southsky.cashbooks.utils;

import java.util.ArrayList;
import java.util.List;

import cashbooks.Customer.EventNewCustomer;

public class CVSutil {

	public static List<String> parse(String csv) {
		ArrayList<String> fields = new ArrayList<String>();

		String[] values = csv.split(",");

		String token = null;

		for (String value : values) {
			if (value.startsWith("\"")) {
				String[] tokens = value.split("\"");
				token = tokens[1];
			} else {
				token = value;
			}
			fields.add(token);
		}

		return fields;
	}
}
