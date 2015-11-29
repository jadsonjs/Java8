/**
 * 
 */
package util_funcional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import method_reference.Person;

/**
 * @author jadson
 *
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 *
 */
public class TestPacoteUtilFuncional {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		/*
		 * A interface Function serve para fazer transformações.
		 * 
		 * Na opção abaixo, ela está recebendo um pessoa e restornado uma string (o nome da pessoa)
		 * 
		 * 
		 * Com isso, eu posso usa-la no método map que recebe a inteface Fuction para transforma a lista de 
		 * pessoas em uma lista de String
		 */
		Function<Person, String> f1 = p -> p.getName();
		
		Function<Person, String> f2 = Person::getName;
		
		List<Person> list = new ArrayList<>();
		list.add(new Person("Joao"));
		list.add(new Person("Maria"));
		
		Stream<String> stream = list.stream().map(f1);
		Stream<String> stream2 = list.stream().map(f2);
		
		// Agora posso imprimir a lista de string //
		stream.forEach( (String name) -> System.out.println(name));
		
		stream2.forEach( (name) -> System.out.println(name));
		
		
		
		
		/* 
		 * Resumidamente ainda posso fazer isso:
		 */
		Stream<String> stream3 = list.stream().map(Person::getName);
		
		Stream<String> stream4 = list.stream().map(p -> p.getName());
		
		stream3.forEach( (String name) -> System.out.println(name));
		
		stream4.forEach( (String name) -> System.out.println(name));
		
		
		/*
		 * Predicado, recebe um objeto e retorna um boolean 
		 */
		
		Predicate<String> p1 =  (String s) -> {return s.length() > 0;} ;
		Predicate<String> p1Resumido =  (s) -> s.length() > 0;
		
		Stream<Person> streamFilter = list.stream().filter(Person::isAnomynus);
		
		Stream<Person> streamFilter2 = list.stream().filter( (Person p ) -> p.isAnomynus());
		
		Stream<Person> streamFilter3 = list.stream().filter( p -> p.isAnomynus());
		
		
		
		
		
		/*
		 * Um consumidor: Recebe um objeto e não retorna nada
		 */
		Consumer<String> c1 =  (String s) -> {};
		
		
		/*
		 * Um produtor : Recebe nada e retorna um objeto
		 */
		Supplier<String> s1 =  () -> { return new String(""); };
		
		/*
		 * recebe 2 objetos e retorna 1
		 */
		BinaryOperator<String> b1 =  (String a, String b) -> { return a+b; };
		BinaryOperator<String> b2 =  (a, b) -> { return a+b; };
		
	}
	
}
