package com.ods.acftexample

import android.content.Context
import com.google.gson.Gson
import com.ods.acftexample.data.Scorecards
import com.ods.acftexample.data.Event
import com.ods.acftexample.data.Mdl
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AcftServiceImpl @Inject constructor(
    @ApplicationContext val context: Context,
) : AcftService {

    override fun getScorecard(age: Byte, gender: String): List<Event> {
        val jsonString = JsonDecoderService(context, "scorecard.json")
        val events: List<Event> = emptyList()

        val scorecards = Gson().fromJson(jsonString, Scorecards::class.java)
        println("scorecard from Service.................: $scorecards")

        for (x in scorecards.scorecards) {
            println("x $x")
            if (x.group == 1.toByte() && x.gender == "female") {
                println("x events ${x.events}")

                var mdlList: List<Mdl> = emptyList()

                    x.events.map {
                    mdlList = it.mdl ?: emptyList()
                    }
                println("MDL Events ${ mdlList.toList() }")
            }
        }

        fun getAgeGroup(): Byte {
            return when (age) {
                in 1..21 -> 0
                in 22..26 -> 1
                in 27..31 -> 2
                in 32..36 -> 3
                in 37..41 -> 4
                in 42..46 -> 5
                in 47..51 -> 6
                in 52..56 -> 7
                in 57..61 -> 8
                in 62..99 -> 9
                else -> 0
            }
        }

        return events
    }
}

