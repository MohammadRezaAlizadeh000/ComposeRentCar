package com.mra.rentcarcompose.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.core.os.bundleOf
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import coil.compose.AsyncImage
import com.google.gson.Gson
import com.mra.rentcar.model.CarModel
import com.mra.rentcar.utils.Toast
import com.mra.rentcarcompose.R
import com.mra.rentcarcompose.navigation.BOOKING_CAR_SCREEN_ROUTE
import com.mra.rentcarcompose.navigation.CAR_DATA_ARGUMENT_KEY
import com.mra.rentcarcompose.utils.navigate
import com.mra.rentcarcompose.viewmodel.CarsListViewModel

@Composable
fun CarsListScreen(
    navController: NavController,
    viewModel: CarsListViewModel = hiltViewModel()
) {
    viewModel.getAllCars()

    viewModel.carsResultFlow.collectAsState().value.also {
        it.data?.let { result ->
            SetData(result) { carModel ->
                navController.navigate(BOOKING_CAR_SCREEN_ROUTE, carModel)
            }
        }

        it.message?.let { message -> Toast(message = message) }
    }
}

@Composable
fun SetData(
    list: List<CarModel>,
    onItemClickListener: (CarModel) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(list.size) {
                CarListRow(carModel = list[it]) { onItemClickListener(it) }
            }
        }
    }
}

@Composable
fun CarListRow(
    carModel: CarModel,
    onItemClickListener: (CarModel) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(170.dp)
            .padding(top = 6.dp, bottom = 6.dp, start = 12.dp, end = 12.dp)
            .clickable(enabled = true) { onItemClickListener(carModel) },
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 8.dp, end = 8.dp)
        ) {
            Card(
                modifier = Modifier
                    .width(0.dp)
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(top = 8.dp, bottom = 8.dp),
            ) {
                AsyncImage(
                    model = carModel.carImage,
                    contentDescription = carModel.make,
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop,
                )
            }

            CarDataView(
                carModel = carModel,
                sameHeight = true,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp, top = 8.dp)
            )
        }
    }

}

@Composable
fun CarDataView(carModel: CarModel?, sameHeight: Boolean, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        val textModifier = if (sameHeight) Modifier.fillMaxWidth().weight(1f) else Modifier.fillMaxWidth().padding(top = 4.dp)

        Text(
            text = "${stringResource(id = R.string.carMakeLabel)} ${carModel?.make}",
            modifier = textModifier
        )
        Text(
            text = "${stringResource(id = R.string.carModelLabel)} ${carModel?.model}",
            modifier = textModifier
        )
        Text(
            text = "${stringResource(id = R.string.carYearLabel)} ${carModel?.year}",
            modifier = textModifier
        )
        Text(
            text = "${stringResource(id = R.string.carLocationLabel)} ${carModel?.location}",
            modifier = textModifier
        )
        Text(
            text = "${stringResource(id = R.string.carPriceLabel)} ${carModel?.price}",
            modifier = textModifier
        )
    }
}