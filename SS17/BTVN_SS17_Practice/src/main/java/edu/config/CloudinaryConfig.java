package edu.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dozp81qxt",
                "api_key", "371483629781264",
                "api_secret", "z3kqKzaOuV3MOPGlPp2grvzEQ_w",
                "secure_url", true
        ));
    }
}
