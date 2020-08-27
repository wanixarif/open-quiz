package alphasoft.openquiz.networkapi

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://opentdb.com/api.php/"

enum class QuizFilter(val value:String){ SHOW_ALL("10"), SHOW_BUY("18"), SHOW_RENT("rent")}

private val moshi= Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
//
//val xmoshi: Moshi = Moshi.Builder().add(QuizQuestion()).build()
//val adapter: JsonAdapter<Base> = xmoshi.adapter(Base::class.java)
//val movie = adapter.fromJson("movieJson")

private val retrofit=Retrofit.Builder()
//        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(BASE_URL)
        .build()





interface QuizApiService {
    @GET("results")
    fun getQuestions(@Query("amount") amount:String,@Query("category") category:String ):
            Deferred<Base>
}

object QuizApi{
    val retroFitService:QuizApiService by lazy {
        retrofit.create(QuizApiService::class.java)
    }
}

































