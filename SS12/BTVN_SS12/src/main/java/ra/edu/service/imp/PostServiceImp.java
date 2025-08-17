package ra.edu.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.model.Post;
import ra.edu.repo.PostRepo;
import ra.edu.service.PostService;

import java.util.List;

@Service
public class PostServiceImp implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Override
    public List<Post> getAllPostByUser(Long userId) {
        return postRepo.findAllPost(userId);
    }

    @Override
    public void save(Post post) {
        postRepo.save(post);
    }

    @Override
    public Post findById(Long id) {
        return postRepo.findById(id);
    }

    @Override
    public void delete(Long id) {
        postRepo.delete(id);
    }
}
