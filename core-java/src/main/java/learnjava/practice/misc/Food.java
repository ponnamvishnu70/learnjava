package learnjava.practice.misc;

public enum Food {
	
	CHICKEN{
		public void eating() {
			System.out.println("Eating chicken");
		}
		public void eatingSeaFood() {
			System.out.println("No ....This is Not SEA food");
		}
	},FISH{
		public void eatingSeaFood() {
			System.out.println("Eating Fish");			
		}
	},SHRIMP{
	
	public void eatingSeaFood() {
			System.out.println("Eating Shrimp");			
		}
	};
	 public abstract void eatingSeaFood() ;
	 public  void eating() {
		 System.out.println("Not Eating");
	 }

}
