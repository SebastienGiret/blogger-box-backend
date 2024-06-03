package com.dauphine.blogger.services.impl;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class PostServiceImpl implements PostService {

    private final List<Post> temporaryPosts;

    public PostServiceImpl() {
        temporaryPosts = new ArrayList<>();
        temporaryPosts.add(new Post("1st Post","ouga",UUID.randomUUID()));
        temporaryPosts.add(new Post("2nd Post","bouga",UUID.randomUUID()));
        temporaryPosts.add(new Post("3rd Post","booga",UUID.randomUUID()));
    }

    @Override
    public List<Post> getAllByCategoryId(UUID category_id){
        ArrayList<Post> posts = new ArrayList<>();
        for(Post post : temporaryPosts){
            if (post.getCategory_id().equals(category_id)){
                posts.add(post);
            }
        }
        return posts;
    }
    @Override
    public List<Post> getAll(){
        return temporaryPosts;
    }
    @Override
    public Post getById(UUID id){
        return temporaryPosts.stream().filter(post -> post.getId().equals(id)).findFirst().orElse(null);
    }
    @Override
    public Post create(String title, String content, UUID category_id) {
        Post post = new Post(title, content, category_id);
        temporaryPosts.add(post);
        return post;
    }
    @Override
    public Post update(UUID id, String title, String content) {
        Post post = temporaryPosts.stream().filter(post1 -> post1.getId().equals(id)).findFirst().orElse(null);
        if (post != null) {
            post.setTitle(title);
            post.setContent(content);
        }
        return post;
    }
    @Override
    public boolean deleteById(UUID id) {
        temporaryPosts.removeIf(post -> post.getId().equals(id));
        return true;
    }
}
