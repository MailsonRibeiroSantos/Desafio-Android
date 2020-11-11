package com.mailsonribeiro.desafio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText


class LoginFragment : Fragment() {
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        navegarRegister(view)
        realizarLogin(view)


    }
    fun navegarRegister(view:View){
        view.findViewById<MaterialButton>(R.id.btnRegisterLogin).setOnClickListener{
            navController.navigate(R.id.registerFragment)
        }

    }
    fun realizarLogin(view: View){
        view.findViewById<MaterialButton>(R.id.btnLoginLogin).setOnClickListener{
           if(validarCampos(view)) {
               navController.navigate(R.id.homeFragment)
           }
        }
    }

    fun validarCampos(view: View):Boolean{
        var resultado = true

        val editTextEmail = view.findViewById<TextInputEditText>(R.id.edtEmailLogin)
        val editTextPassword = view.findViewById<TextInputEditText>(R.id.edtPasswordLogin)

        if(editTextEmail.text.toString() == ""){
            editTextEmail.error = "Empty field"
            resultado = false
        }

        if(editTextPassword.text.toString() == ""){
            editTextPassword.error = "Empty field"
            resultado = false
        }
        return resultado
    }
}