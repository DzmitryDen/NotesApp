package com.hfad.notesapp.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hfad.notesapp.R
import com.hfad.notesapp.databinding.FragmentOnboardingBinding
import com.hfad.notesapp.ui.signup.SignupFragment

class OnboardingFragment: Fragment() {

    private var binding: FragmentOnboardingBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.skip?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, SignupFragment())
                .commit()
        }

        binding?.viewPager?.adapter = OnboardingAdapter(this)
        binding?.circleIndicator?.setViewPager(binding?.viewPager) // отображаем индикатор
    }
}