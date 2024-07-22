package com.hfad.notesapp.ui.onboarding

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnboardingAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val listFragment = arrayListOf<Fragment>(
        StepFragment.getFragment(1),
        StepFragment.getFragment(2),
        StepFragment.getFragment(3),
    )

    override fun getItemCount(): Int = listFragment.size // общее кол-во фрагментов
    override fun createFragment(position: Int): Fragment = listFragment[position] // эл-т по позиции
}