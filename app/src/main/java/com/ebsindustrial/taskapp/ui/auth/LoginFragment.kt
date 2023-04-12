package com.ebsindustrial.taskapp.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ebsindustrial.taskapp.R
import com.ebsindustrial.taskapp.databinding.FragmentLoginBinding
import com.ebsindustrial.taskapp.ui.util.showBottomSheet

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners(){

        binding.btLogin.setOnClickListener{
            validatedata()
            //
        }

        binding.btRegister.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.btRecover.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_recoverAccountFragment)
        }
    }

    private fun validatedata(){
        val email = binding.edtEmail.text.toString().trim()
        val senha = binding.edtSenha.text.toString().trim()

        if (email.isNotEmpty()){
            if (senha.isNotEmpty()){
                findNavController().navigate(R.id.action_global_homeFragment)
                //Toast.makeText(requireContext(), "Tudo certo", Toast.LENGTH_SHORT).show()
            }else{
                showBottomSheet(message = getString(R.string.senha_empyt))
                // Toast.makeText(requireContext(), "Prencha sua senha!", Toast.LENGTH_SHORT).show()
            }
        }else{
            showBottomSheet(message = getString(R.string.email_empyt))
            // Toast.makeText(requireContext(), "Prencha seu email!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}