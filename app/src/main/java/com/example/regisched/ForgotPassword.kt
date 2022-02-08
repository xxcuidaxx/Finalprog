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


class ForgotPassword : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var emaillog: EditText
    private lateinit var btnreset: Button
    private lateinit var btnlogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()
        emaillog = view.findViewById(R.id.fp_user)
        btnreset = view.findViewById(R.id.fp_reset)
        btnlogin = view.findViewById(R.id.fp_login)

        btnreset.setOnClickListener {
            var email: String = emaillog.text.toString()
            if (TextUtils.isEmpty(email)) {
                Toast.makeText(activity, "Please enter email id", Toast.LENGTH_LONG).show()
            } else {
                auth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(this.requireActivity(), OnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(activity, "Reset link sent to your email", Toast.LENGTH_LONG)
                                .show()
                        } else {
                            Toast.makeText(activity, "Unable to send reset mail", Toast.LENGTH_LONG)
                                .show()
                        }
                    })
            }
        }

        btnlogin.setOnClickListener {
            findNavController().navigate(R.id.action_forgotPassword_to_login)

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forgot_password, container, false)
    }


}


