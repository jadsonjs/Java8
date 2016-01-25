/**
 * 
 */
package concurrency_api;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 
 * Programação Reativa. Esse paradigma pode ser visto como sendo a criação de aplicações baseadas em eventos (ou mensagens) 
 * e totalmente assíncrona, sem bloqueios,
 *
 *
 * Devido à natureza das linguagens funcionais, que evitam estados mutáveis e facilitam a criação de aplicações 
 * concorrentes, o casamento entre o paradigma funcional e reativo é o caminho natural para a criação de aplicações 
 * reativas altamente responsivas
 *
 *
 *
 * 
 * @author jadson
 *
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 * 
 * Leia mais em: Trabalhando com CompletableFuture no Java 
 * http://www.devmedia.com.br/trabalhando-com-completablefuture-no-java/32854#ixzz3yCtvtiQC
 *
 */
public class ConcurrencyTest {

	/**
	 * @param args
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		/** A common and static pool */
		ForkJoinPool commonPool = ForkJoinPool.commonPool();
		
		
		
		Callable<String> task = () -> {
		    try {
		        TimeUnit.SECONDS.sleep(1);
		        return "terminou : "+Thread.currentThread().getName();
		    }
		    catch (InterruptedException e) {
		        throw new IllegalStateException("task interrupted", e);
		    }
		};

		// representar o resultado de uma computação assíncrona futura.
		Future<String> future = commonPool.submit(task);
		System.out.print("resultado: " + future.get());
		
		commonPool.shutdown();
		
		
		// Nesse exemplo criamos uma CompletableFuture na linha 6, e repare que não definimos nenhum trecho de 
		// código para ele executar, ou seja, podemos definir isso como sendo literalmente uma "promessa vazia".

	
		// O método thenAccept recebe uma interface Consumer, ou seja, podemos passar uma função lambda que recebe 
		// um argumento e não devolve resultado. No nosso caso, definimos str -> System.out.println(str). 
		//
		// Essa função lambda é o callback que será chamado quando CompletableFuture terminar seu processamento. 
		// No caso, não definimos nada para a CompletableFuture fazer, logo, thenAccept nunca será executada.

		// Uma das formas de se definir um valor é através do método complete, que recebe um parâmetro T

		// Veja que a única novidade é o método complete, que define um valor para c1, com isso, o método thenAccept será chamado.

				
		CompletableFuture<String> c1 = new CompletableFuture<>();
		
		// pode ser completado, ou seja, executa alguma coisa se não 
		// terminou dentro do tempo determinado
		// Futures não perminiam se completados
		c1.complete(" CompletableFuture complete ");
		
		c1.thenAccept(str -> System.out.println(str));

		Thread.sleep(1000);
		
		

        
		CompletableFuture
    	
		// código usamos supplyAsync para executar um lambda (do tipo Supplier)
    	// Supply: consumidor, recebe na da e retorna um valor
    	.supplyAsync( ()->getValor() )
    	
    		// deseja executar uma operação num CompletableFuture após ele ter sido processado. 
	    	// Por exemplo, dado um CompletableFuture que retorna um valor Integer, queremos multiplicar esse valor por 2
    		.thenCompose(i -> CompletableFuture.supplyAsync(()->i*2))
    		
    		// Podemos usar também o método thenApply, que equivale ao conhecido método map() das linguagens funcionais, 
    		// que aplica uma transformação simples através de uma função lambda.
    		.thenApply(i -> String.valueOf(i))
    		
    		    // Imagine que a thread lance uma exceção. Podemos usar os métodos exceptionally para manipular essa situação
    			.exceptionally(ex -> {
    				System.out.println("Erro = " + ex.getMessage());
    				return "Erro";
    			})
    			
    			     // Essa função lambda é o callback que será chamado quando CompletableFuture terminar seu processamento.
    				.thenAccept(str -> System.out.println("String = " + str));
		

		Thread.sleep(1000);

	}

	/**
	 * @return
	 */
	private static Integer getValor() {
		return 10;
	}

}
