package com.example.fedorinchik_hw9

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Fragment : Fragment() {

    var motionLayout: MotionLayout? = null

    private lateinit var recycler: RecyclerView
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val startFragment = inflater.inflate(R.layout.recycler_fragment, container, false)
        recyclerStart(startFragment)
        return startFragment
    }

    private fun recyclerStart(view: View) {
        recycler = view.findViewById(R.id.RecyclerView)
        motionLayout =view.findViewById(R.id.vegetable)
        val adapter = VegetableAdapter(vegetables) {
            motionLayout?.transitionToEnd()
        }
        recycler.adapter = adapter
        recycler.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
    }
}