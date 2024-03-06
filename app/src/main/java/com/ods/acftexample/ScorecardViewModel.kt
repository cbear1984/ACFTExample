package com.ods.acftexample

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import com.ods.acftexample.data.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScorecardViewModel @Inject constructor(
    private val acftService: AcftService,
) : AcftAppViewModel() {

    // from service
    private fun getScorecard(gender: String, age: Byte) =
        acftService.getScorecard(gender = gender, age = age)

    // lists
    fun events(): MutableList<Event> =
        getScorecard(getGender(), getAge()).toMutableStateList()

    //region Age Logic
    private val _age = mutableStateOf("")

    val age: State<String> = _age

    fun updateAge(text: String) {
        println("Update age: ${_age.value}")
        _age.value = text
    }

    private fun getAge(): Byte {
        return if (_age.value == "") {
            println("Age to Int default: 18")
            18
        } else {
            println("Age to Byte: ${_age.value.toByte()}")
            _age.value.toByte()
        }
    }
    //endregion

    //region Gender Logic
    private val _gender = mutableStateOf("male")

    val gender: State<String> = _gender

    fun updateGender(text: String) {
        println("Update gender: $text")
        _gender.value = text
    }

    private fun getGender(): String {
        return if (_gender.value == "") {
            "male"
        } else {
            _gender.value
        }
    }
    //endregion

    //region MDL Logic
    private val _mdlRaw = mutableStateOf("")

    val mdlRaw: State<String> = _mdlRaw

    fun updateMdl(text: String) {
        println("Update mdl raw: ${_mdlRaw.value}")
        _mdlRaw.value = text
    }

    private fun mdlRawToInt(): Int {
        return if (_mdlRaw.value.isEmpty()) {
            println("mdl to Int default: 0")
            0
        } else {
            println("mdl to Int: ${_mdlRaw.value.toInt()}")
            _mdlRaw.value.toInt()
        }
    }
}