/*
 * Copyright (c) 2018 Jadson Santos
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * ConcurrencyExecutorsTest.java 
 * 2 de jun de 2018
 */
package concurrency_api;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Himani Arora
 * https://dzone.com/articles/guide-to-java-8-concurrency-using-executors?edition=376338&utm_source=Weekly%20Digest&utm_medium=email&utm_campaign=Weekly%20Digest%202018-05-30
 * 
 */
public class ConcurrencyExecutorsTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		/** Executors are capable of managing a pool of threads, 
		 * so we do not have to manually create new threads and run tasks in an asynchronous fashion. 
		 * 
		 * ExecutorService executorService1 = Executors.newSingleThreadExecutor();
		 * ExecutorService executorService2 = Executors.newFixedThreadPool(5);
		 */
		
		
		/**
		 * few of the different ways that can be used to delegate tasks for execution to an ExecutorService
		 * 
		 * execute(Runnable command)
		 * submit(Callable task)
		 * submit(Runnable task)
		 * invokeAny(Collection<? extends Callable<T>> tasks)
		 * invokeAll(Collection<? extends Callable<T>> tasks)
		 */
		
		/** execute(Runnable Command)
		 * This method takes a java.lang.Runnable object and executes it asynchronously.
		 */
		
		ExecutorService executor2 = Executors.newSingleThreadExecutor();
		executor2.execute(() -> {
		    String threadName = Thread.currentThread().getName();
		    System.out.println("Hello " + threadName);
		});
		
		
		/** submit(Callable Task) and submit(Runnable Task)
		 * The submit(Runnable task) method takes a Runnable implementation and returns a Future object, which can be used to check if the Runnable as finished executing.
		 */

		Runnable task=()-> {
		   System.out.println("runnable task");
		};
		 
		ExecutorService executor3 = Executors.newSingleThreadExecutor();
		Future<?> future =    executor3.submit( task );
		System.out.println("value - "+future.get()); // returns null
		
		
		/** 
		 * Callables are functional interfaces, but unlike Runnable, they return a value. 
		 * A submit(callable task) method takes a Callable implementation
		 */

		Callable<String> task4 = () -> " task 1 ";
		ExecutorService executor4= Executors.newSingleThreadExecutor();
		Future<String> future4 = executor4.submit(task4);
		System.out.println("value - "+future4.get()); //returns task 1
		
		
		
		/** invokeAll(Collection<? extends Callable<T>> tasks)
		 * This method supports batch submitting of multiple callables at once. 
		 * It accepts a collection of callables and returns a list of futures.
		 */

		ExecutorService executor5 = Executors.newFixedThreadPool(1);
		 
		List<Callable<String>> callables = Arrays.asList(
		        () -> "t1",
		        () -> "t2"
		);
		 
		executor5.invokeAll(callables)
		    .stream()
		    .map(future5 -> {
		        try {
		            return future5.get();
		        }
		        catch (Exception e) {
		            throw new IllegalStateException(e);
		        }
		    })
		    .forEach(System.out::println);

		
		
		/**
		 * This method works slightly differently than invokeAll(). 
		 * Instead of returning future objects, 
		 * it blocks until the first callable terminates and returns the result of that callable.
		 */

		ExecutorService executor6 = Executors.newWorkStealingPool();
		 
		List<Callable<String>> callables6 = Arrays.asList(
		       () -> "task 1 completed",
		       () -> "task 2 completed",
		       () -> "task 3 completed",
		       () -> "task 4 completed",
		       () -> "task 5 completed"
		);
		
	    String returnValue = executor6.invokeAny(callables6);
	    System.out.println(returnValue); 
		       

	}
	
	
}
