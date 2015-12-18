/**
 * 
 */
package time;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;

/**
 * @author jadson
 *
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 *
 */
public class TestTime {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		System.out.println( "Hora atual: "+LocalTime.now() );
		System.out.println( "Hora espec�fica: "+LocalTime.of(12, 30) );
		System.out.println( "Data atual: "+LocalDate.now() );
		System.out.println( "Data espec�fica: "+LocalDate.of(2015, 12, 30) );
		System.out.println( "Data e Hora atual: "+LocalDateTime.now() );
		System.out.println( "Data e Hora espec�fica: "+LocalDateTime.of(2015, 12, 30,12, 30) );
		
		// imut�vel, o objeto original n�o sobre altera��o
		LocalTime now = LocalTime.now();
			now.plusHours(2)
				.plusMinutes(20)
				.plusSeconds(5);
			
		// calcula o pr�ximo domingo 
			
		LocalDate nextSunday 
			= LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		
		
		
		Instant inicio = Instant.now();
		rodaAlgoritmo();
		Instant fim = Instant.now();
		 
		Duration duracao = Duration.between(inicio, fim);
		System.out.println( duracao.toMillis() );
		
		
		
		
	}

	
	
	
	/**
	 * 
	 */
	private static void rodaAlgoritmo() {
		
	}

}
