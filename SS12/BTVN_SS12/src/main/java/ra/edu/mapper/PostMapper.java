package ra.edu.mapper;

import ra.edu.model.dto.PostDto;
import ra.edu.model.Post;
import ra.edu.model.User;

import java.time.LocalDate;

public class PostMapper {
    public static Post toModel(PostDto dto, String imageUrl, User currentUser){
        Post post = new Post();
        post.setContent(dto.getContent());
        post.setImage(imageUrl);
        post.setCreatedDate(LocalDate.now());
        post.setUser(currentUser);
        return post;
    }
}
