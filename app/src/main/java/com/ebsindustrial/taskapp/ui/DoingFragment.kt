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
import com.ebsindustrial.taskapp.databinding.FragmentDoingBinding
import com.ebsindustrial.taskapp.ui.adapter.TaskAdapter

class DoingFragment : Fragment() {

    private var _binding: FragmentDoingBinding? = null
    private val binding get() = _binding!!

    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDoingBinding.inflate(inflater, container, false)
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
        Task("0", "Tela do app", Status.DOING),
        Task("0", "Login", Status.DOING),
        Task("0", "Entrar app", Status.DOING),
        Task("0", "Salvar localmente", Status.DOING),
        Task("0", "Funconalidade ", Status.DOING)
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}