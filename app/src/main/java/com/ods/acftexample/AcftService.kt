package com.ods.acftexample

import android.content.Context
import com.ods.acftexample.data.Scorecards

interface AcftService {
    fun getScorecard(age: Byte, gender: String): List<Scorecards>
}