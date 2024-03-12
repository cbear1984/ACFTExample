package com.ods.acftexample.data

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.internal.*

@Serializable
data class Scorecards(
    val scorecards: List<Scorecard> = listOf(Scorecard(
            id = "",
            group = 0,
            gender = "male",
            events =
            listOf(Event(
                id = "",
                mdl = listOf(Mdl(id = "", points = 0, raw = 0)),
                spt = listOf(Spt(id = "", points = 0, raw = 0.0)),
                hrp = listOf(Hrp(id = "", points = 0, raw = 0)),
                sdc = listOf(Sdc(id = "", points = 0, raw = "0")),
                plk = listOf(Plk(id = "", points = 0, raw = "0")),
                tmr = listOf(Tmr(id = "", points = 0, raw = "0")),
                wlk = listOf(Wlk(id = "", points = 0, raw = "0")),
                bke = listOf(Bke(id = "", points = 0, raw = "0")),
                swm = listOf(Swm(id = "", points = 0, raw = "0")),
                row = listOf(Row(id = "", points = 0, raw = "0"))
            ))
        ))
)

@Serializable
data class Scorecard(
    val id: String,
    val group: Byte,
    val gender: String,
    val events: List<Event>
)

@Serializable
data class Event(
    val id: String,
    val mdl: List<Mdl>? = null,
    val spt: List<Spt>? = null,
    val hrp: List<Hrp>? = null,
    val sdc: List<Sdc>? = null,
    val plk: List<Plk>? = null,
    val tmr: List<Tmr>? = null,
    val wlk: List<Wlk>? = null,
    val bke: List<Bke>? = null,
    val swm: List<Swm>? = null,
    val row: List<Row>? = null
)

@Serializable
data class Mdl(
    val id: String,
    val points: Short,
    val raw: Short
)

@Serializable
data class Spt(
    val id: String,
    val points: Short,
    val raw: Double
)

@Serializable
data class Hrp(
    val id: String,
    val points: Short,
    val raw: Short
)

@Serializable
data class Sdc(
    val id: String,
    val points: Short,
    val raw: String
)

@Serializable
data class Plk(
    val id: String,
    val points: Short,
    val raw: String
)

@Serializable
data class Tmr(
    val id: String,
    val points: Short,
    val raw: String
)

@Serializable
data class Wlk(
    val id: String,
    val points: Short,
    val raw: String
)

@Serializable
data class Bke(
    val id: String,
    val points: Short,
    val raw: String
)

@Serializable
data class Swm(
    val id: String,
    val points: Short,
    val raw: String
)

@Serializable
data class Row(
    val id: String,
    val points: Short,
    val raw: String
)

//Scorecard(
//id = "", group = 0, gender = "male", events = Scorecard.Event(
//id = "",
//mdl = Scorecard.Event.Mdl(id = "", points = 0, raw = 0),
//spt = Scorecard.Event.Spt(id = "", points = 0, raw = 0.0),
//hrp = Scorecard.Event.Hrp(id = "", points = 0, raw = 0),
//sdc = Scorecard.Event.Sdc(id = "", points = 0, raw = ""),
//plk = Scorecard.Event.Plk(id = "", points = 0, raw = ""),
//tmr = Scorecard.Event.Tmr(id = "", points = 0, raw = ""),
//wlk = Scorecard.Event.Wlk(id = "", points = 0, raw = ""),
//bke = Scorecard.Event.Bke(id = "", points = 0, raw = ""),
//swm = Scorecard.Event.Swm(id = "", points = 0, raw = ""),
//row = Scorecard.Event.Row(id = "", points = 0, raw = "")
//)
//)