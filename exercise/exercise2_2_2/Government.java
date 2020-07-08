/** A rather contrived exercise to test your understanding of when
    nested classes may be made static. This is NOT an example of good
    class design, even after you fix the bug.

    The challenge with this file is to delete the keyword static the
    minimum number of times so that the code compiles.

    Guess before TRYING to compile, otherwise the compiler will spoil
    the problem.*/
public class Government {
	private int treasury = 5;

	private void spend() {
		treasury -= 1;
	}

	private void tax() {
		treasury += 1;
	}

	public void report() {
		System.out.println(treasury);
	}

	public static Government greaterTreasury(Government a, Government b) {
		if (a.treasury > b.treasury) {
			return a;
		}
		return b;
	}

	public static class Peasant {
		public void doStuff() {
			System.out.println("hello");			
		}
	}

	public class King {
		public void doStuff() {
			spend();			
		}
	}

	public class Mayor {
		public void doStuff() {
			tax();			
		}
	}

	public class Accountant {
		public void doStuff() {
			report();			
		}
	}

	public class Thief {
		public void doStuff() {
			treasury = 0;			
		}
	}

	public class Explorer {
		public void doStuff(Government a, Government b) {
			Government favorite = Government.greaterTreasury(a, b);
			System.out.println("The best government has treasury " + favorite.treasury);			
		}
	}

	public static void main(String[] args) {
		Government government = new Government();
		Government government1 = new Government();

		// inner class
		Government.Mayor mayor = government.new Mayor();
		Government.Accountant accountant = government.new Accountant();
		Government.Thief thief = government.new Thief();
		Government.King king = government.new King();
		Government.Explorer explorer = government.new Explorer();
		// static nested class
		Government.Peasant peasant = new Government.Peasant();

		peasant.doStuff();

		System.out.print("Original treasury: ");
		accountant.doStuff();  // report();

		mayor.doStuff();  // tax();
		System.out.print("After mayor: ");
		accountant.doStuff();  // report();

		king.doStuff();  // tax();
		System.out.print("After king: ");
		accountant.doStuff();  // report();

		thief.doStuff();  // tax();
		System.out.print("After thief: ");
		accountant.doStuff();  // report();

		// compare two gov
		Government greaterOne = Government.greaterTreasury(government, government1);
		Government.Accountant greaterAccountant = greaterOne.new Accountant();
		greaterAccountant.doStuff();

		// explore two gov
		explorer.doStuff(government, government1);
	}
}
