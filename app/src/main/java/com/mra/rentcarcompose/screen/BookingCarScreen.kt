package com.mra.rentcarcompose.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.BundleCompat.getParcelable
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.mra.rentcar.model.CarModel
import com.mra.rentcarcompose.R
import com.mra.rentcarcompose.navigation.CAR_DATA_ARGUMENT_KEY

@Composable
fun BookingCarScreen(
    navController: NavController,
    carModel: CarModel?
) {

//    val carModel = navController.previousBackStackEntry?.arguments
//        ?.getParcelable<CarModel>(CAR_DATA_ARGUMENT_KEY)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp, end = 30.dp)
    ) {



        Text(
            text = stringResource(id = R.string.booking),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            fontSize = 60.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.darkBlue),
            textAlign = TextAlign.Center
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 12.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            AsyncImage(
                model = carModel?.carImage,
                contentDescription = carModel?.make,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        CarDataView(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 12.dp),
            carModel = carModel,
            sameHeight = false
        )

        Text(
            text = stringResource(id = R.string.bookingInformation),
            modifier = Modifier.padding(top = 30.dp),
            fontSize = 20.sp
        )

        var startDateTime by remember { mutableStateOf("") }
        OutlinedTextField(
            value = startDateTime,
            onValueChange = { startDateTime = it },
            label = {
                Text(text = stringResource(id = R.string.startDateLabel))
            },
            modifier = Modifier.fillMaxWidth().padding(top = 12.dp),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "Icons.Default.DateRange",
                    Modifier.clickable { }
                )
            }
        )

        var endDateTime by remember { mutableStateOf("") }
        OutlinedTextField(
            value = endDateTime,
            onValueChange = { endDateTime = it },
            label = {
                Text(text = stringResource(id = R.string.endDateLabel))
            },
            modifier = Modifier.fillMaxWidth().padding(top = 12.dp),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "Icons.Default.DateRange",
                    Modifier.clickable { }
                )
            }
        )

        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)) {
            Button(
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.gray)),
                shape = RoundedCornerShape(10.dp),
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text(text = stringResource(id = R.string.back))
            }

            Button(
                modifier = Modifier.weight(2f).padding(start = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.darkBlue)),
                shape = RoundedCornerShape(10.dp),
                onClick = {

                }
            ) {
                Text(text = stringResource(id = R.string.confirm))
            }
        }
    }

}