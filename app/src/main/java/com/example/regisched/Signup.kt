package com.example.regisched

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth


class Signup : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var emaillog: EditText
    private lateinit var passwordlog: EditText
    private lateinit var btnsignup: Button
    private lateinit var btnlogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        emaillog = view.findViewById(R.id.sign_user)
        passwordlog = view.findViewById(R.id.sign_password)
        btnsignup = view.findViewById(R.id.sign_signup)
        btnlogin = view.findViewById(R.id.sign_login)

        auth = FirebaseAuth.getInstance()

        btnsignup.setOnClickListener {
            var email: String = emaillog.text.toString()
            var password: String = passwordlog.text.toString()

            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(activity, "Please fill all the fields", Toast.LENGTH_LONG).show()
            } else{
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this.requireActivity(), OnCompleteListener { task ->
                    if(task.isSuccessful) {
                        Toast.makeText(activity, "Successfully Signed up", Toast.LENGTH_LONG).show()
                        findNavController().navigate(R.id.action_signup_to_dashBoard)
                    }else {
                        Toast.makeText(activity, "Signup Failed", Toast.LENGTH_LONG).show()
                    }
                })
            }
        }

        btnlogin.setOnClickListener {
            findNavController().navigate(R.id.action_signup_to_login)
        }



    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }


}