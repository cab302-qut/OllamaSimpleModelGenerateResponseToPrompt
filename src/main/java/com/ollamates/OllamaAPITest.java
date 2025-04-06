package com.ollamates;

import io.github.ollama4j.OllamaAPI;

public class OllamaAPITest {


        private static final String HOST = "http://localhost:11434/";

        public OllamaAPITest() {
            OllamaAPI ollamaAPI = new OllamaAPI(HOST);

        boolean ollamaOnLine = ollamaAPI.ping();
        if (ollamaOnLine) {
            System.out.println("The Ollama Server is running: ");
        } else {
            System.out.println("The Ollama Server is currently not available ");
        }
    }
}