package org.face.identify.yitu.vo;

import java.util.Arrays;

public class QueryImgPackageResult {
	private boolean is_valid_package;
	private String customer_defined_content;
	private String[] query_image_contents;
	private boolean is_same_person;
	private String feature_string;

	/**
	 * @return the is_valid_package
	 */
	public boolean isIs_valid_package() {
		return is_valid_package;
	}

	/**
	 * @param is_valid_package
	 *            the is_valid_package to set
	 */
	public void setIs_valid_package(boolean is_valid_package) {
		this.is_valid_package = is_valid_package;
	}

	/**
	 * @return the customer_defined_content
	 */
	public String getCustomer_defined_content() {
		return customer_defined_content;
	}

	/**
	 * @param customer_defined_content
	 *            the customer_defined_content to set
	 */
	public void setCustomer_defined_content(String customer_defined_content) {
		this.customer_defined_content = customer_defined_content;
	}

	/**
	 * @return the query_image_contents
	 */
	public String[] getQuery_image_contents() {
		return query_image_contents;
	}

	/**
	 * @param query_image_contents
	 *            the query_image_contents to set
	 */
	public void setQuery_image_contents(String[] query_image_contents) {
		this.query_image_contents = query_image_contents;
	}

	/**
	 * @return the is_same_person
	 */
	public boolean isIs_same_person() {
		return is_same_person;
	}

	/**
	 * @param is_same_person
	 *            the is_same_person to set
	 */
	public void setIs_same_person(boolean is_same_person) {
		this.is_same_person = is_same_person;
	}

	/**
	 * @return the feature_string
	 */
	public String getFeature_string() {
		return feature_string;
	}

	/**
	 * @param feature_string
	 *            the feature_string to set
	 */
	public void setFeature_string(String feature_string) {
		this.feature_string = feature_string;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QueryImgPackageResult [is_valid_package=" + is_valid_package + ", customer_defined_content="
				+ customer_defined_content + ", query_image_contents=" + Arrays.toString(query_image_contents)
				+ ", is_same_person=" + is_same_person + ", feature_string=" + feature_string + "]";
	}

}
