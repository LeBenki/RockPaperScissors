package com.example.rockpaperscissors.ui.choose_hand

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rockpaperscissors.R
import com.example.rockpaperscissors.model.Hand
import com.example.rockpaperscissors.ui.result.ResultActivity
import com.example.rockpaperscissors.view.RecyclerItemClickListener


class ChooseHandFragment : Fragment() {

    private lateinit var handRecyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_choose_hand, container)
        viewManager = LinearLayoutManager(view.context)
        viewAdapter = ChooseHandAdapter(Hand.values().toList())
        handRecyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_hand).apply {
            configureRecyclerView(this)
        }
        return view
    }

    private fun configureRecyclerView(recyclerView: RecyclerView) {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = viewManager
        recyclerView.adapter = viewAdapter
        recyclerView.addOnItemTouchListener(
            RecyclerItemClickListener(
                context,
                object :
                    RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View?, position: Int) {
                        val intent = Intent(context, ResultActivity::class.java)
                        intent.putExtra(ResultActivity.PARAM_HAND, Hand.values()[position].name)
                        startActivity(intent)
                        activity?.finish()
                    }
                })
        )
    }
}