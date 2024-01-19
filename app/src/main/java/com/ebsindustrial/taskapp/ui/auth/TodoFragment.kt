package com.ebsindustrial.taskapp.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ebsindustrial.taskapp.R
import com.ebsindustrial.taskapp.databinding.FragmentDoingBinding
import com.ebsindustrial.taskapp.databinding.FragmentLoginBinding
import com.ebsindustrial.taskapp.databinding.FragmentTodoBinding

class TodoFragment : Fragment() {

    private var _binding: FragmentTodoBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()
    }

    private fun initListener(){
        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_formTaskFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}