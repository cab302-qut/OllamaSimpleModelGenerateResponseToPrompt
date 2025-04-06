package com.ollamates;

import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.types.OllamaModelType;
import io.github.ollama4j.utils.Options;
import io.github.ollama4j.utils.OptionsBuilder;

public class OllamaGenerate implements Runnable{

    private static final String HOST = "http://localhost:11434/";

    private OllamaAPI ollamaAPI;
    private String prompt;
    @Override
    public void run() {
        try {
            OllamaResult result = ollamaAPI.generate(OllamaModelType.LLAMA3_1,
                    this.prompt,
                    false, BuildOptions());
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public OllamaGenerate(String prompt) {
        this.ollamaAPI = new OllamaAPI(HOST);
        this.prompt = prompt;
    }

    private static Options BuildOptions() {
        return  new OptionsBuilder()
                .setMirostat(10)
                .setMirostatEta(0.5f)
                .setNumGpu(2)
                .setTemperature(1.5f)
                .build();
    }


    public String getPrompt() {
        return this.prompt;
    }

    public void setPrompt(String s) {
        this.prompt = s;
    }
}
