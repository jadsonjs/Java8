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
		
		print(new Person("Anonymous Class"), new PrintFuction() {
				@Override
				public String print(Person p) {
					return p.getName();
				}
		});
		
		
		// com lambda
		
		print(new Person("Lambda"),  (p) -> { return p.getName(); });
		print(new Person("Lambda"),  (p) -> p.getName() );
		
		/// com method reference
		
		
		print(new Person("Method Reference"), Person::getName);
		
	}
	
	public static void print(Person p, PrintFuction fuction){
		System.out.println(fuction.print(p));
	}
	
	
	
}
