package com.ods.acftexample

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.ods.acftexample.data.Scorecards
import com.ods.acftexample.data.Event
import com.ods.acftexample.data.Mdl
import com.ods.acftexample.data.Spt
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AcftServiceImpl @Inject constructor(
    @ApplicationContext val context: Context,
) : AcftService {
    override fun getAge(age: Byte) {
        _age.value = age
        events()
    }
    override fun getGender(gender: String) {
        _gender.value = gender
        events()
    }
    override fun getMdl(raw: Short): List<Mdl> {
        return _mdlList
    }
    override fun getSpt(raw: Double): List<Spt> {
        return _sptList
    }
    private var _scorecards = Scorecards()

    private val _age = mutableStateOf(18.toByte())
    private val _gender = mutableStateOf("female")

    private val _mdlList: List<Mdl> = emptyList()
    private val _sptList: List<Spt> = emptyList()

    private val scorecards = scorecard()
    private val events = events()
    private fun ageGroup(): Byte {
        return when (_age.value) {
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
    private fun scorecard(): Scorecards {
        val jsonString = JsonDecoderService(context, "scorecard.json")
        _scorecards = Gson().fromJson(jsonString, Scorecards::class.java)
        println("Scorecards() from Service.................: ${_scorecards.scorecards}")
        return _scorecards
    }
    private fun events(): List<Event> {
        for (scorecard in scorecards.scorecards) {
            println("All Events() from Service...................: ${scorecard.events}")
            if (scorecard.group == ageGroup() && scorecard.gender == _gender.value) {
                println("Specific Events() from Service..........: ${scorecard.events}")
                return scorecard.events
            }
        }
        return emptyList()
    }
}

//        events.map {
//            if (it.mdl != null) {
//                _mdlList = it.mdl ?: emptyList()
//            }
//            if (it.spt != null) {
//                _sptList = it.spt ?: emptyList()
//                println("sptList Events....................... ${_sptList.toList()}")
//            }
////            println("mdlToMap()....................... ${mdlToMap().toMap()}")
//        }
//        return events
//    }
//    private fun Scorecards?.newScorecard(): Scorecards {
//        return if (this == null) Scorecards() else Scorecards(
//            scorecards = this.scorecards
//        )
//    }


