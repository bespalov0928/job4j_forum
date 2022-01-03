package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;

import java.util.*;

@Service
public class PostService {
    private static int POST_COUNT;
    private final Map<Integer, Post> posts = new HashMap();

    public PostService() {
        posts.put(++POST_COUNT, Post.of("Продаю машину ладу 01."));
    }

    public List<Post> getAll() {
        List<Post> rsl = new ArrayList(posts.values());
        return rsl;
    }

    public void add(Post post, String[] idArr) {
        if (idArr != null) {
            Post postOld = posts.get(Integer.parseInt(idArr[0]));
            postOld.setName(post.getName());
            postOld.setDescription(post.getDescription());
            postOld.setDiscussion(post.getDiscussion());
            return;
        }
        Post postNew = Post.of(post.getName());
        postNew.setId(++POST_COUNT);
        postNew.setDescription(post.getDescription());
        postNew.setCreated(Calendar.getInstance());
        posts.put(postNew.getId(), postNew);
        postNew.setId(posts.size() - 1);
    }

    public Post findById(int id) {
        Post rsl;
        rsl = posts.get(id);
        return rsl;
    }

}
