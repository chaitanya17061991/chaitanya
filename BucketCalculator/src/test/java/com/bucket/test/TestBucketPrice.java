package com.bucket.test;
import org.junit.Assert;
import org.junit.Test;

import com.bucket.application.BucketPrice;
import com.bucket.constants.Fruits;



public class TestBucketPrice {

	@Test
	public void testBucketPriceForEmptyBucket() {
        Fruits[] bucket = {};
		BucketPrice bucketPrice = new BucketPrice();
		int price = bucketPrice.getPrice(bucket);
		Assert.assertEquals(0, price);
		
	}
	@Test
	public void testBucketPriceForNonEmptyBucket() {
        Fruits[] bucket = {Fruits.APPLE,Fruits.ORANGE,Fruits.BANANA,Fruits.APPLE,Fruits.LEMON,Fruits.PEACH};
		BucketPrice bucketPrice = new BucketPrice();
		int price = bucketPrice.getPrice(bucket);
		Assert.assertEquals(67, price);
		
	}
	@Test
	public void testBucketPriceBySettingItemPrices() {
		Fruits.APPLE.setPrice(5);
		Fruits.ORANGE.setPrice(10);
		Fruits.BANANA.setPrice(10);
		Fruits.LEMON.setPrice(1);
		Fruits.PEACH.setPrice(3);
		Fruits[] bucket = {Fruits.APPLE,Fruits.ORANGE,Fruits.BANANA,Fruits.APPLE,Fruits.LEMON,Fruits.PEACH};
		BucketPrice bucketPrice = new BucketPrice();
		int price = bucketPrice.getPrice(bucket);
		Assert.assertEquals(34, price);
		
	}
	
}
