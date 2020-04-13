package com.example.iwatch.Entities

import fr.upem.myapplication.CommentType
import java.io.Serializable

class Comment(var commentType: CommentType): Serializable {

    internal var text: String? = null
    internal var toast: String? = null
    internal var user: String? = null


    init {
        when(commentType){
            CommentType.Movie -> {
                toast = "You comment a film"

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
