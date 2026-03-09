package com.email.writer.controller;
import com.email.writer.dto.EmailRequest;
import com.email.writer.service.EmailGeneratorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@AllArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "Email Generator API", description = "Endpoints for generating AI-powered email replies")
public class EmailGeneratorController {

    private final EmailGeneratorService emailGeneratorService;

    @Operation(
            summary = "Generate an AI email reply",
            description = "Accepts the original email content and a desired tone, and returns a generated string reply."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully generated the email reply"),
            @ApiResponse(responseCode = "400", description = "Invalid input provided in the request body"),
            @ApiResponse(responseCode = "500", description = "Internal server error (e.g., AI service generation failed)")
    })
    @PostMapping("/generate")
    public ResponseEntity<String> generateEmail(@RequestBody EmailRequest emailRequest){
        String response = emailGeneratorService.generateEmailReply(emailRequest);
        return ResponseEntity.ok(response);
    }
}
