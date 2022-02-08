package com.example.regisched

import android.app.Activity
import android.app.ProgressDialog.show
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth


class Login : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var emaillog: EditText
    private lateinit var passwordlog: EditText
    private lateinit var btnsignup: Button
    private lateinit var btnlogin: Button
    private lateinit var forgotpass: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        emaillog = view!!.findViewById(R.id.login_user)
//        passwordlog = view!!.findViewById(R.id.login_password)
//        btnsignup = view!!.findViewById(R.id.button_signup)
//        btnlogin = view!!.findViewById(R.id.button_login)
//        forgotpass = view!!.findViewById(R.id.login_forgotpassword)
//
//        auth = FirebaseAuth.getInstance()
//
//
//        btnlogin.setOnClickListener {
//            var email: String = emaillog.text.toString()
//            var password: String = passwordlog.text.toString()
//
//            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
//                Toast.makeText(activity, "Please fill all the fields", Toast.LENGTH_LONG).show()
//            } else{
//                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this.requireActivity(), OnCompleteListener { task ->
//                    if(task.isSuccessful) {
//                        Toast.makeText(activity, "Successfully Logged In", Toast.LENGTH_LONG).show()
//                        findNavController().navigate(R.id.action_login_to_dashBoard)
//                    }else {
//                        Toast.makeText(activity, "Login Failed", Toast.LENGTH_LONG).show()
//                    }
//                })
//            }
//        }

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        emaillog = view.findViewById(R.id.login_user)
        passwordlog = view.findViewById(R.id.login_password)
        btnsignup = view.findViewById(R.id.button_signup)
        btnlogin = view.findViewById(R.id.button_login)
        forgotpass = view.findViewById(R.id.login_forgotpassword)

        auth = FirebaseAuth.getInstance()


        btnlogin.setOnClickListener {
            var email: String = emaillog.text.toString()
            var password: String = passwordlog.text.toString()

            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(activity, "Please fill all the fields", Toast.LENGTH_LONG).show()
            } else{
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this.requireActivity(), OnCompleteListener { task ->
                    if(task.isSuccessful) {
                        Toast.makeText(activity, "Successfully Logged In", Toast.LENGTH_LONG).show()
                        findNavController().navigate(R.id.action_login_to_dashBoard)
                    }else {
                        Toast.makeText(activity, "Login Failed", Toast.LENGTH_LONG).show()
                    }
                })
            }
        }

        btnsignup.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_signup)

        }

        forgotpass.setOnClickListener{
            findNavController().navigate(R.id.action_login_to_forgotPassword)

        }



    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)

    }



}

