package com.java17.virtual_assisstant;


import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;
import java.io.IOException;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      Configuration config= new Configuration();
      config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
      config.setDictionaryPath("src\\main\\resources\\6351.dic");
		config.setLanguageModelPath("src\\main\\resources\\6351.lm");
		
		try {
			LiveSpeechRecognizer speech = new LiveSpeechRecognizer(config);
			speech.startRecognition(true);
			
			SpeechResult speechResult = null;
			
			while ((speechResult = speech.getResult()) != null) {
				String voiceCommand = speechResult.getHypothesis();
				System.out.println("Voice Command is " + voiceCommand);
				
				if (voiceCommand.equalsIgnoreCase("Open firefox")) {
					Runtime.getRuntime().exec("cmd.exe /c start firefox ");
				} else if (voiceCommand.equalsIgnoreCase("Close firefox")) {
					Runtime.getRuntime().exec("cmd.exe /c taskkill /IM firefox.exe /F");
				}else if(voiceCommand.toLowerCase().equals("open youtube")){
					URI uri=null;
					try {
						uri = new URI("https://www.youtube.com");
					} catch (URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Desktop.getDesktop().browse(uri);
				}else if(voiceCommand.toLowerCase().equals("open instagram")){
					URI uri=null;
					try {
						uri = new URI("https://www.instagram.com/");
					} catch (URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Desktop.getDesktop().browse(uri);
				}else if(voiceCommand.toLowerCase().equals("show weather")){
					URI uri=null;
					try {
						uri = new URI("https://www.windy.com/");
					} catch (URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Desktop.getDesktop().browse(uri);
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
