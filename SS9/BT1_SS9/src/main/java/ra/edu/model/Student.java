package ra.edu.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private int age;
    private String studentClass;
    private String email;
    private String address;
    private String phone;
}
