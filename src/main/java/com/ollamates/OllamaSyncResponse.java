package com.ollamates;

import io.github.amithkoujalgi.ollama4j.core.OllamaAPI;
import io.github.amithkoujalgi.ollama4j.core.OllamaStreamHandler;
import io.github.amithkoujalgi.ollama4j.core.exceptions.OllamaBaseException;
import io.github.amithkoujalgi.ollama4j.core.models.OllamaResult;
import io.github.amithkoujalgi.ollama4j.core.utils.OptionsBuilder;

import java.io.IOException;

public class OllamaSyncResponse {

    static final String LLAMA3 = "llama3.1";

    static final String host = "http://localhost:11434/";
    private String prompt;
    private OllamaAPI ollamaAPI;

    public OllamaSyncResponse(String prompt) {
        this.prompt = prompt;
        ollamaAPI = new OllamaAPI(host);
    }

    public String ollamaResponse() throws OllamaBaseException, IOException, InterruptedException {
        OllamaAPI ollamaAPI = new OllamaAPI(host);
        ollamaAPI.setRequestTimeoutSeconds(120);

        OllamaResult result =
                ollamaAPI.generate(LLAMA3, prompt, new OptionsBuilder().build());

        String response;
        if (result != null) {
            return result.getResponse() + "\n \uD83D\uDC50\uD83C\uDFFB";

        } else {
           return null;
        }
    }

    public void getStreamResponse(String prompt) throws OllamaBaseException, IOException, InterruptedException {

        OllamaAPI ollamaAPI = new OllamaAPI(host);

        // define a stream handler (Consumer<String>)
        OllamaStreamHandler streamHandler = (s) -> {
            System.out.println(s);
        };

        // Should be called using seperate thread to gain non blocking streaming effect.
        OllamaResult result = ollamaAPI.generate(LLAMA3,
                "What is the capital of France? And what's France's connection with Mona Lisa?",
                new OptionsBuilder().build(), streamHandler);

        System.out.println("Full response: " + result.getResponse());
    }
}

