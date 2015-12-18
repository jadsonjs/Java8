/**
 * 
 */
package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * O que é um stream?  Uma API para operações em seguencia sobre dados
 * 
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
		
		
		
		// Imprimento um lista de palavras com tamanho menor que 6 antes do Java 8
		
		for (String s : palavras) {
			if(s.length() < 6){
				System.out.println(s);
			}
		}
		
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
	  	  .filter( ( String s) -> { return s.length() < 6; }  )
	  		 .forEach( (String s) -> { System.out.println(s); } );
		
		// ou resumidamente
		
		
		palavras.stream()
	  		.filter(s -> s.length() < 6)
	  			.forEach( s -> System.out.println(s) );
		
		// ou ainda
		
		
		palavras.stream()
			.filter(s -> s.length() < 6)
				.forEach(System.out::println);
				
		
		/*
		 * Cria um stream de uma lista de nomes 
		 * Depois filtra pelo predicado as palavras que começam com "A"
		 * Depois chama o mapToINt que recebe uma Fuction,  a Fuction a gente definiu que recebe o nome n que é uma String e retorna o tamanho
		 * 
		 * Então estou convertento os nomes quem foram filtrados anteriormente em um lista de inteiros que corresponde aos repectivos tamanhos
		 * 
		 * OBS.: Todo métdo mapTo é um transformação. 
		 * 
		 * Depois to somando tudo. Sum é um "método terminal", ele não retorna outro stream.
		 */
		palavras.stream()
			.filter( n -> n.startsWith("A") )
				.mapToInt( n -> n.length()).sum();
		
		
		int soma = 0;
		
		List<Integer> tamanhos = new ArrayList<>();
		for (String n : palavras) {
			if(n.startsWith("A") ) {
				tamanhos.add(n.length());
			}
		}
		
		for (Integer t : tamanhos) {
			soma += t;
		}
		
		/*
		 * Estou tirando os valores repetidos
		 * Depois chamao o método forEach que recebem um Cosumer que recebe um valor e não retorna nada
		 * 
		 *  Então ele está recebendo uma String e está simplement imprimendo essa string 
		 */
		palavras.stream()
			.distinct()
				.forEach( System.out::println);
		
		// ou
		palavras.stream()
			.distinct()
				.forEach( s -> System.out.println(s) );
		
		// ou ainda
		palavras.stream()
			.distinct()
				.forEach( (String s) -> System.out.println(s) );	
		
	}

}
