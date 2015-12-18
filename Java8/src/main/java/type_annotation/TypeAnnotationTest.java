/**
 * 
 */
package type_annotation;

import java.util.ArrayList;

/**
 * @author jadson
 *
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 *
 */
public class TypeAnnotationTest {

	public static void main(String[] args) {
				
		new @NotEmpty ArrayList<String>();
		
	}
	
	public void method() throws @Critical Exception{
		
	}
	
}
