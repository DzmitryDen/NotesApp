package com.hfad.notesapp.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.hfad.notesapp.R
import com.hfad.notesapp.databinding.FragmentStepBinding

private const val STEP_ARG = "stepArg"

class StepFragment : Fragment() {

    private var binding: FragmentStepBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStepBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val step = arguments?.getInt(STEP_ARG)

        when (step) {
            1 -> {
                binding?.onboardingText?.text = getString(R.string.onboarding_step1_text)
                binding?.onboardingImage?.setImageResource(R.drawable.planet)
            }

            2 -> {
                binding?.onboardingText?.text = getString(R.string.onboarding_step2_text)
                binding?.onboardingImage?.setImageResource(R.drawable.level_up)
            }

            3 -> {
                binding?.onboardingText?.text = getString(R.string.onboarding_step3_text)
                binding?.onboardingImage?.setImageResource(R.drawable.chat)
            }
        }
    }

    companion object {
        fun getFragment(step: Int) = StepFragment().apply {
            arguments = bundleOf(STEP_ARG to step)
        }
    }
}