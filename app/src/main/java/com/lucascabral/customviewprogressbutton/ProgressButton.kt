package com.lucascabral.customviewprogressbutton

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.lucascabral.customviewprogressbutton.databinding.ProgressButtonBinding

class ProgressButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var title: String? = null
    private var loadingTitle: String? = null

    private val binding = ProgressButtonBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        setLayout(attrs)
    }

    private fun setLayout(attrs: AttributeSet?) {
        attrs?.let { attributeSet ->  
            val attributes = context.obtainStyledAttributes(
                attributeSet,
                R.styleable.ProgressButton
            )

            setBackgroundResource(R.drawable.progress_button_background)

            val titleResId = attributes.getResourceId(R.styleable.ProgressButton_progress_button_title, 0)
            if (titleResId != 0) {
                title = context.getString(titleResId)
            }

            val loadingTitleResId = attributes.getResourceId(R.styleable.ProgressButton_progress_button_loading_title, 0)
            if (loadingTitleResId != 0) {
                loadingTitle = context.getString(loadingTitleResId)
            }

            attributes.recycle()
        }
    }

    sealed class ProgressButtonState(val isEnabled: Boolean, val progressVisibility: Int) {
        object Normal : ProgressButtonState(true, View.GONE)
        object Loading : ProgressButtonState(false, View.VISIBLE)
    }
}