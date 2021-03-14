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
package com.example.androiddevchallenge.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R

// Set of Material typography styles to start with
val typography = Typography(
    h1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_extrabold)),
        fontWeight = FontWeight.ExtraBold,
        fontSize = 40.sp,
        letterSpacing = 1.25.sp
    ),
    h2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_extrabold)),
        fontWeight = FontWeight.ExtraBold,
        fontSize = 36.sp
    ),
    h3 = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 13.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_medium)),
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp
    ),
    body1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_light)),
        fontWeight = FontWeight.Light,
        fontSize = 13.sp
    ),
    button = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 13.sp,
        letterSpacing = 1.25.sp
    )
)
