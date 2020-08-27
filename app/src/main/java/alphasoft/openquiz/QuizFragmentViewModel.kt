package alphasoft.openquiz

import alphasoft.openquiz.networkapi.QuizApi
import alphasoft.openquiz.networkapi.QuizFilter
import alphasoft.openquiz.networkapi.QuizQuestion
import android.opengl.Visibility
import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

enum class NetworkApiStatus{LOADING,DONE,ERROR}

class QuizFragmentViewModel :ViewModel(){
        private val viewModelJob= Job()
        private val uiScope= CoroutineScope(Dispatchers.Main+viewModelJob)

        // The internal MutableLiveData String that stores the status of the most recent request
        private val _status = MutableLiveData<NetworkApiStatus>()

        // The external immutable LiveData for the request status String
        val status: LiveData<NetworkApiStatus>
            get() = _status


        private val _questions=MutableLiveData<List<QuizQuestion>>()
        val questions:LiveData<List<QuizQuestion>>
            get()=_questions



        /**
         * Call getMarsRealEstateProperties() on init so we can display status immediately.
         */
        init {
            getQuestions()
            Log.i("question","in init block")

        }



        /**
         * Sets the value of the status LiveData to the Mars API status.
         */
        private fun getQuestions() {
            _status.value=NetworkApiStatus.LOADING
            uiScope.launch {
                var getQuestionsDeferred= QuizApi.retroFitService.getQuestions("50","18")
                try {

                    val listResult=getQuestionsDeferred.await()
                    val listQuestions= listResult.results
                    _status.value=NetworkApiStatus.DONE
                    if (listQuestions?.size>0){

                        _questions.value=listQuestions
                        Log.i("ques", questions?.value?.get(0)?.question)
                    }
                }
                catch (t: Throwable){
                    Log.i("ques","${t.message} ERROR")
                    _status.value= NetworkApiStatus.ERROR

                }
            }
        }




        override fun onCleared() {
            super.onCleared()
            viewModelJob.cancel()
        }
}