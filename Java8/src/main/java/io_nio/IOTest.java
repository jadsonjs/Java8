/**
 * 
 */
package io_nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author jadson
 *
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 *
 */
public class IOTest {
	
	public static void readStreamOfLinesUsingFilesWithTryBlock() throws IOException{
	    
		// filtra as linha que possua a palavra password e imprime
		
		Path path = Paths.get("c:/temp", "data.txt");
	    
	    Files.lines(path)
	    	.filter( line -> line.contains("password") )
	    		.sorted()
	    			.forEach( line -> System.out.println(line) );
	}
	

}
