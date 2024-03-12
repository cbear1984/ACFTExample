package com.ods.acftexample

import com.ods.acftexample.data.Mdl
import com.ods.acftexample.data.Spt

interface AcftService {
    fun getAge(age: Byte)
    fun getGender(gender: String)
    fun getMdl(raw: Short): List<Mdl>
    fun getSpt(raw: Double): List<Spt>
}