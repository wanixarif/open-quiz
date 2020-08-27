package alphasoft.openquiz

import alphasoft.openquiz.adapters.QuizRecyclerViewAdapter
import alphasoft.openquiz.databinding.FragmentQuizBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders


class QuizFragment : Fragment() {

    /**
     * Lazily initialize our [OViewModel].
     */
    private val viewModel: QuizFragmentViewModel by lazy {
        ViewModelProviders.of(this).get(QuizFragmentViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        /**
         * Inflates the layout with Data Binding, sets its lifecycle owner to the OverviewFragment
         * to enable Data Binding to observe LiveData, and sets up the RecyclerView with an adapter.
         */
        val binding=FragmentQuizBinding.inflate(inflater)


        binding.viewModel = viewModel

        binding.lifecycleOwner=this
        binding.questionListRecyclerView.adapter=QuizRecyclerViewAdapter()



        return binding.root
    }
}
