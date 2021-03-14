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
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.getPositionList
import com.example.androiddevchallenge.ui.StockListItem
import com.example.androiddevchallenge.ui.hideSystemUi
import com.example.androiddevchallenge.ui.setStatusBarTransparent
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.gray900

var shouldMainContentVisible: Boolean by mutableStateOf(true)
var shouldStockContentVisible: Boolean by mutableStateOf(false)

@Composable
fun HomeScreen() {
    val window = (LocalContext.current as Activity).window
    setStatusBarTransparent(window = window)
    hideSystemUi(window = window)
    Surface(color = MaterialTheme.colors.background) {
        Box {
            ShowMainContent(isVisible = shouldMainContentVisible)
            ShowStockList(isVisible = shouldStockContentVisible)
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ShowMainContent(isVisible: Boolean) {
    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically(
            // Enters by sliding in from offset -fullHeight to 0.
            initialOffsetY = { fullHeight -> fullHeight },
            animationSpec = tween(durationMillis = 150, easing = LinearOutSlowInEasing)
        ),
        exit = slideOutVertically(
            // Exits by sliding out from offset 0 to -fullHeight.
            targetOffsetY = { fullHeight -> fullHeight },
            animationSpec = tween(durationMillis = 250, easing = FastOutLinearInEasing)
        )
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        TextButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .weight(1f)
                                .paddingFromBaseline(64.dp)
                        ) {
                            Text(
                                text = "ACCOUNT",
                                style = MaterialTheme.typography.button,
                                color = Color.White
                            )
                        }
                        TextButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .weight(1f)
                                .paddingFromBaseline(64.dp)
                        ) {
                            Text(
                                text = "WATCHLIST",
                                style = MaterialTheme.typography.button,
                                color = Color.Gray
                            )
                        }
                        TextButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .weight(1f)
                                .paddingFromBaseline(64.dp)
                        ) {
                            Text(
                                text = "PROFILE",
                                style = MaterialTheme.typography.button,
                                color = Color.Gray
                            )
                        }
                    }
                    Text(
                        text = "Balance",
                        style = MaterialTheme.typography.subtitle1,
                        color = Color.White,
                        modifier = Modifier
                            .paddingFromBaseline(32.dp)
                            .padding(top = 8.dp)
                    )
                    Text(
                        text = "$73,589.01",
                        style = MaterialTheme.typography.h1,
                        color = Color.White,
                        modifier = Modifier
                            .paddingFromBaseline(48.dp)
                            .padding(top = 8.dp)
                    )
                    Text(
                        text = "+412.35 today",
                        style = MaterialTheme.typography.subtitle1,
                        color = Color.Green,
                        modifier = Modifier
                            .paddingFromBaseline(16.dp)
                            .padding(top = 24.dp)
                    )
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(top = 32.dp)
                            .height(48.dp)
                            .fillMaxWidth(0.9f),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.colors.primary,
                            contentColor = gray900
                        ),
                        shape = RoundedCornerShape(50)
                    ) {
                        Text(text = "TRANSACT")
                    }
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = Modifier
                            .padding(start = 16.dp, top = 16.dp)
                            .height(40.dp)
                    ) {
                        item {
                            OutlinedButton(
                                onClick = { },
                                modifier = Modifier
                                    .height(48.dp)
                                    .weight(1f)
                                    .fillMaxWidth(0.4f)
                                    .padding(end = 16.dp),
                                border = BorderStroke(1.dp, Color.White),
                                colors = ButtonDefaults.outlinedButtonColors(
                                    contentColor = Color.White,
                                    backgroundColor = Color.Transparent
                                ),
                                shape = RoundedCornerShape(50),
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(text = "Week")
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_baseline_expand_more_24),
                                        contentDescription = "Expand icon"
                                    )
                                }
                            }
                        }
                        item {
                            OutlinedButton(
                                onClick = { },
                                modifier = Modifier
                                    .height(48.dp)
                                    .weight(1f)
                                    .fillMaxWidth(0.4f)
                                    .padding(end = 16.dp),
                                border = BorderStroke(1.dp, Color.White),
                                colors = ButtonDefaults.outlinedButtonColors(
                                    contentColor = Color.White,
                                    backgroundColor = Color.Transparent
                                ),
                                shape = RoundedCornerShape(50),
                            ) {
                                Text(text = "ETFs")
                            }
                        }
                        item {
                            OutlinedButton(
                                onClick = { },
                                modifier = Modifier
                                    .height(48.dp)
                                    .weight(1f)
                                    .fillMaxWidth(0.4f)
                                    .padding(end = 16.dp),
                                border = BorderStroke(1.dp, Color.White),
                                colors = ButtonDefaults.outlinedButtonColors(
                                    contentColor = Color.White,
                                    backgroundColor = Color.Transparent
                                ),
                                shape = RoundedCornerShape(50)
                            ) {
                                Text(text = "Stocks")
                            }
                        }
                        item {
                            OutlinedButton(
                                onClick = { },
                                modifier = Modifier
                                    .height(48.dp)
                                    .weight(1f)
                                    .fillMaxWidth(0.4f)
                                    .padding(end = 16.dp),
                                border = BorderStroke(1.dp, Color.White),
                                colors = ButtonDefaults.outlinedButtonColors(
                                    contentColor = Color.White,
                                    backgroundColor = Color.Transparent
                                ),
                                shape = RoundedCornerShape(50)
                            ) {
                                Text(text = "Funds")
                            }
                        }
                        item {
                            OutlinedButton(
                                onClick = { },
                                modifier = Modifier
                                    .height(48.dp)
                                    .weight(1f)
                                    .fillMaxWidth(0.4f)
                                    .padding(end = 16.dp),
                                border = BorderStroke(1.dp, Color.White),
                                colors = ButtonDefaults.outlinedButtonColors(
                                    contentColor = Color.White,
                                    backgroundColor = Color.Transparent
                                ),
                                shape = RoundedCornerShape(50)
                            ) {
                                Text(text = "Dividend")
                            }
                        }
                    }
                    Image(
                        modifier = Modifier.padding(top = 16.dp),
                        painter = painterResource(id = R.drawable.home_illos),
                        contentDescription = "chart image"
                    )
                    Column(modifier = Modifier.fillMaxSize()) {
                        Button(
                            onClick = {
                                shouldStockContentVisible = true
                                shouldMainContentVisible = false
                            },
                            modifier = Modifier
                                .padding(top = 32.dp)
                                .fillMaxSize(),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = MaterialTheme.colors.surface,
                                contentColor = gray900
                            ),
                            shape = RoundedCornerShape(0)
                        ) {
                            Text(
                                text = "Positions",
                                style = MaterialTheme.typography.subtitle1,
                                color = MaterialTheme.colors.onSurface,
                                modifier = Modifier.paddingFromBaseline(top = 40.dp, bottom = 22.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ShowStockList(isVisible: Boolean) {
    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically(
            // Enters by sliding in from offset -fullHeight to 0.
            initialOffsetY = { fullHeight -> -fullHeight },
            animationSpec = tween(durationMillis = 150, easing = LinearOutSlowInEasing)
        ),
        exit = slideOutVertically(
            // Exits by sliding out from offset 0 to -fullHeight.
            targetOffsetY = { fullHeight -> -fullHeight },
            animationSpec = tween(durationMillis = 250, easing = FastOutLinearInEasing)
        )
    ) {
        val stockList = getPositionList()
        Surface(color = MaterialTheme.colors.secondary) {
            Column {
                OutlinedButton(
                    onClick = {
                        shouldMainContentVisible = true
                        shouldStockContentVisible = false
                    },
                    modifier = Modifier
                        .padding(bottom = 24.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Transparent,
                        contentColor = gray900
                    ),
                    border = BorderStroke(0.dp, Color.Transparent),
                    shape = RoundedCornerShape(0),
                ) {
                    Text(
                        text = "Positions",
                        color = MaterialTheme.colors.onSurface,
                        modifier = Modifier.paddingFromBaseline(top = 40.dp),
                    )
                }
                Divider(
                    color = Color.Gray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(1.dp)
                        .padding(start = 16.dp, end = 16.dp)
                )
                LazyColumn {
                    items(stockList) { item ->
                        StockListItem(stock = item)
                    }
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewHome() {
    MyTheme {
        HomeScreen()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewHome() {
    MyTheme(darkTheme = true) {
        HomeScreen()
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewShowList() {
    MyTheme {
        ShowStockList(true)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewShowList() {
    MyTheme(darkTheme = true) {
        ShowStockList(true)
    }
}
