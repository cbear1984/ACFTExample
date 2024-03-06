package com.ods.acftexample

import android.content.Context
import com.google.gson.Gson
import com.ods.acftexample.data.Scorecards
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AcftServiceImpl @Inject constructor(
    @ApplicationContext val context: Context,
) : AcftService {

    override fun getScorecard(age: Byte, gender: String): List<Scorecards> {
        val jsonString = JsonDecoderService(context, "scorecard.json")
        val events: List<Scorecards> = emptyList()

        val scorecard = Gson().fromJson(jsonString, Scorecards::class.java)
        println("scorecard from Service.................: $scorecard")

//        if (scorecard.group == getAgeGroup() && scorecard.gender == gender) {
//            println("scorecard by age and gender from Service.................: ${scorecard.events.toList()}")
//            events = scorecard.events
//        }
//        println("scoreList from Service.................: ${scoreList.toList()}")
//        println("eventList from Service.................: ${events.toList()}")
//        val mdlList: MutableList<List<Mdl>> = mutableListOf()
//        mdlList.addAll( eventList.map { it.mdl } )
//        val mdlFlatMap = mdlList.map { it.forEach { it.points } }
//        val mdlMap: MutableMap<Short, Short> = mutableMapOf()
//        mdlFlatMap.map { (raw, points) ->
//            mdlMap.put(raw.toShort(), points)
//        }
//        println("mdlList from Service.................: ${mdlList.toList()}")
//        println("mdlFlatMap from Service..............: ${mdlFlatMap.toList()}")
//        println("mutable map of mdl from Service......: ${mdlMap.toMap()}")
//        val sptList = eventList.map { it.spt }
//        println("sptList from Service.................: ${sptList.toList()}")
//        val hrpList = eventList.map { it.hrp }
//        println("hrpList from Service.................: ${hrpList.toList()}")
//        val sdcList = eventList.map { it.sdc }
//        println("sdcList from Service.................: ${sdcList.toList()}")
//        val plkList = eventList.map { it.plk }
//        println("plkList from Service.................: ${plkList.toList()}")
//        val tmrList = eventList.map { it.tmr }
//        println("tmrList from Service.................: ${tmrList.toList()}")
//        val wlkList = eventList.map { it.wlk }
//        println("wlkList from Service.................: ${wlkList.toList()}")
//        val bkeList = eventList.map { it.bke }
//        println("bkeList from Service.................: ${bkeList.toList()}")
//        val swmList = eventList.map { it.swm }
//        println("swmList from Service.................: ${swmList.toList()}")
//        val rowList = eventList.map { it.row }
//        println("rowList from Service.................: ${rowList.toList()}")

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

