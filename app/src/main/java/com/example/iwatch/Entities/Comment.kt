package com.example.iwatch.Entities
import com.example.iwatch.Enumerations.GenreType
import com.example.iwatch.R
import fr.upem.myapplication.CommentType
import java.io.Serializable
import java.util.Date

class Comment (var commentType: CommentType): Serializable {
    var toast:String? = null


    internal var text: String? = null
    internal var type: String? = null
    internal var idUser: Int = 0


    init {
        when(commentType){
            CommentType.Movie -> {
                toast = "You comment a film"

            }
           CommentType.Episode -> {
                toast = "You comment an episode"

            }
           CommentType.Season -> {
                toast = "You comment a saison"

            }
           CommentType.Tv -> {
                toast = "You comment a serie"

            }

            CommentType.nulle -> {
                toast = "no comment"

            }


        }

    }


}
