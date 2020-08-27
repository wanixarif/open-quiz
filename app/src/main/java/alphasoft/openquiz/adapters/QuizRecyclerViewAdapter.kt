package alphasoft.openquiz.adapters

import alphasoft.openquiz.databinding.QuizListItemBinding
import alphasoft.openquiz.networkapi.QuizQuestion
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class QuizRecyclerViewAdapter :ListAdapter<QuizQuestion,QuizRecyclerViewAdapter.QuizViewHolder>(DiffCallback){
    companion object DiffCallback:DiffUtil.ItemCallback<QuizQuestion>(){
        override fun areItemsTheSame(oldItem: QuizQuestion, newItem: QuizQuestion): Boolean {

            return  oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: QuizQuestion, newItem: QuizQuestion): Boolean {
            return oldItem.correct_answer == newItem.correct_answer
        }
    }
    class QuizViewHolder(private  var binding:QuizListItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(question: QuizQuestion){
            binding.questionVar=question
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        return QuizViewHolder(QuizListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        val question=getItem(position)
        holder.bind(question)
    }

}
