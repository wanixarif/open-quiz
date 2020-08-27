package alphasoft.openquiz.adapters

import alphasoft.openquiz.NetworkApiStatus
import alphasoft.openquiz.R
import alphasoft.openquiz.networkapi.QuizQuestion
import android.view.View
import android.widget.ImageView
import android.widget.RadioButton
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("imgLoadingProgress")
fun bindLoadingImage(statusImageView: ImageView, NetworkApiStatus: NetworkApiStatus?){
    when (NetworkApiStatus) {
        alphasoft.openquiz.NetworkApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        alphasoft.openquiz.NetworkApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        alphasoft.openquiz.NetworkApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}

@BindingAdapter("questionType")
fun questionTypeVisibility(view:RadioButton,question: QuizQuestion){
    when(question.type){
        "boolean"->view.visibility=View.GONE
        else->view.visibility=View.VISIBLE
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data:List<QuizQuestion>?){
    val adapter=recyclerView.adapter as QuizRecyclerViewAdapter
    adapter.submitList(data)
}
