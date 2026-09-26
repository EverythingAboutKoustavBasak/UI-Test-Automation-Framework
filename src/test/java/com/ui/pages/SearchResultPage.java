package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class SearchResultPage extends BrowserUtility {

	private static final By PRODUCT_LISTING_TITLE_LOCATOR = By.xpath("//span[@class='lighter']");
	private static final By ALL_PRODUCT_LISTS_NAME_LOCATOR = By
			.xpath("//ul[@id = \"product_list\"]//h5[@itemprop=\"name\"]");

	public SearchResultPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String getSearchResultTitle() {
		return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
	}

	public boolean isSearchTermPresentInProductList(String searchTerm) {

		// Split the search term into individual keywords.
		// Example: "X Y Z A B" → ["x", "y", "z", "a", "b"]
		List<String> keywords = Arrays.asList(searchTerm.toLowerCase().split(" "));

		// Get all visible product names from the product listing.
		List<String> productNamesList = getAllVisibleText(ALL_PRODUCT_LISTS_NAME_LOCATOR);

		// Check every product.
		for (String productName : productNamesList) {

			// Assume the current product has not matched any keyword yet.
			boolean productMatched = false;

			// Check the current product against every keyword.
			for (String keyword : keywords) {

				// If the product contains ANY ONE keyword,
				// the current product is considered valid.
				if (productName.toLowerCase().contains(keyword)) {
					productMatched = true;

					// One matching keyword is enough,
					// so no need to check the remaining keywords.
					break;
				}
			}

			// If NONE of the keywords matched the current product,
			// the product is invalid and the complete validation fails.
			if (!productMatched) {
				return false;
			}
		}

		// Every product contained at least one keyword.
		return true;

	}

}