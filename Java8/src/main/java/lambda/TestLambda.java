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
		 * Para quem já não consegue mais se conter de emoção, aqui vai o primeiro gostinho. O uso "clássico" de lambdas vai se dar em lugares 
		 * onde normalmente você optaria por classes anônimas. Até porque, pense bem, é 
		 * exatamente nesses lugares onde o que você realmente desejaria fazer seria passar um "comportamento", e não um "estado" (objeto).
		 * 
		 * Usando uma classe anônima, como mostra o exemplo acima, é uma das maneiras preferidas dos nossos colegas de 
		 * profissão para escrever processamento de eventos. Mas percebam que nesse caso o nosso real desejo era simplesmente 
		 * passar um comportamento, a ação do botão, para o método addActionListener().
		 */
		
		JButton j1 = new JButton("JButton1");
		j1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println("JButton1 Click"+event.getID());
			}
		});
		
		/*
		 * agora temos somente a ação que realmente queríamos executar, somente o comportamento
		 * 
		 * Um lambda tem duas partes separadas pelo caracter '->'. A seção da esquerda é somente a 
		 * declaração dos parâmetros. A da direita, é como se fosse a implementação do método em si
		 * 
		 * Entradas do método -> Saída do Método
		 * 
		 */
		JButton j2 = new JButton("JButton2");
		j2.addActionListener( (event) -> System.out.println("JButton2 Click"+event.getID()) );
		
		
		
		
		
		
		List<String> palavras = Arrays.asList("joao", "maria", "jose", "paulo");
		
		
		/*
		 * Queremos ordená-la de acordo com o tamanho de cada String. Para isso criamos um Comparator através de uma classe anônima
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
		 * podemos também criar o Comparator de maneira bem mais enxuta sem utilizar a sintaxe de classe anônima
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
