package alphasoft.openquiz

import alphasoft.openquiz.databinding.FragmentSelectionBinding
import android.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SelectionFragment : Fragment(), AdapterView.OnItemSelectedListener {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding=FragmentSelectionBinding.inflate(inflater)
        val spinner: Spinner = binding.spinner
        spinner.onItemSelectedListener = this


        binding.buttonBeginQuiz.setOnClickListener {
            this.findNavController().navigate(SelectionFragmentDirections.actionSelectionFragmentToQuizFragment())
        }

        return binding.root
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val choice=parent?.getItemAtPosition(position)
        when(choice){
            "10"-> Log.i("alpha","10")
            "20"-> Log.i("alpha","20")

        }
    }
}
