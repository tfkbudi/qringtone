package com.tkfbudi.ringtone

import android.content.Context
import android.net.Uri
import android.support.v4.app.FragmentManager

/**
 * Created on : 01/10/18
 * Author     : Taufik Budi S
 * GitHub     : https://github.com/tfkbudi
 */

class QRingtone(internal val context: Context) {
    lateinit internal var fragmentManager: FragmentManager
    internal var positiveButton: String = context.getString(R.string.qringtone_ok)
    internal var negativeButton: String = context.getString(R.string.qringtone_cancel)
    internal var title: String = context.getString(R.string.qringtone_title)
    internal var playable: Boolean = true
    internal var currentRingtone: String? = null
    internal var qRingtoneListener: QRingtoneListener? = null

    fun setFragmentManager(fragmentManager: FragmentManager): QRingtone {
        this.fragmentManager = fragmentManager
        return this
    }

    fun setPositiveButton(positiveButton: String): QRingtone {
        this.positiveButton = positiveButton
        return this
    }

    fun setPositiveButton(positiveButton: Int): QRingtone {
        this.positiveButton = context.getString(positiveButton)
        return this
    }

    fun setNegativeButton(negativeButton: String): QRingtone {
        this.negativeButton = negativeButton
        return this
    }

    fun setNegativeButton(negativeButton: Int): QRingtone {
        this.negativeButton = context.getString(negativeButton)
        return this
    }

    fun setTitle(title: String): QRingtone {
        this.title = title
        return this
    }

    fun setTitle(title: Int): QRingtone {
        this.title = context.getString(title)
        return this
    }

    fun isPlayable(isPlayAble: Boolean): QRingtone {
        this.playable = isPlayAble
        return this
    }

    fun setRingtoneListener(qRingtoneListener: QRingtoneListener): QRingtone {
        this.qRingtoneListener = qRingtoneListener
        return this
    }

    fun setCurrentRingtone(currentRingtone :String?): QRingtone {
        this.currentRingtone = currentRingtone
        return this
    }

    fun setCurrentRingtone(currentRingtone: Uri): QRingtone {
        this.currentRingtone = currentRingtone.toString()
        return this
    }

    fun show() {
        if (!this::fragmentManager.isInitialized) {
            throw IllegalArgumentException("Support fragment manager can't null")
        }

        QRingtoneDialog.instance(fragmentManager,
                title,
                positiveButton,
                negativeButton,
                currentRingtone,
                qRingtoneListener)
    }

}