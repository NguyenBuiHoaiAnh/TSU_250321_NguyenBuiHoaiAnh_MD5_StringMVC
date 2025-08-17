package ra.edu.repo;

import ra.edu.model.Post;

import java.util.List;

public interface PostRepo {
    List<Post> findAllPost(Long userId);

    void save(Post post);

    Post findById(Long id);

    void delete(Long id);
}
