package com.ebsindustrial.taskapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Task(
    val id: String,
    val descriptor: String,
    val status: Status
) : Parcelable
