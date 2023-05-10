package com.ebsindustrial.taskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebsindustrial.taskapp.R
import com.ebsindustrial.taskapp.data.model.Status
import com.ebsindustrial.taskapp.data.model.Task
import com.ebsindustrial.taskapp.databinding.FragmentDoneBinding
import com.ebsindustrial.taskapp.ui.adapter.TaskAdapter

class DoneFragment : Fragment() {

    private var _binding: FragmentDoneBinding? = null
    private val binding get() = _binding!!

    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDoneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initReciclerView(getTasks())
    }

    private fun initReciclerView(taskList: List<Task>) {
        taskAdapter = TaskAdapter(requireContext(), taskList)

        binding.rvTasks.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTasks.setHasFixedSize(true)
        binding.rvTasks.adapter = taskAdapter
    }

    private fun getTasks() = listOf(
        Task("0", "Criando app", Status.DONE),
        Task("0", "Validando tela de login", Status.DONE),
        Task("0", "Adicionando funcionalidade no app", Status.DONE),
        Task("0", "Salvanado token localmente", Status.DONE),
        Task("0", "Logout no app", Status.DONE)
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}