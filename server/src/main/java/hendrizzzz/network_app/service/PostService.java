package hendrizzzz.network_app.service;

import exception.DuplicateModelException;
import hendrizzzz.network_app.dao.CommentDao;
import hendrizzzz.network_app.dao.LikeDao;
import hendrizzzz.network_app.dao.PostDao;
import hendrizzzz.network_app.model.Comment;
import hendrizzzz.network_app.model.Like;
import hendrizzzz.network_app.model.Post;

public class PostService {
    private final PostDao postDao;
    private final CommentDao commentDao;
    private final LikeDao likeDao;


    public PostService(PostDao postDao, CommentDao commentDao, LikeDao likeDao) {
        this.postDao = postDao;
        this.commentDao = commentDao;
        this.likeDao = likeDao;
    }


    public void addPost(int authorId, String contents, Character privacy) {
        if (authorId < 1) throw new IllegalArgumentException("authorId cannot be less than 1. ");
        if (contents == null || contents.isBlank()) throw new IllegalArgumentException("contents of the post cannot be blank. ");
        if (privacy == null || (privacy != 'A' && privacy != 'F' && privacy != 'N')) throw new IllegalArgumentException("Invalid privacy. Must be 'A', 'F', or 'N'. ");

        Post post = new Post(authorId, contents, privacy);
        postDao.addPost(post);
    }


    public void deletePost(int postId) {
        if (postId < 1) throw new IllegalArgumentException("postId cannot be less than 1. ");
        postDao.deletePost(postId);
    }


    public void updatePost(int postId, String newContents, Character privacy) {
        if (postId < 1) throw new IllegalArgumentException("postId cannot be less than 1. ");
        if (newContents == null || newContents.isBlank()) throw new IllegalArgumentException("contents of the post cannot be blank. ");
        if (privacy == null || (privacy != 'A' && privacy != 'F' && privacy != 'N')) throw new IllegalArgumentException("Invalid privacy. Must be 'A', 'F', or 'N'. ");

        postDao.updatePost(postId, newContents, privacy);
    }


    public void incrementCommentCount(int postId) {
        if (postId < 1) throw new IllegalArgumentException("postId cannot be less than 1. ");
        postDao.incrementCommentCount(postId);
    }


    public void decrementCommentCount(int postId) {
        if (postId < 1) throw new IllegalArgumentException("postId cannot be less than 1. ");
        postDao.decrementCommentCount(postId);
    }


    public int getCommentCount(int postId) {
        if (postId < 1) throw new IllegalArgumentException("postId cannot be less than 1. ");
        return postDao.getCommentCount(postId);
    }


    public void addLike(boolean isAPost, int user_id_who_liked, int commentOrPostId) {
        if (user_id_who_liked < 1) throw new IllegalArgumentException("user id cannot be less than 1. ");
        if (commentOrPostId < 1) throw new IllegalArgumentException("comment id or post id cannot be less than 1. ");

        Like like = new Like(isAPost, user_id_who_liked, commentOrPostId);

        try {
            likeDao.addLike(like);
        } catch (DuplicateModelException e) {
            // TODO : log
            throw e;
        }
    }


    public void removeLike(int id) {
        if (id < 1) throw new IllegalArgumentException("id cannot be less than 1. ");
        likeDao.removeLike(id);
    }


    public void addComment(int postId, int authorId, String contents) {
        if (postId < 1) throw new IllegalArgumentException("post id cannot be less than 1. ");
        if (authorId < 1) throw new IllegalArgumentException("author id or post id cannot be less than 1. ");
        if (contents == null || contents.isBlank()) throw new IllegalArgumentException("Contents cannot be blank. ");

        Comment comment = new Comment(postId, authorId, contents);
        commentDao.addComment(comment);
    }


    public void deleteComment(int commentId) {
        if (commentId < 1) throw new IllegalArgumentException("comment id cannot be less than 1");
        commentDao.deleteComment(commentId);
    }


    public void editComment(int commentId, String newContents) {
        if (commentId < 1) throw new IllegalArgumentException("comment id cannot be less than 1");
        if (newContents == null || newContents.isBlank()) throw new IllegalArgumentException("Contents cannot be blank. ");

        commentDao.editComment(commentId, newContents);
    }




}
