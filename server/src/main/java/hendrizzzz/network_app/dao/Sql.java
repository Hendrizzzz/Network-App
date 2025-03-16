package hendrizzzz.network_app.dao;

public class Sql {

    // UserDAO
    static String addUser = "INSERT INTO users (first_name, last_name, user_name, hashed_password) VALUES (?, ?, ?, ?)";
    static String deleteUser = "DELETE FROM users WHERE user_name = ?";
    static String changeLastName = "UPDATE users SET last_name = ? WHERE user_name = ?";
    static String changeFirstName = "UPDATE users SET first_name = ? WHERE user_name = ?";
    static String changePassword = "UPDATE users SET hashed_password = ? WHERE user_name = ?";
    static String changeBirthDate = "UPDATE users SET birthday = ? WHERE user_name = ?";
    static String changeUserCommentSettings = "UPDATE users SET who_can_comment = ? WHERE user_name = ?";
    static String changeUserFriendRequestSettings = "UPDATE users SET who_can_send_friend_requests = ? WHERE user_name = ?";
    static String changeUsername = "UPDATE users SET user_name = ? WHERE user_name = ?";
    static String getHashedPassword = "SELECT hashed_password FROM users WHERE user_name = ?";
    static String getFirstName = "SELECT first_name FROM users WHERE user_name = ?";
    static String getLastName = "SELECT last_name FROM users WHERE user_name = ?";
    static String getBirthDate = "SELECT birthday FROM users WHERE user_name = ?";
    static String getAge = "SELECT age FROM users WHERE user_name = ?";
    static String getGender = "SELECT gender FROM users WHERE user_name = ?";
    static String getFriendsCount = "SELECT friends_count FROM users WHERE user_name = ?";
    static String getJoinDate = "SELECT join_date FROM users WHERE user_name = ?";
    static String getFriendRequestSettings = "SELECT who_can_send_friend_requests FROM users WHERE user_name = ?";
    static String getCommentSettings = "SELECT who_can_comment FROM users WHERE user_name = ?";


    // PostDAO
    static String addPost = "INSERT into post (author_id, contents, privacy) VALUES (?, ?, ?)";
    static String deletePost = "DELETE FROM post WHERE id = ?";
    static String updatePost = "UPDATE post SET contents = ?, privacy = ? WHERE id = ?";
    static String incrementCommentCount = "UPDATE post SET comment_count = comment_count + 1 WHERE id = ?";
    static String decrementCommentCount = "UPDATE post SET comment_count = comment_count - 1 WHERE id = ?";
    static String getCommentCount = "SELECT comment_count FROM post WHERE post_id = ?";


    // NotificationDAO
    static String markRead = "UPDATE notifications SET is_read = true WHERE id = ?";
    static String addNotification(String type) {return String.format("INSERT INTO notifications (user_id, notification_type, content, %s) VALUES (?, ?, ?, ?)", type);}
    static String deleteNotification = "DELETE FROM notifications WHERE id = ?";


    // MessageDAO
    static String addMessage = "INSERT INTO message (sender_id, receiver_id, contents) VALUES (?, ?, ?)";
    static String deleteMessage = "DELETE from message WHERE id = ?";
    static String editMessage = "UPDATE message SET contents = ? WHERE id = ?";


    // LikeDAO
    static String addLike(String type) { return "INSERT INTO like (is_a_post, user_who_liked, %s) VALUES (?, ?, ?)";}
    static String removeLike = "DELETE FROM like WHERE id = ?";


    // FriendshipDAO
    static String addFriendship = "INSERT INTO friends (user_id, other_user_id, status) VALUES (?, ?, ?)";
    static String updateFriendship = "UPDATE friends SET status = ? WHERE user_id = ? AND other_user_id = ?";
    static String removeFriendship = "DELETE from friends WHERE user_id = ? AND other_user_id = ?";


    // FollowersDAO
    static String addFollowers = "INSERT INTO followers (user_id, follower_id) VALUES (?, ?)";
    static String removeFollower = "DELETE FROM followers WHERE user_id = ? AND follower_id = ?";


    // CommentDAO
    static String addComment = "INSERT INTO comment (post_id, author_id, content) VALUES (?, ?, ?)";
    static String deleteComment = "DELETE FROM comment WHERE id = ?";
    static String editComment = "UPDATE comment SET content = ? WHERE id = ?";


}
