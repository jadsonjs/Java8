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
public class Person {

	private String name;

	/**
	 * @param string
	 */
	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public boolean isAnomynus() {
		return name == null;
	}
	
}
