package com.hfad.notesapp.ui.mainfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hfad.notesapp.R
import com.hfad.notesapp.databinding.FragmentMainBinding
import com.hfad.notesapp.repositories.SharedPreferencesRepository
import com.hfad.notesapp.ui.signup.SignupFragment
import com.hfad.notesapp.ui.login.LoginFragment
import com.hfad.notesapp.ui.onboarding.OnboardingFragment

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
            SharedPreferencesRepository.setFirstLaunch()
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, OnboardingFragment())
                .addToBackStack(null)
                .commit()
        }

        val clickQueryText = binding?.mainQuery
        clickQueryText?.setOnClickListener {
            SharedPreferencesRepository.setFirstLaunch()
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}


