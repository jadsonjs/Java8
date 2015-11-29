/**
 * 
 */
package method_reference;

/**
 * @author jadson
 *
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 *
 */
public class TestMethodReference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/// com classe anonima
		print(
			new PrintFuction() {
				@Override
				public void print(Person p) {
					System.out.println(p.getName());
				}
			}
		, new Person("Anonymous Inner Class") );
		
		// com lambda
		print( (p) -> { System.out.println(p.getName());}, new Person("Lamdda") );
		
		/// com method reference ???
		print( Person::getName, new Person("Method Reference") );
		
	}
	
	public static void print(PrintFuction pf, Person p){
		pf.print(p);
	}
	
}
