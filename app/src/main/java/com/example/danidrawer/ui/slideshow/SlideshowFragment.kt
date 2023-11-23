package com.example.danidrawer.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.danidrawer.R
import com.example.danidrawer.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista: View = inflater.inflate(R.layout.fragment_slideshow, container, false)


        return vista
    }
}