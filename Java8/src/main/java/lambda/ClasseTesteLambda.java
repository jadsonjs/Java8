/**
 * 
 */
package lambda;

import functional_interface.MyInterface;

/**
 * @author jadson
 *
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 *
 */
public class ClasseTesteLambda {
	
	public void fazAlgo(MyInterface myIterface){
		myIterface.action();
	}
	
	public static void main(String[] args) {
		
	
		// Classe normal
		ClasseTesteLambda c1 = new ClasseTesteLambda();
		c1.fazAlgo(new MyClass());
		
		
		
		//Classe anônima
		ClasseTesteLambda c2 = new ClasseTesteLambda();
		c2.fazAlgo(new MyInterface() {
			@Override
			public void action() {
				System.out.println("Executando método action");
			}
		});
		
		
		//Com Lambda
		ClasseTesteLambda c3 = new ClasseTesteLambda();
		c3.fazAlgo( () -> { System.out.println("Executando método action"); } );
		
		
		
		// ou ainda
		c3.fazAlgo( () -> System.out.println("Executando método action")  );
		
		
		// em 1 linha
		new ClasseTesteLambda().fazAlgo( () -> { System.out.println("Executando método action"); }  );
		
	}

}

class MyClass implements MyInterface{

	@Override
	public void action() {
		System.out.println("Executando método action");
	}
	
}

