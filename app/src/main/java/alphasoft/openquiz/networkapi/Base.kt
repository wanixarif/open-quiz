package alphasoft.openquiz.networkapi

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Base (

        @Json(name="response_code") val response_code : Int,
        @Json(name="results") val results : List<QuizQuestion>
):Parcelable{

}