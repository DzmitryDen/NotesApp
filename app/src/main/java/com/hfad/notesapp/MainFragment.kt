package com.hfad.notesapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hfad.notesapp.databinding.FragmentMainBinding

class MainFragment : Fragment(){

    private var binding: FragmentMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonMain = binding?.mainButton
        buttonMain?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, SignupFragment())
                .addToBackStack(null)
                .commit()
        }

        val clickQueryText = binding?.mainQuery
        clickQueryText?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}


