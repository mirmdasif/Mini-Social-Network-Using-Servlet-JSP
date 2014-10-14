CREATE TABLE follower
(
    user_id INT NOT NULL,
    follower_id INT NOT NULL
);
CREATE TABLE friend_request
(
    sender_id INT,
    receiver_id INT
);
CREATE TABLE post
(
    post_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    body VARCHAR(100) NOT NULL,
    post_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);
CREATE TABLE post_comment
(
    comment_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    post_id INT NOT NULL,
    user_id INT NOT NULL,
    body VARCHAR(50) NOT NULL,
    comment_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);
CREATE TABLE user
(
    user_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    email VARCHAR(50) NOT NULL
);
ALTER TABLE follower ADD FOREIGN KEY (user_id) REFERENCES user (user_id);
ALTER TABLE follower ADD FOREIGN KEY (follower_id) REFERENCES user (user_id);
CREATE UNIQUE INDEX unique_index ON follower (user_id, follower_id);
ALTER TABLE friend_request ADD FOREIGN KEY (sender_id) REFERENCES user (user_id);
ALTER TABLE friend_request ADD FOREIGN KEY (receiver_id) REFERENCES user (user_id);
ALTER TABLE post ADD FOREIGN KEY (user_id) REFERENCES user (user_id);
ALTER TABLE post_comment ADD FOREIGN KEY (user_id) REFERENCES user (user_id);
ALTER TABLE post_comment ADD FOREIGN KEY (post_id) REFERENCES post (post_id);
