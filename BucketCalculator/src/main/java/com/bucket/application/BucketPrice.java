package com.bucket.application;

import com.bucket.constants.Fruits;

public class BucketPrice {

	public int getPrice(Fruits[] bucket) {
		int finalBucketPrice = 0;
		for (Fruits fruit : bucket) {
			finalBucketPrice = finalBucketPrice + fruit.getPrice();
		}
		return finalBucketPrice;
	}
}
