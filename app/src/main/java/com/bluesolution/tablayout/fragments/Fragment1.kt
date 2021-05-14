package com.bluesolution.tablayout.fragments

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bluesolution.tablayout.R
import com.bluesolution.tablayout.databinding.Fragment1Binding
import com.orhanobut.dialogplus.DialogPlus
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

        binding.button.setOnClickListener {
            val dialog = DialogPlus.newDialog(activity)
                .setOnItemClickListener(object : OnItemClickListener {
                    override fun onItemClick(
                        dialog: DialogPlus?,
                        item: Any?,
                        view: View?,
                        position: Int
                    ) {
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