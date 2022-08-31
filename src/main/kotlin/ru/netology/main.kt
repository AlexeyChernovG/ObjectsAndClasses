package ru.netology

data class Post(
    var id: Int,
    val date: Int,
    val text: String,
    val friendsOnly: Boolean,
    val postType: String,
    val isFavourite: Boolean,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val likes: Int,
    val views: Int
)

object WallService {

    var posts = emptyArray<Post>()

    fun clear() {
        posts = emptyArray()
    }

    fun add(post: Post): Post {
        posts += post
        return posts.last()
    }

    fun update(post: Post, postId: Int): Boolean {
        var result = false
        for ((index, post) in posts.withIndex()) {
            if (post.id == postId) {
                posts[index] = post.copy(id = 1, date = 0, text = "NewContent", friendsOnly = false, postType = "Reply", isFavourite = false,
                    canPin = false, canDelete = false, canEdit = false, likes = post.likes + 1, views = post.views + 1)
                result = true
            }
        }
        return result
    }

}

fun main() {
    val post = Post(0, 1, "content", true, likes = 3, postType = "Post",
        isFavourite = true, canDelete = true, canEdit = true, canPin = true, views = 4)
    WallService.add(post)
    val (id, date, text, _, _, isFavourite, _, _, _, views, likes) = post
    println("$id, $date, $text, $likes, $isFavourite, $views")
    println(WallService.add(post))
}