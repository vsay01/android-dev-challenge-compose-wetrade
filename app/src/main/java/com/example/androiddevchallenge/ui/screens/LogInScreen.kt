/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screens

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.setStatusBarTransparent
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.gray900

@Composable
fun LoginScreen(navHostController: NavHostController) {
    setStatusBarTransparent((LocalContext.current as Activity).window)
    var email: String by mutableStateOf("")
    var password: String by mutableStateOf("")

    Surface(color = MaterialTheme.colors.secondary) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(id = R.drawable.login_bg),
                    contentDescription = "Login background image",
                    contentScale = ContentScale.FillWidth
                )
                Text(
                    modifier = Modifier
                        .paddingFromBaseline(152.dp)
                        .fillMaxWidth(),
                    text = "Welcome\nback",
                    style = MaterialTheme.typography.h2,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .padding(top = 40.dp)
                    .fillMaxWidth(0.9f)
                    .height(56.dp),
                label = {
                    Text(
                        text = "Email Address",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onSurface
                    )
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_mail_outline_24),
                        contentDescription = "Email outline icon"
                    )
                }
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(0.9f)
                    .height(56.dp),
                label = {
                    Text(
                        text = "Password",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onSurface
                    )
                },
                visualTransformation = PasswordVisualTransformation(),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_password_24px),
                        contentDescription = "Password outline icon"
                    )
                }
            )
            Button(
                onClick = { navHostController.navigate("home") },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .height(48.dp)
                    .fillMaxWidth(0.9f),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary,
                    contentColor = gray900
                ),
                shape = RoundedCornerShape(50)
            ) {
                Text(text = "LOG IN")
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewLogin() {
    MyTheme {
        LoginScreen(navHostController = rememberNavController())
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewLogin() {
    MyTheme(darkTheme = true) {
        LoginScreen(navHostController = rememberNavController())
    }
}
