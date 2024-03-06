package com.ods.acftexample

import android.content.Context
import com.ods.acftexample.data.Event

interface AcftService {
    fun getScorecard(age: Byte, gender: String): List<Event>
}