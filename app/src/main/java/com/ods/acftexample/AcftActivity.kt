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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
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
    val focusManager = LocalFocusManager.current
    focusManager.clearFocus()


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
            // Date Picker
            DatePicker()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                Arrangement.SpaceBetween,
                Alignment.CenterVertically
            ) {
                Text("Personal test?")
                Switch(
                    checked = personalSelected,
                    onCheckedChange = { isOn ->
                        personalSelected = isOn
                    }
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                Arrangement.SpaceBetween,
                Alignment.CenterVertically
            ) {
                Text("Age")
                OutlinedTextField(
                    value = viewModel.age.value,
                    onValueChange = { newAge ->
                        viewModel.age.value = newAge
                    },
                    label = { Text(text = "Enter your age") },
                    colors = TextFieldDefaults.colors(
                        focusedLabelColor = Color.Black,
                        unfocusedLabelColor = Color.Black,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier.size(300.dp, 60.dp),
                    textStyle = TextStyle(fontSize = 18.sp, color = Color.Black),
                    shape = RoundedCornerShape(5.dp),
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done,
                        keyboardType = KeyboardType.Number
                    ),
                    keyboardActions = KeyboardActions(onDone = {
                        viewModel.updateAge()
                        focusManager.clearFocus()
                    }),
                )
            }
            SegmentedPicker(
                items = viewModel.genderList,
                selectedItem = viewModel.selectedGender
            ) {
                val color = if (it == viewModel.selectedGender.value) Color.White else Color.Black
                viewModel.updateGender()
                Row(
                    modifier =
                    Modifier
                        .padding(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = it,
                        color = color
                    )
                }
            }
        }
    }
}

@Composable
fun DatePicker() {
    val mContext = LocalContext.current
    val mYear: Int
    val mMonth: Int
    val mDay: Int
    val mCalendar = Calendar.getInstance()
    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    mCalendar.time = Date()
    val mDate = remember { mutableStateOf("${LocalDate.now()}") }
    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            mDate.value = "$mYear-${mMonth + 1}-$mDayOfMonth"
        }, mYear, mMonth, mDay
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        Arrangement.SpaceBetween,
        Alignment.CenterVertically
    ) {
        Text("Test date")
        Button(onClick = {
            mDatePickerDialog.show()
        }) {
            Text(text = mDate.value, fontSize = 12.sp, textAlign = TextAlign.Center)
        }
    }
}



