package com.ebsindustrial.taskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebsindustrial.taskapp.R
import com.ebsindustrial.taskapp.data.model.Status
import com.ebsindustrial.taskapp.data.model.Task
import com.ebsindustrial.taskapp.databinding.FragmentTodoBinding
import com.ebsindustrial.taskapp.ui.adapter.TaskAdapter

class TodoFragment : Fragment() {

    private var _binding: FragmentTodoBinding? = null
    private val binding get() = _binding!!

    private lateinit var taskAdapter: TaskAdapter

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

        initListeners()

        initReciclerView(getTasks())
    }

    private fun initListeners(){
        binding.fabAdd.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_formTaskFragment)
        }
    }

    private fun initReciclerView(taskList: List<Task>) {
        taskAdapter = TaskAdapter(requireContext(), taskList)

        binding.rvTasks.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTasks.setHasFixedSize(true)
        binding.rvTasks.adapter = taskAdapter
    }

    private fun getTasks() = listOf(
        Task("0", "Criar nova tela do app", Status.TODO),
        Task("0", "Validar informações na tela de login", Status.TODO),
        Task("0", "Adicionar nova funcionalidade no app", Status.TODO),
        Task("0", "Salvar token no localmente", Status.TODO),
        Task("0", "Criar funconalidade de logout no app", Status.TODO)
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}