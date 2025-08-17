package ra.edu.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PostDto {
    @NotBlank(message = "Nội dung không được để trống")
    private String content;

    private MultipartFile image;
}