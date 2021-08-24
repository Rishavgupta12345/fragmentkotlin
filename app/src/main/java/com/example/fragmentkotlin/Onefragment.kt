package com.example.fragmentkotlin

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast


/**
 * A simple [Fragment] subclass.
 */
class Onefragment : Fragment() {

    interface OnMessageClickListener{
        fun onMessageClick()
    }

    var messageListener: OnMessageClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_onefragment, container, false)

        val showActivityMessage = view.findViewById<Button>(R.id.show_activity_message)
        showActivityMessage.setOnClickListener {
//            activity?.let{
//                (it as MainActivity).showActivityMessage()
//            }

            messageListener?.onMessageClick()
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        messageListener = context as? OnMessageClickListener

        if(messageListener == null){
            throw ClassCastException("$context must implement OnArticleSelectedListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        messageListener = null
    }

    fun showFragmentMessage(){
        activity?.let {
            Toast.makeText(it, "This message is from Fragment", Toast.LENGTH_SHORT).show()
        }
    }

}
