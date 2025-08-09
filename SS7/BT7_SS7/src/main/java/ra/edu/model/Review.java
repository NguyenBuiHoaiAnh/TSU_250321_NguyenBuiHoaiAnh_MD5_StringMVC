package ra.edu.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // tự sinh getter/setter, toString, equals, hashCode
@AllArgsConstructor // tự sinh constructor có tham số
@NoArgsConstructor  // tự sinh constructor rỗng
public class Review {

    @NotNull(message = "Tên không được để trống")
    private String username;

    @NotNull(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    private String email;

    @NotNull(message = "Vui lòng chọn số sao")
    @Min(value = 1, message = "Đánh giá tối thiểu là 1 sao")
    @Max(value = 5, message = "Đánh giá tối đa là 5 sao")
    private Integer rating;

    @Size(max = 200, message = "Bình luận không được quá 200 ký tự")
    private String comment;
}
