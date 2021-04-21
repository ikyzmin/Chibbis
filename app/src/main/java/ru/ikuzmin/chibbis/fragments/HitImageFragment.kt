package ru.ikuzmin.chibbis.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.app.SharedElementCallback
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import com.squareup.picasso.Picasso
import ru.ikuzmin.chibbis.R


const val IMAGE_URL_ARGUMENT_KEY = "IMAGE_URL"

class HitImageFragment : Fragment() {

    companion object {
        fun createMe(url: String): HitImageFragment {
            return HitImageFragment().apply {
                arguments = Bundle().apply {
                    putString(IMAGE_URL_ARGUMENT_KEY, url)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.f_hit_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageView = view.findViewById<ImageView>(R.id.hit_image)
        Picasso.get().load(arguments!!.getString(IMAGE_URL_ARGUMENT_KEY, "")).into(imageView)
    }
}