package com.ods.acftexample

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate
import java.util.Calendar
import java.util.Date
import kotlin.coroutines.suspendCoroutine

@AndroidEntryPoint
class AcftActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AcftApp()
        }
    }
}

@Composable
fun AcftApp(
    viewModel: ScorecardViewModel = hiltViewModel()
) {
    var genderSelected by remember { mutableStateOf(true) }
    var personalSelected by remember { mutableStateOf(true) }
    var personal by remember { mutableStateOf("yes") }



    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Bottom app bar",
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .verticalScroll(rememberScrollState()),
            Arrangement.spacedBy(20.dp),
            Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                Arrangement.SpaceBetween,
                Alignment.CenterVertically
            ) {
                Text("Age")
                TextField(
                    modifier = Modifier.size(width = 150.dp, height = 50.dp),
                    value = viewModel.age.value,
                    onValueChange = { newAge ->
                        viewModel.updateAge(newAge)
                        viewModel.events()
//                        viewModel.getEvents()
                    },
                    placeholder = {
                        Text(text = "Age", fontSize = 12.sp)
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                Arrangement.SpaceBetween,
                Alignment.CenterVertically
            ) {
                Text("Gender")
                Switch(
                    checked = genderSelected,
                    onCheckedChange = { selected ->
                        genderSelected = selected
                        if (!genderSelected) {
                            viewModel.updateGender("female")
                            viewModel.events()
                        } else {
                            viewModel.updateGender("male")
                            viewModel.events()
                        }
                    }
                )
                Text(viewModel.gender.value)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                Arrangement.SpaceBetween,
                Alignment.CenterVertically
            ) {
                Text("MDL")
                TextField(
                    modifier = Modifier.size(width = 150.dp, height = 50.dp),
                    value = viewModel.mdlRaw.value,
                    onValueChange = { newRaw ->
                        viewModel.updateMdl(newRaw)
                    },
                    placeholder = {
                        Text(text = "replace with standard format", fontSize = 12.sp)
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }
//            Text(viewModel.getMdlPoints().toString())
        }
    }
}


//val mContext = LocalContext.current
//    val mYear: Int
//    val mMonth: Int
//    val mDay: Int
//    val mCalendar = Calendar.getInstance()
//    mYear = mCalendar.get(Calendar.YEAR)
//    mMonth = mCalendar.get(Calendar.MONTH)
//    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)
//
//    mCalendar.time = Date()
//    val mDate = remember { mutableStateOf("${LocalDate.now()}") }
//    val mDatePickerDialog = DatePickerDialog(
//        mContext,
//        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
//            mDate.value = "$mYear-${mMonth + 1}-$mDayOfMonth"
//        }, mYear, mMonth, mDay
//    )

//Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(10.dp),
//                Arrangement.SpaceBetween,
//                Alignment.CenterVertically
//            ) {
//                Text("Test date")
//                Button(onClick = {
//                    mDatePickerDialog.show()
//                }) {
//                    Text(text = mDate.value, fontSize = 12.sp, textAlign = TextAlign.Center)
//                }
//            }
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(10.dp),
//                Arrangement.SpaceBetween,
//                Alignment.CenterVertically
//            ) {
//                Text("Personal test?")
//                Switch(
//                    checked = personalSelected,
//                    onCheckedChange = { isOn ->
//                        personalSelected = isOn
//                        personal = if (!personalSelected) {
//                            "no"
//                        } else {
//                            "yes"
//                        }
//                    }
//                )
//                Text(personal)
//            }