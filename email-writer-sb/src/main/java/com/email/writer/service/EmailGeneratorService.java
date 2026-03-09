package com.email.writer.service;

import com.email.writer.dto.EmailRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;
//http://localhost:5173/
@Service
public class EmailGeneratorService {

    private final WebClient webClient;

    @Value("${gemini.api.url}")
    private String geminiApiUrl;

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    public EmailGeneratorService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    /**
    * @param emailRequest DTO containing the original email text and desired tone
    * @return The AI-generated email reply string, or an error message if the process fails
    */
    public String generateEmailReply(EmailRequest emailRequest){
        //Build the prompt
        String prompt = buildPrompt(emailRequest);
        //Craft a request
        Map<String,Object> requestBody = Map.of(
          "contents", new Object[]{
                  Map.of(
                          "parts",new Object[]{
                                  Map.of("text",prompt)
                          }
                  )
          }
        );
        //Do request and get response


        String response = webClient.post()
                .uri(geminiApiUrl + geminiApiKey)
                .header("Content-Type","application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        // Extract response and return
        return extractResponseContent(response);
    }

    /**
     * @param response The raw JSON string returned by the Gemini API
     * @return The extracted text content, or an error message if parsing fails
     */
    private String extractResponseContent(String response) {

        try{
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(response);
//            {
//                "candidates": [
//                {
//                    "content": {
//                    "parts": [
//                    {
//                        "text": "AI learns patterns from data."
            return rootNode
                    .path("candidates").get(0)
                    .path("content")
                    .path("parts").get(0)
                    .path("text").asText();
        } catch (Exception e) {
            return "Error processing request: " + e.getMessage();
        }
    }

    /**
     * @param emailRequest DTO containing the original email text and desired tone
     * @return A formatted string instructing the AI on how to generate the reply
     */
    private String buildPrompt(EmailRequest emailRequest) {
        StringBuilder prompt = new StringBuilder();
        prompt.append("Generate a professional email reply for the following email content. Please don't generate any subject line ");
        if(emailRequest.getTone()!=null && !emailRequest.getTone().isEmpty()){
            prompt.append("Please use a ").append(emailRequest.getTone()).append(" tone.");
        }
        prompt.append("\n Original email: \n").append(emailRequest.getEmailContent());
        return prompt.toString();
    }

}
