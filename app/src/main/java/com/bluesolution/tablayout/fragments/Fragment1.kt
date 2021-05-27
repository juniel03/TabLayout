package com.bluesolution.tablayout.fragments

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bluesolution.tablayout.R
import com.bluesolution.tablayout.adapters.HorizontalRecyclerViewAdapter
import com.bluesolution.tablayout.databinding.Fragment1Binding
import com.orhanobut.dialogplus.DialogPlus
import com.orhanobut.dialogplus.OnClickListener
import com.orhanobut.dialogplus.OnItemClickListener
import com.orhanobut.dialogplus.ViewHolder


class Fragment1 : Fragment() {

    private var _binding: Fragment1Binding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Fragment1Binding.inflate(inflater, container, false)

        binding.recycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        //creating a  arraylist of data
        val data: ArrayList<String> = ArrayList()
        data.add("https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MXx8aHVtYW58ZW58MHx8MHw%3D&ixlib=rb-1.2.1&w=1000&q=80")
        data.add("https://images.ctfassets.net/hrltx12pl8hq/4plHDVeTkWuFMihxQnzBSb/aea2f06d675c3d710d095306e377382f/shutterstock_554314555_copy.jpg")
        data.add("https://images.unsplash.com/photo-1541963463532-d68292c34b19?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxleHBsb3JlLWZlZWR8M3x8fGVufDB8fHw%3D&w=1000&q=80")
        data.add("https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MXx8aHVtYW58ZW58MHx8MHw%3D&ixlib=rb-1.2.1&w=1000&q=80")
        data.add("https://images.ctfassets.net/hrltx12pl8hq/4plHDVeTkWuFMihxQnzBSb/aea2f06d675c3d710d095306e377382f/shutterstock_554314555_copy.jpg")
        data.add("https://images.unsplash.com/photo-1541963463532-d68292c34b19?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxleHBsb3JlLWZlZWR8M3x8fGVufDB8fHw%3D&w=1000&q=80")
        data.add("https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MXx8aHVtYW58ZW58MHx8MHw%3D&ixlib=rb-1.2.1&w=1000&q=80")
        data.add("https://images.ctfassets.net/hrltx12pl8hq/4plHDVeTkWuFMihxQnzBSb/aea2f06d675c3d710d095306e377382f/shutterstock_554314555_copy.jpg")
        data.add("https://images.unsplash.com/photo-1541963463532-d68292c34b19?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxleHBsb3JlLWZlZWR8M3x8fGVufDB8fHw%3D&w=1000&q=80")
        binding.recycler.adapter = HorizontalRecyclerViewAdapter(data)

        binding.button.setOnClickListener {
            val dialog = DialogPlus.newDialog(activity)
                .setOnClickListener(object: OnClickListener{
                    override fun onClick(dialog: DialogPlus?, view: View?) {
                     when(view!!.id){
                         R.id.btnAccept -> Toast.makeText(activity, "accept", Toast.LENGTH_SHORT).show()
                         R.id.close -> dialog!!.dismiss()
                     }
                    }
                })
                .setContentBackgroundResource(android.R.color.transparent)
                .setCancelable(true)
                .setGravity(Gravity.CENTER)
                .setContentHolder(ViewHolder(R.layout.verification_success))
                .create()
            dialog.show()
        }

        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}