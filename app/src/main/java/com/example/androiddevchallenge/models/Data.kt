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
package com.example.androiddevchallenge.models

import com.example.androiddevchallenge.R

fun getPositionList(): List<Position> {
    return listOf(
        Position("$7,918", "-0.54%", "ALK", "Alaska Air Group, Inc.", false),
        Position("$1,293", "+4.18%", "BA", "Boeing Co.", true),
        Position("$893.50", "-0.54%", "DAL", "Delta Airlines Inc.", false),
        Position("$12,301", "+2.51%", "EXPE", "Expedia Group Inc.", true),
        Position("$12,301", "+1.38%", "EADSY", "Airbus SE", true),
        Position("$8,521", "+1.56%", "JBLU", "Jetblue Airways Corp.", true),
        Position("$521", "+2.75%", "MAR", "Marriott International Inc", true),
        Position("$5,481", "+0.14%", "CCL", "Carnival Corp", true),
        Position("$9,184", "+1.69%", "RCL", "Royal caribbean Cruises", true),
        Position("$654", "+3.23%", "TRVL", "Travelocity Inc", true),
    )
}

fun getGraphDrawable(name: String): Int {
    return when (name) {
        "ALK" -> R.drawable.home_alk
        "BA" -> R.drawable.home_ba
        "DAL" -> R.drawable.home_dal
        "EXPE" -> R.drawable.home_exp
        "EADSY" -> R.drawable.home_eadsy
        "JBLU" -> R.drawable.home_jblu
        "MAR" -> R.drawable.home_mar
        "CCL" -> R.drawable.home_ccl
        "RCL" -> R.drawable.home_rcl
        "TRVL" -> R.drawable.home_trvl
        else -> R.drawable.home_alk
    }
}
