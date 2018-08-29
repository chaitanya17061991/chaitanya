package com.bucket.constants;

	public enum Fruits {

		BANANA(5),
		ORANGE(10),
		APPLE(15),
		LEMON(2),
		PEACH(20);
		
		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		private int price;

		private Fruits(int price) {
			this.price = price;
		}
		
		
		
	}

