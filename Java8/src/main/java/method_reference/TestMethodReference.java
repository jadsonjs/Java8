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
		
		/// com classe anomima
		
		print(
			new PrintFuction() {
				@Override
				public void print(Person p) {
					System.out.println(p.getName());
				}
			}
		);
		
		/// com lambda
		//print( () -> { } );
		
		/// com method reference
		print( Person::getName );
		
	}
	
	public static void print(PrintFuction p){
		
	}
	
}
