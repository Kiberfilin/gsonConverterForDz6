import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dto.*
import dto.posttypes.PostType
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

fun main() {
    fun testData(): ArrayList<out Post> = arrayListOf(
        Post(
            34, "CATS", "All your base are belong to us", "1992",
            likeCount = 3,
            commentCount = 1,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = true,
            sharedByMe = false,
            postType = PostType.POST
        ),
        Event(
            323, "CATS", "Event: All your base are belong to us", "1992",
            likeCount = 3,
            commentCount = 31,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = false,
            sharedByMe = false,
            postType = PostType.EVENT,
            address = "Shimizu, Suginami City, Tokyo, Japan",
            coordinates = Coordinates(35.7135292, 139.6134291)
        ),
        Post(
            314, "CATS", "Repost 1 All your base are belong to us", "1992",
            likeCount = 3,
            commentCount = 1,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = false,
            sharedByMe = false,
            postType = PostType.REPOST,
            source = Post(
                234, "CATS", "Source post for repost. All your base are belong to us", "1992",
                likeCount = 3,
                commentCount = 1,
                shareCount = 0,
                likedByMe = true,
                commentedByMe = false,
                sharedByMe = false,
                postType = PostType.POST
            )
        ),
        Add(
            348032,
            "CATS",
            "Реклама: All your base are belong to us",
            "1992",
            postType = PostType.ADD,
            url = "https://duckduckgo.com/?q=herbalife&atb=v127-3bd&ia=web"

        ),
        Post(
            3, "CATS", "Repost 2 All your base are belong to us", "1992",
            likeCount = 3,
            commentCount = 1,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = false,
            sharedByMe = false,
            postType = PostType.REPOST,
            source = Event(
                323,
                "CATS",
                "Source event post for repost. Event: All your base are belong to us",
                "1992",
                likeCount = 3,
                commentCount = 31,
                shareCount = 0,
                likedByMe = true,
                commentedByMe = false,
                sharedByMe = false,
                postType = PostType.EVENT,
                address = "Shimizu, Suginami City, Tokyo, Japan",
                coordinates = Coordinates(35.7135292, 139.6134291)
            )
        ), Post(
            34, "CATS", "All your base are belong to us", "1992",
            likeCount = 3,
            commentCount = 1,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = true,
            sharedByMe = false,
            postType = PostType.POST
        ),
        Event(
            323, "CATS", "Event: All your base are belong to us", "1992",
            likeCount = 3,
            commentCount = 31,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = false,
            sharedByMe = false,
            postType = PostType.EVENT,
            address = "Shimizu, Suginami City, Tokyo, Japan",
            coordinates = Coordinates(35.7135292, 139.6134291)
        ),
        Post(
            314, "CATS", "Repost 1 All your base are belong to us", "1992",
            likeCount = 3,
            commentCount = 1,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = false,
            sharedByMe = false,
            postType = PostType.REPOST,
            source = Post(
                234, "CATS", "Source post for repost. All your base are belong to us", "1992",
                likeCount = 3,
                commentCount = 1,
                shareCount = 0,
                likedByMe = true,
                commentedByMe = false,
                sharedByMe = false,
                postType = PostType.POST
            )
        ),
        Post(
            34, "CATS", "All your base are belong to us", "1992",
            likeCount = 3,
            commentCount = 1,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = true,
            sharedByMe = false,
            postType = PostType.POST
        ),
        Post(
            3, "CATS", "Repost 2 All your base are belong to us", "1992",
            likeCount = 3,
            commentCount = 1,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = false,
            sharedByMe = false,
            postType = PostType.REPOST,
            source = Event(
                323,
                "CATS",
                "Source event post for repost. Event: All your base are belong to us",
                "1992",
                likeCount = 3,
                commentCount = 31,
                shareCount = 0,
                likedByMe = true,
                commentedByMe = false,
                sharedByMe = false,
                postType = PostType.EVENT,
                address = "Shimizu, Suginami City, Tokyo, Japan",
                coordinates = Coordinates(35.7135292, 139.6134291)
            )
        ), Video(
            34, "CATS", "All your base are belong to us", "1992",
            likeCount = 25,
            commentCount = 8,
            shareCount = 12,
            likedByMe = true,
            commentedByMe = true,
            sharedByMe = false,
            postType = PostType.VIDEO,
            url = "https://www.youtube.com/watch?v=jQE66WA2s-A"
        ),
        Event(
            323, "CATS", "Event: All your base are belong to us", "1992",
            likeCount = 3,
            commentCount = 31,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = false,
            sharedByMe = false,
            postType = PostType.EVENT,
            address = "Shimizu, Suginami City, Tokyo, Japan",
            coordinates = Coordinates(35.7135292, 139.6134291)
        ),
        Post(
            3, "CATS", "Repost Video All your base are belong to us", "1992",
            likeCount = 3,
            commentCount = 1,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = false,
            sharedByMe = false,
            postType = PostType.REPOST,
            source = Video(
                34, "CATS", "All your base are belong to us", "1992",
                likeCount = 25,
                commentCount = 8,
                shareCount = 12,
                likedByMe = true,
                commentedByMe = true,
                sharedByMe = false,
                postType = PostType.VIDEO,
                url = "https://www.youtube.com/watch?v=jQE66WA2s-A"
            )
        ),
        Post(
            314, "CATS", "Repost 1 All your base are belong to us", "1992",
            likeCount = 3,
            commentCount = 1,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = false,
            sharedByMe = false,
            postType = PostType.REPOST,
            source = Post(
                234, "CATS", "Source post for repost. All your base are belong to us", "1992",
                likeCount = 3,
                commentCount = 1,
                shareCount = 0,
                likedByMe = true,
                commentedByMe = false,
                sharedByMe = false,
                postType = PostType.POST
            )
        ),
        Post(
            34, "CATS", "All your base are belong to us", "1992",
            likeCount = 3,
            commentCount = 1,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = true,
            sharedByMe = false,
            postType = PostType.POST
        ),
        Post(
            3, "CATS", "Repost 2 All your base are belong to us", "1992",
            likeCount = 3,
            commentCount = 1,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = false,
            sharedByMe = false,
            postType = PostType.REPOST,
            source = Event(
                323,
                "CATS",
                "Source event post for repost. Event: All your base are belong to us",
                "1992",
                likeCount = 3,
                commentCount = 31,
                shareCount = 0,
                likedByMe = true,
                commentedByMe = false,
                sharedByMe = false,
                postType = PostType.EVENT,
                address = "Shimizu, Suginami City, Tokyo, Japan",
                coordinates = Coordinates(35.7135292, 139.6134291)
            )
        ), Post(
            34, "CATS", "All your base are belong to us", "1992",
            likeCount = 3,
            commentCount = 1,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = true,
            sharedByMe = false,
            postType = PostType.POST
        ),
        Event(
            323, "CATS", "Event: All your base are belong to us", "1992",
            likeCount = 3,
            commentCount = 31,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = false,
            sharedByMe = false,
            postType = PostType.EVENT,
            address = "Shimizu, Suginami City, Tokyo, Japan",
            coordinates = Coordinates(35.7135292, 139.6134291)
        ),
        Post(
            314, "CATS", "Repost 1 All your base are belong to us", "1992",
            likeCount = 3,
            commentCount = 1,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = false,
            sharedByMe = false,
            postType = PostType.REPOST,
            source = Post(
                234, "CATS", "Source post for repost. All your base are belong to us", "1992",
                likeCount = 3,
                commentCount = 1,
                shareCount = 0,
                likedByMe = true,
                commentedByMe = false,
                sharedByMe = false,
                postType = PostType.POST
            )
        ),
        Post(
            34, "CATS", "All your base are belong to us", "1992",
            likeCount = 3,
            commentCount = 1,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = true,
            sharedByMe = false,
            postType = PostType.POST
        ),
        Post(
            3, "CATS", "Repost 2 All your base are belong to us", "1992",
            likeCount = 3,
            commentCount = 1,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = false,
            sharedByMe = false,
            postType = PostType.REPOST,
            source = Event(
                323,
                "CATS",
                "Source event post for repost. Event: All your base are belong to us",
                "1992",
                likeCount = 3,
                commentCount = 31,
                shareCount = 0,
                likedByMe = true,
                commentedByMe = false,
                sharedByMe = false,
                postType = PostType.EVENT,
                address = "Shimizu, Suginami City, Tokyo, Japan",
                coordinates = Coordinates(35.7135292, 139.6134291)
            )
        ), Post(
            34, "CATS", "All your base are belong to us", "1992",
            likeCount = 3,
            commentCount = 1,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = true,
            sharedByMe = false,
            postType = PostType.POST
        ),
        Event(
            323, "CATS", "Event: All your base are belong to us", "1992",
            likeCount = 3,
            commentCount = 31,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = false,
            sharedByMe = false,
            postType = PostType.EVENT,
            address = "Shimizu, Suginami City, Tokyo, Japan",
            coordinates = Coordinates(35.7135292, 139.6134291)
        ),
        Post(
            314, "CATS", "Repost 1 All your base are belong to us", "1992",
            likeCount = 3,
            commentCount = 1,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = false,
            sharedByMe = false,
            postType = PostType.REPOST,
            source = Post(
                234, "CATS", "Source post for repost. All your base are belong to us", "1992",
                likeCount = 3,
                commentCount = 1,
                shareCount = 0,
                likedByMe = true,
                commentedByMe = false,
                sharedByMe = false,
                postType = PostType.POST
            )
        ),
        Post(
            34, "CATS", "All your base are belong to us", "1992",
            likeCount = 3,
            commentCount = 1,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = true,
            sharedByMe = false,
            postType = PostType.POST
        ),
        Post(
            3, "CATS", "Repost 2 All your base are belong to us", "1992",
            likeCount = 3,
            commentCount = 1,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = false,
            sharedByMe = false,
            postType = PostType.REPOST,
            source = Event(
                323,
                "CATS",
                "Source event post for repost. Event: All your base are belong to us",
                "1992",
                likeCount = 3,
                commentCount = 31,
                shareCount = 0,
                likedByMe = true,
                commentedByMe = false,
                sharedByMe = false,
                postType = PostType.EVENT,
                address = "Shimizu, Suginami City, Tokyo, Japan",
                coordinates = Coordinates(35.7135292, 139.6134291)
            )
        ),
        Post(
            4, "CATS", "All your base are belong to us", "1992",
            likeCount = 3,
            commentCount = 1,
            shareCount = 0,
            likedByMe = true,
            commentedByMe = false,
            sharedByMe = false,
            postType = PostType.POST
        )
    )
    println(Gson().toJson(testData()))

    val gson = GsonBuilder().apply {
        setPrettyPrinting()
        serializeNulls()
    }.create()
    Files.write(Paths.get("./output.json"), gson.toJson(testData()).toByteArray(), StandardOpenOption.CREATE)
}