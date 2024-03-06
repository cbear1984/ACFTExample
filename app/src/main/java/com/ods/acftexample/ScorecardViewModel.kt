package com.ods.acftexample

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import com.ods.acftexample.data.Scorecards
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
    fun events(): MutableList<Scorecards> =
        getScorecard(getGender(), getAge()).toMutableStateList()

//    fun getEvents() {
//        println("Events from VM............: ${events().toList()}")
//        val mdl = events().map { it.mdl }
//        println("MDL from VM............: ${mdl}")
//    }
//
//    val listSpt: MutableList<Scorecard.Event.Spt>
//        get() = getSptList()

//    private fun getMdlList(): MutableList<Scorecard.Event.Mdl> {
//        listEvents.forEach {
//            println("MDL from VM: ${it.mdl}")
//            return mutableListOf(it.mdl)
//        }
//        println("Something went wrong getting MDL List")
//        return mutableListOf()
//    }
//
//    private fun getSptList(): MutableList<Scorecard.Event.Spt> {
//        listEvents.forEach {
//            println("SPT from VM: ${it.spt}")
//            return mutableListOf(it.spt)
//        }
//        println("Something went wrong getting SPT List")
//        return mutableListOf()
//    }


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

//    fun getMdlPoints(): Int {
//        val mdlMap = mutableMapOf<Int, Int>()
//        _listMdl.map { items ->
//            mdlMap.put(items.raw, items.points)
//        }
//        mdlMap.map { (k, v) ->
//            if (k == mdlRawToInt()) {
//                return v
//            }
//        }
//        return 0
//    }
    //endregion

    //region SPT Logic
//    private val _sptRaw = mutableStateOf("")
//
//    val sptRaw: State<String> = _sptRaw
//
//    fun updateSpt(text: String) {
//        println("Update spt raw: ${_sptRaw.value}")
//        _sptRaw.value = text
//    }
//
//    private fun sptRawToDouble(): Double {
//        return if (_sptRaw.value.isEmpty()) {
//            println("spt to Double default: 0.0")
//            0.0
//        } else {
//            println("spt to Double: ${_sptRaw.value.toDouble()}")
//            _sptRaw.value.toDouble()
//        }
//    }
//

//
//    fun getSptPoints(): Int {
//        val sptMap = mutableMapOf<Double, Int>()
//        _listSpt.map { items ->
//            sptMap.put(items.raw, items.points)
//        }
//        sptMap.map { (k, v) ->
//            if (k == sptRawToDouble()) {
//                return v
//            }
//        }
//        return 0
//    }
    //endregion

//    private fun getMdlMap() {
//        println("Update mdl: $mdl")
//        mdl.addAll(acftService.getMdlMap())
//    }

//
//    fun getSptMap(): List<Spt> {
//        events.forEach {
//            it.spt.addAll(spt)
//            println("spt map: ${spt.toList()}")
//            return spt
//        }
//        return spt
//    }
//    fun getHrpMap(): List<Hrp> {
//        events.forEach {
//            it.hrp.addAll(hrp)
//            println("hrp map: ${hrp.toList()}")
//            return hrp
//        }
//        return hrp
//    }

//    fun getMdlPoints(): Int {
//        return acftService.getMdlPoints(mdlRawToInt())
//    }
// Standing Power Throw //
//    fun updateSpt(text: String) {
//        println("Update textfield spt raw: ${_sptRaw.value}")
//        _sptRaw.value = text
//    }

//    private fun sptRawToDouble(): Double {
//        return if (_sptRaw.value.isEmpty()) {
//            println("spt to Double default: 0.0")
//            0.0
//        } else {
//            println("spt to Double: ${_sptRaw.value.toDouble()}")
////            _sptRaw.value.toDouble()
//            11.0
//        }
//    }

//    private fun getSptMap() {
//      println("Update spt..........: ${spt.toList()}")
//        spt.addAll(acftService.getSptMap())
//
//    }

//    fun getSptPoints(): Int {
//        return acftService.getSptPoints(sptRawToDouble())
//    }
//    // Hand release push-ups //
//    fun updateHrp(text: String) {
//        println("Update hrp raw: ${_hrpRaw.value}")
//        _hrpRaw.value = text
//    }

//    private fun hrpRawToInt(): Int {
//        return if (_hrpRaw.value.isEmpty()) {
//            println("hrp to Int default: 0")
//            0
//        } else {
//            println("hrp to Int: ${_hrpRaw.value.toInt()}")
//            _hrpRaw.value.toInt()
//        }
//    }

//    private fun getHrpMap() {
//        println("Update mdl: $hrp")
//        hrp.addAll(acftService.getHrpMap())
//    }

//    fun getHrpPoints(): Int {
//        return acftService.getHrpPoints(hrpRawToInt())
//    }
}

//    val listMdl: List<Mdl>
//        get() = _listMdl

//    private val _sptRaw = mutableStateOf("")
//    private val _hrpRaw = mutableStateOf("")
//    private val _sdcRaw = mutableStateOf("")
//    private val _plkRaw = mutableStateOf("")
//    private val _tmrRaw = mutableStateOf("")
//    private val _altRaw = mutableStateOf("")

//    private var _listSpt = getEvents().toMutableStateList()
//    private var _listHrp = getEvents().toMutableStateList()
//    private var _listSdc = getEvents().toMutableStateList()
//    private var _listPlk = getEvents().toMutableStateList()
//    private var _listTmr = getEvents().toMutableStateList()
//    private var _listWlk = getEvents().toMutableStateList()
//    private var _listBke = getEvents().toMutableStateList()
//    private var _listRow = getEvents().toMutableStateList()
//    private var _listSwm = getEvents().toMutableStateList()

//    val mdlRaw: State<String> = _mdlRaw
//    val sptRaw: State<String> = _sptRaw
//    val hrpRaw: State<String> = _hrpRaw
//    val sdcRaw: State<String> = _sdcRaw
//    val plkRaw: State<String> = _plkRaw
//    val tmrRaw: State<String> = _tmrRaw
//    val altRaw: State<String> = _altRaw

//    var listEvents = getEvents().toMutableStateList()
//    private var scorecard = mutableStateListOf<Scorecard>()
//    private var events = mutableStateListOf<Events>()
//    private var mdl = mutableStateListOf<Mdl>()
//    private var spt = mutableStateListOf<Spt>()
//    private var hrp = mutableStateListOf<Hrp>()
//    private var sdc = mutableStateListOf<Sdc>()
//    private var plk = mutableStateListOf<Plk>()
//    private var tmr = mutableStateListOf<Tmr>()
//    private var wlk = mutableStateListOf<Wlk>()
//    private var bke = mutableStateListOf<Bke>()
//    private var row = mutableStateListOf<Row>()
//    private var swm = mutableStateListOf<Swm>()

//fun getMdlMap(): List<Mdl> {
//        events.forEach {
//             it.mdl.addAll(mdl)
//            println("mdl map: ${mdl.toList()}")
//            return mdl
//        }
//        return mdl
//    }