package ru.netology

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
        val post = WallService.add(Post(1, 1, "content", true, likes = 3, postType = "Post",
            isFavourite = true, canDelete = true, canEdit = true, canPin = true, views = 4))
        assertEquals(1, post.id)
    }

    @Test
    fun updateTrue(){
        val post = WallService.add(Post(1, 1, "content", true, likes = 3, postType = "Post",
            isFavourite = true, canDelete = true, canEdit = true, canPin = true, views = 4))
        val postId = 1
        var result = false
        for ((index, post) in WallService.posts.withIndex()) {
            if (post.id == postId) {
                WallService.posts[index] = post.copy(id = 1, date = 0, text = "NewContent", friendsOnly = false, postType = "Reply", isFavourite = false,
                    canPin = false, canDelete = false, canEdit = false, likes = post.likes + 1, views = post.views + 1)
                result = true
            }
        }
        assertTrue(result)
    }

    @Test
    fun updateFalse(){
        val post = WallService.add(Post(1, 1, "content", true, likes = 3, postType = "Post",
            isFavourite = true, canDelete = true, canEdit = true, canPin = true, views = 4))
        val postId = 0
        var result = false
        for ((index, post) in WallService.posts.withIndex()) {
            if (post.id == postId) {
                WallService.posts[index] = post.copy(id = 1, date = 0, text = "NewContent", friendsOnly = false, postType = "Reply", isFavourite = false,
                    canPin = false, canDelete = false, canEdit = false, likes = post.likes + 1, views = post.views + 1)
                result = true
            }
        }
        assertFalse(result)
    }
}