package com.mailsonribeiro.desafio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText


class RegisterFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)
           view.findViewById<MaterialButton>(R.id.btnRegisterResgiter).setOnClickListener{
               if(validarCampos(view)) {
                   navController.navigate(R.id.loginFragment)
               }
        }

    }
    fun validarCampos(view:View):Boolean{
        var resultado = true
        val editTextName = view.findViewById<TextInputEditText>(R.id.edtNameRegister)
        val editTextEmail = view.findViewById<TextInputEditText>(R.id.edtEmailRegister)
        val editTextPassword = view.findViewById<TextInputEditText>(R.id.edtPasswordRegister)
        val editTextRepeatPassword = view.findViewById<TextInputEditText>(R.id.edtRepeatPasswordRegister)


        if(editTextName.text.toString() == ""){
            editTextName.error = "Empty field"
            resultado = false
        }

        if(editTextEmail.text.toString() == ""){
            editTextEmail.error = "Empty field"
            resultado = false
        }

        if(editTextPassword.text.toString() == "") {
            editTextPassword.error = "Empty field"
            resultado = false
        }

        if(editTextRepeatPassword.text.toString() == "") {
            editTextRepeatPassword.error = "Empty field"
            resultado = false
        }
        resultado = validarSenha(view,editTextPassword.text.toString(),
            editTextRepeatPassword.text.toString())

        return resultado
    }
    fun validarSenha(view:View,senha:String, confirmarSenha:String):Boolean{
        var resultado = true
        if(senha != confirmarSenha){
            Toast.makeText(view.context,
                    "Password and confirm password must be the same",Toast.LENGTH_LONG).show()
            resultado = false
        }
        if(senha.length<6){
            Toast.makeText(view.context,
                "The password must be at least six characters long",Toast.LENGTH_LONG).show()
            resultado = false
        }
        return resultado

    }
}