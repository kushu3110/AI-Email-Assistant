package com.email.writer.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data@Schema(
        name = "EmailRequest",
        description = "Payload containing the original email content and the desired tone for the generated reply"
)
public class EmailRequest {

    @Schema(
            description = "The original text content of the email you want to reply to",
            example = "Hi team, could you please send over the latest Q3 report?",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String emailContent;

    @Schema(
            description = "The desired tone for the AI-generated reply. Leave empty for a default tone.",
            example = "professional",
            allowableValues = {"professional", "casual", "friendly", ""}
    )
    private String tone;
}
