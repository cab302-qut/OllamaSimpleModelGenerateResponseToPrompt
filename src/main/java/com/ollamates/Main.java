package com.ollamates;

import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.types.OllamaModelType;
import io.github.ollama4j.utils.OptionsBuilder;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final String API_LOCATION = "http://localhost:11434/";

    public static void main(String[] args) {

        OllamaAPI ollamaAPI = new OllamaAPI(API_LOCATION);

        OllamaResult result =
                ollamaAPI.generate(OllamaModelType.LLAMA2, "Who are you?", new OptionsBuilder().build());

        System.out.println(result.getResponse());
    }
}