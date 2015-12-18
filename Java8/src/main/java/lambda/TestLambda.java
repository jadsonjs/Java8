/**
 * 
 */
package lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JButton;

/**
 * @author jadson
 *
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 *
 */
public class TestLambda {

	public void main(){
		
		/*
		 * Para quem j� n�o consegue mais se conter de emo��o, aqui vai o primeiro gostinho. O uso "cl�ssico" de lambdas vai se dar em lugares 
		 * onde normalmente voc� optaria por classes an�nimas. At� porque, pense bem, � 
		 * exatamente nesses lugares onde o que voc� realmente desejaria fazer seria passar um "comportamento", e n�o um "estado" (objeto).
		 * 
		 * Usando uma classe an�nima, como mostra o exemplo acima, � uma das maneiras preferidas dos nossos colegas de 
		 * profiss�o para escrever processamento de eventos. Mas percebam que nesse caso o nosso real desejo era simplesmente 
		 * passar um comportamento, a a��o do bot�o, para o m�todo addActionListener().
		 */
		
		JButton j1 = new JButton("JButton1");
		j1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println("JButton1 Click"+event.getID());
			}
		});
		
		/*
		 * agora temos somente a a��o que realmente quer�amos executar, somente o comportamento
		 * 
		 * Um lambda tem duas partes separadas pelo caracter '->'. A se��o da esquerda � somente a 
		 * declara��o dos par�metros. A da direita, � como se fosse a implementa��o do m�todo em si
		 * 
		 * Entradas do m�todo -> Sa�da do M�todo
		 * 
		 */
		JButton j2 = new JButton("JButton2");
		j2.addActionListener( (event) -> System.out.println("JButton2 Click"+event.getID()) );
		
		
		
		
		
		
		List<String> palavras = Arrays.asList("joao", "maria", "jose", "paulo");
		
		
		/*
		 * Queremos orden�-la de acordo com o tamanho de cada String. Para isso criamos um Comparator atrav�s de uma classe an�nima
		 */
		
		Comparator<String> comparador = new Comparator<String>() {
			 @Override
			public int compare(String s1, String s2) {
			    return Integer.compare(s1.length(), s2.length()); 
			}
		};
		
		Collections.sort(palavras, comparador);
		
		
		
		Collections.sort(palavras, new Comparator<String>() {
			 @Override
			public int compare(String s1, String s2) {
			    return Integer.compare(s1.length(), s2.length()); 
			}
		});
		
		
		/*
		 * podemos tamb�m criar o Comparator de maneira bem mais enxuta sem utilizar a sintaxe de classe an�nima
		 * 
		 */
		Comparator<String> comparadorLambda  = (s1, s2 )->  Integer.compare(s1.length(), s2.length());
		
		Collections.sort(palavras, comparadorLambda);
		
		/*
		 * Ou ainda passar tudo isso diretamente como argumento para o sort
		 */
		
		Collections.sort(palavras, (String s1, String s2 ) 
				->  { return Integer.compare(s1.length(), s2.length());} );
		
		Collections.sort(palavras, (s1, s2 ) ->  Integer.compare(s1.length(), s2.length()));
		
	}
}
