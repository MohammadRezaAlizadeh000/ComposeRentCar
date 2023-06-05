package com.mra.rentcarcompose.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.mra.rentcarcompose.R
import com.mra.rentcarcompose.navigation.CARS_LIST_SCREEN_ROUTE

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun LoginScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            GlideImage(
//                painter = painterResource(R.drawable.ic_launcher_background),
                model = "https://wahadventures.com/wp-content/uploads/2021/08/Ways-to-Make-Money-Renting-Out-Your-Car-1024x576.jpg",
                contentDescription = "loginImage",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                contentScale = ContentScale.Crop
            )


            Text(
                text = stringResource(id = R.string.login),
                fontWeight = FontWeight.Bold,
                fontSize = 60.sp,
                color = colorResource(id = R.color.darkBlue),
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Column(
            modifier = Modifier.weight(1.3f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var username by remember { mutableStateOf("") }
            OutlinedTextField(
                value = username,
                label = {
                    Text(text = stringResource(id = R.string.username))
                },
                onValueChange = {
                    username = it
                },
                maxLines = 1,
                textStyle = TextStyle(fontSize = 20.sp),
                modifier = Modifier
                    .padding(top = 30.dp, end = 12.dp, start = 12.dp)
                    .fillMaxWidth()
            )

            var password by remember { mutableStateOf("") }
            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                },
                label = {
                    Text(text = stringResource(id = R.string.password))
                },
                maxLines = 1,
                textStyle = TextStyle(fontSize = 20.sp),
                modifier = Modifier
                    .padding(top = 20.dp, end = 12.dp, start = 12.dp)
                    .fillMaxWidth()
            )

            Button(
                onClick = {
                    navController.navigate(CARS_LIST_SCREEN_ROUTE)
                },
                modifier = Modifier
                    .padding(top = 30.dp, end = 12.dp, start = 12.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.darkBlue)
                ),
                shape = RoundedCornerShape(10.dp)


            ) {
                Text(
                    modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                    text = stringResource(id = R.string.login),
                    color = colorResource(id = R.color.white)
                )
            }
        }

    }
}