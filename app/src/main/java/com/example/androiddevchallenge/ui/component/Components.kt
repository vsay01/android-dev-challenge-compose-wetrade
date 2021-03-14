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
package com.example.androiddevchallenge.ui

import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.models.Position
import com.example.androiddevchallenge.models.getGraphDrawable
import com.example.androiddevchallenge.models.getPositionList
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.green
import com.example.androiddevchallenge.ui.theme.red

@Composable
fun StockListItem(stock: Position) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = stock.currentValue,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier
                        .paddingFromBaseline(24.dp)
                )
                Text(
                    text = stock.currentRate,
                    style = MaterialTheme.typography.body1,
                    color = if (stock.isIncrease) green else red,
                    modifier = Modifier
                        .paddingFromBaseline(16.dp)
                )
            }
            Spacer(Modifier.width(28.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth(0.7f)
            ) {
                Text(
                    text = stock.name,
                    style = MaterialTheme.typography.h3,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier.paddingFromBaseline(24.dp)
                )
                Text(
                    text = stock.fullName,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier
                        .paddingFromBaseline(16.dp)
                )
            }
            Spacer(Modifier.width(12.dp))
            Image(
                modifier = Modifier
                    .clip(MaterialTheme.shapes.small)
                    .size(64.dp),
                painter = painterResource(id = getGraphDrawable(stock.name)),
                contentDescription = "${stock.name} stock image"
            )
        }
        Divider(
            color = Color.Gray,
            modifier = Modifier
                .fillMaxWidth()
                .width(1.dp)
                .padding(start = 16.dp, end = 16.dp)
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewStockListItem() {
    MyTheme {
        Surface(color = MaterialTheme.colors.secondary) {
            StockListItem(getPositionList()[2])
        }
    }
}

@Composable
fun setStatusBarTransparent(window: Window) =
    MaterialTheme {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }

@Composable
fun hideSystemUi(window: Window) {
    window.decorView.systemUiVisibility = (
        View.SYSTEM_UI_FLAG_IMMERSIVE
            // Set the content to appear under the system bars so that the
            // content doesn't resize when the system bars hide and show.
            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            // Hide the nav bar and status bar
            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_FULLSCREEN
        )
}
