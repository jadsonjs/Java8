/**
 * 
 */
package functional_interface;

import java.util.Collections;
import java.util.List;

/**
 * @author jadson
 *
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 *
 */
/*
 * Uma interface funcional é aquela que possui apenas um método abstrato.
 */
@FunctionalInterface
public interface MyInteface {

	public void action();
	
	/*
	 * Podemos ter métodos concretos em interfaces a partir do Java 8.
	 * Basta utilizar o modificador default. Eles serão "herdados" por todos que implementarem essa interface. 
	 * Esse recurso, chamado default method, permite evoluir uma interface sem quebrar compatibilidade. 
	 */
	default void sort(List<Integer> c) {
	    Collections.sort(c);
	}
	
}
