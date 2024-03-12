package com.ods.acftexample

import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import com.ods.acftexample.data.Event
import com.ods.acftexample.data.Mdl
import com.ods.acftexample.data.Spt
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.Duration
import javax.inject.Inject

@HiltViewModel
class ScorecardViewModel @Inject constructor(
    private val acftService: AcftService
) : AcftAppViewModel() {

    var age = mutableStateOf("")
    val genderList = listOf("male", "female")
    var selectedGender = mutableStateOf("")

    fun updateAge(): String {
        if (age.value == "") {
            acftService.getAge(18)
        } else {
            try {
                acftService.getAge(age.value.toByte())
            } catch (e: IllegalArgumentException) {
                Toast.makeText(AcftActivity(), "Please enter valid data", Toast.LENGTH_SHORT).show()
            }
        }
        return age.value
    }

    fun updateGender(): String {
        if (selectedGender.value == "") {
            acftService.getGender("male")
        } else {
            try {
                acftService.getGender(selectedGender.value)
            } catch (e: IllegalArgumentException) {
                Toast.makeText(AcftActivity(), "Please enter valid data", Toast.LENGTH_SHORT).show()
            }
        }
        return selectedGender.value
    }
}



//    fun ageToByte(age: String): Byte {
//        return if (age == "") {
//            18
//        } else {
//            age.toByte()
//        }
//    }


//    private fun getScorecard() = acftService.getScorecard()
//    private fun getMdlEvents(raw: Short) = acftService.getMdl(raw)
//    private fun getSptEvents(raw: Double) = acftService.getSpt(raw)
//    fun events(): MutableList<Event> =
//        getScorecard().toMutableStateList()
//    fun mdlEvents(): MutableList<Mdl> = getMdlEvents(mdlRawToShort()).toMutableStateList()
//    fun sptEvents(): MutableList<Spt> = getSptEvents(sptRawToDouble()).toMutableStateList()


//    private fun getAge(): Byte {
//        return if (acftService.age.value == "") {
//            println("Age to Int default: 18")
//            18
//        } else {
//            println("Age to Byte: ${acftService.age.value.toByte()}")
//            acftService.age.value.toByte()
//        }
//    }

//    fun updateGender(text: String) {
//        println("Update gender: $text")
//        acftService.gender.value = text
//    }

//    private fun getGender(): String {
//        return if (acftService.gender.value == "") {
//            "male"
//        } else {
//            acftService.gender.value
//        }
//    }

    //region MDL Logic
//    private val _mdlRaw = mutableStateOf("")
//
//    val mdlRaw: State<String> = _mdlRaw
//
//    fun updateMdl(text: String) {
//        println("Update mdl raw: ${_mdlRaw.value}")
//        _mdlRaw.value = text
//    }
//
//    private fun mdlRawToShort(): Short {
//        return if (_mdlRaw.value.isEmpty()) {
//            println("mdl to Int default: 0")
//            0
//        } else {
//            println("mdl to Int: ${_mdlRaw.value.toInt()}")
//            _mdlRaw.value.toShort()
//        }
//    }
//    fun mdlToMap(): Map<Short, Short> {
//        val mdlMap = mutableMapOf<Short, Short>()
//        mdlEvents().map {
//            mdlMap.put(key = it.raw, value = it.points)
//        }
//        println("mdlToMap() from VM ${mdlMap.toMap()}")
//        return mdlMap
//    }
//    fun mdlPoints(): Short {
//        mdlToMap().map { item ->
//            if (item.key == mdlRawToShort()) {
//                println("mdlPoints() from VM ${item.value}")
//                return item.value
//            } else {
//                val maxValue = mdlToMap().maxBy { it.key }
//                if (maxValue.key <= mdlRawToShort()) {
//                    println("mdl max from VM ${maxValue}")
//                    return 100
//                }
//            }
//        }
//        println("mdlPoints() default value: 0")
//        return 0
//    }
    //endregion

    //region SPT Logic
//    private val _sptRaw = mutableStateOf("")
//
//    val sptRaw: State<String> = _sptRaw
//
//    fun updateSpt(text: String) {
//        _sptRaw.value = text
//    }
//
//    private fun sptRawToDouble(): Double {
//        return if (_sptRaw.value.isEmpty()) {
//            0.0
//        } else if (_sptRaw.value.contains(",")) {
//            _sptRaw.value = ""
//            _sptRaw.value.toDouble()
//        } else {
//            _sptRaw.value.toDouble()
//        }
//    }
    //endregion