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
 * Programa��o Reativa. Esse paradigma pode ser visto como sendo a cria��o de aplica��es baseadas em eventos (ou mensagens) 
 * e totalmente ass�ncrona, sem bloqueios,
 *
 *
 * Devido � natureza das linguagens funcionais, que evitam estados mut�veis e facilitam a cria��o de aplica��es 
 * concorrentes, o casamento entre o paradigma funcional e reativo � o caminho natural para a cria��o de aplica��es 
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

		// representar o resultado de uma computa��o ass�ncrona futura.
		Future<String> future = commonPool.submit(task);
		System.out.print("resultado: " + future.get());
		
		commonPool.shutdown();
		
		
		// Nesse exemplo criamos uma CompletableFuture na linha 6, e repare que n�o definimos nenhum trecho de 
		// c�digo para ele executar, ou seja, podemos definir isso como sendo literalmente uma "promessa vazia".

	
		// O m�todo thenAccept recebe uma interface Consumer, ou seja, podemos passar uma fun��o lambda que recebe 
		// um argumento e n�o devolve resultado. No nosso caso, definimos str -> System.out.println(str). 
		//
		// Essa fun��o lambda � o callback que ser� chamado quando CompletableFuture terminar seu processamento. 
		// No caso, n�o definimos nada para a CompletableFuture fazer, logo, thenAccept nunca ser� executada.

		// Uma das formas de se definir um valor � atrav�s do m�todo complete, que recebe um par�metro T

		// Veja que a �nica novidade � o m�todo complete, que define um valor para c1, com isso, o m�todo thenAccept ser� chamado.

				
		CompletableFuture<String> c1 = new CompletableFuture<>();
		
		// pode ser completado, ou seja, executa alguma coisa se n�o 
		// terminou dentro do tempo determinado
		// Futures n�o perminiam se completados
		c1.complete(" CompletableFuture complete ");
		
		c1.thenAccept(str -> System.out.println(str));

		Thread.sleep(1000);
		
		

        
		CompletableFuture
    	
		// c�digo usamos supplyAsync para executar um lambda (do tipo Supplier)
    	// Supply: consumidor, recebe na da e retorna um valor
    	.supplyAsync( ()->getValor() )
    	
    		// deseja executar uma opera��o num CompletableFuture ap�s ele ter sido processado. 
	    	// Por exemplo, dado um CompletableFuture que retorna um valor Integer, queremos multiplicar esse valor por 2
    		.thenCompose(i -> CompletableFuture.supplyAsync(()->i*2))
    		
    		// Podemos usar tamb�m o m�todo thenApply, que equivale ao conhecido m�todo map() das linguagens funcionais, 
    		// que aplica uma transforma��o simples atrav�s de uma fun��o lambda.
    		.thenApply(i -> String.valueOf(i))
    		
    		    // Imagine que a thread lance uma exce��o. Podemos usar os m�todos exceptionally para manipular essa situa��o
    			.exceptionally(ex -> {
    				System.out.println("Erro = " + ex.getMessage());
    				return "Erro";
    			})
    			
    			     // Essa fun��o lambda � o callback que ser� chamado quando CompletableFuture terminar seu processamento.
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
