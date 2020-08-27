package alphasoft.openquiz.networkapi

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
data class QuizQuestion(

        @Json(name="category") val category : String,
        @Json(name="type") val type : String,
        @Json(name="difficulty") val difficulty : String,
        @Json(name="question") val question : String,
        @Json(name="correct_answer") val correct_answer : String,
        @Json(name="incorrect_answers") val incorrect_answers : List<String>

) : Parcelable {
}

