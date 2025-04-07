package com.ollamates;
import java.util.Scanner;


public class Main {

    /**
     * Test driver for Ollama Generate Sync - This API lets you ask questions to the LLMs in a synchronous way.
     * This API corresponds to the completion API.     *
     * Use the OptionBuilder to build the Options object with extra parameters.
     *
     */

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

    /**
     * Helper method for user input used as prompt
     * @return String prompt to LLM
     */
    private static String GetUserInput() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter prompt for AI - ");

       return myObj.nextLine();
    }


}