package com.ebsindustrial.taskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.ebsindustrial.taskapp.R
import com.ebsindustrial.taskapp.databinding.FragmentFormTaskBinding
import com.ebsindustrial.taskapp.util.initToolbar
import com.ebsindustrial.taskapp.util.showBottomSheet

class FormTaskFragment : Fragment() {

    private var _binding: FragmentFormTaskBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFormTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)

        initListeners()
    }

    private fun initListeners(){

        binding.btSave.setOnClickListener{
            validatedata()
            //
        }
    }

    private fun validatedata(){
        val description = binding.edtDescrition.text.toString().trim()

        if (description.isNotEmpty()){
            Toast.makeText(requireContext(), "Tudo certo!", Toast.LENGTH_SHORT).show()
        }else{
            showBottomSheet(message = getString(R.string.task_empty))
            //Toast.makeText(requireContext(), "Prencha uma descrição de tarefa!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}