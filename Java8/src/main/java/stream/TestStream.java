/**
 * 
 */
package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author jadson
 *
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 *
 */
public class TestStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<String> palavras = Arrays.asList("joao", "maria", "jose", "paulo", "Nicodemos");
		
		/* Para fazer  transformações comuns em nossas coleções, contamos agora com uma nova API, o Stream.
         *
		 * Para criar um Stream com os elementos de nossa lista só precisamos chamar o método defaut .stream() presente na interface Collection
		 */ 
		@SuppressWarnings("unused")
		Stream<String> stream = palavras.stream();
		
		/*
		 * Essa API traz uma forma mais funcional de trabalhar com nossas coleções. 
		 * Ela possui diversos métodos, como o filter, map e reduce, que recebem uma interface 
		 * funcional como parâmetro, nos possibilitando tirar proveito dos novos recursos de lambda e method reference.
		 */
		
		/*
		 * O método filter recebe a interface funcional Predicate como parâmetro. 
		 * Essa interface possui apenas o método test que recebe T e retorna um boolean.
		 * 
		 *  Imprime apenas os nomes com tamanho < 6
		 */
		palavras.stream()
		  	.filter(s -> s.length() < 6)
		  		.forEach(System.out::println);
	}

}
