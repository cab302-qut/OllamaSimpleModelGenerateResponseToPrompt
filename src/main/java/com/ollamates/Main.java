package com.ollamates;

import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.models.generate.OllamaStreamHandler;
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.types.OllamaModelType;
import io.github.ollama4j.utils.Options;
import io.github.ollama4j.utils.OptionsBuilder;

import java.util.Scanner;


public class Main {




    public static void main(String[] args) {

        OllamaAPITest test = new OllamaAPITest();
        String prompt = GetUserInput();

        OllamaGenerate generateResponse = new OllamaGenerate(prompt);
        Thread thread = new Thread(generateResponse);
        thread.start();

        OllamaStreamHandler streamHandler = (s) -> {
            System.out.println(s);
        };

        try {
            Thread.sleep(10L * 1000L);
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static String GetUserInput() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter prompt for AI - ");

       return myObj.nextLine();
    }


}