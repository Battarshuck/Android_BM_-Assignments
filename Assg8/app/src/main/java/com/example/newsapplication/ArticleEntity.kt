package com.example.newsapplication

import androidx.room.*


@Entity(tableName = "favourite_articles")
 class ArticleEntity (
    @ColumnInfo(name = "author"     ) var author      : String?,
    @ColumnInfo(name ="title"       ) var title       : String?,
    @ColumnInfo(name ="description" ) var description : String?,
    @ColumnInfo(name ="url"         ) var url         : String?,
    @ColumnInfo(name ="urlToImage"  ) var urlToImage  : String?,
    @ColumnInfo(name ="publishedAt" ) var publishedAt : String?,
    @ColumnInfo(name ="content"     ) var content     : String?,
    @PrimaryKey(autoGenerate = true ) var id: Int = 0
)

@Dao
interface FavArticlesDAO {

    @Query("SELECT * FROM favourite_articles")
    fun getFavouriteArticles(): List<ArticleEntity>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertArticle(article: ArticleEntity)

}

@Database(entities = [ArticleEntity::class], version = 1)
abstract class DataBasic : RoomDatabase(){
    abstract fun getUserDao(): FavArticlesDAO
}