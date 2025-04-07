package com.ollamates;

import io.github.amithkoujalgi.ollama4j.core.models.OllamaResult;


import io.github.amithkoujalgi.ollama4j.core.OllamaAPI;

import java.util.Scanner;


public class Main {


    public static void main(String[] args) {

        OllamaAPITest test = new OllamaAPITest();
        String prompt = GetUserInput();
        OllamaSyncResponse generateResponse = new OllamaSyncResponse(prompt);
        try {
            String result = generateResponse.ollamaResponse();
            System.out.println("Full response: " + result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static String GetUserInput() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter prompt for AI - ");

       return myObj.nextLine();
    }


}