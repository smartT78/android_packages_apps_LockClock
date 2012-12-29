/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cyanogenmod.lockclock.misc;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.os.Bundle;

import com.cyanogenmod.lockclock.R;

public class WidgetUtils {
    static final String TAG = "WidgetUtils";

    // Decide if to show the Weather
    // Check to see if the widget size is big enough, if it is return true.
    public static boolean canFitWeather(Context context, int id) {
        Bundle options = AppWidgetManager.getInstance(context).getAppWidgetOptions(id);
        if (options == null) {
            // no data to make the calculation, show the list anyway
            return true;
        }
        int minHeight = options.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT);
        int neededSize = (int) context.getResources().getDimension(R.dimen.min_weather_widget_height);
        return (minHeight > neededSize);
    }

    // Decide if to show the Calendar
    // Check to see if the widget size is big enough, if it is return true.
    public static boolean canFitCalendar(Context context, int id) {
        Bundle options = AppWidgetManager.getInstance(context).getAppWidgetOptions(id);
        if (options == null) {
            // no data to make the calculation, show the list anyway
            return true;
        }
        int minHeight = options.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT);
        int neededSize = (int) context.getResources().getDimension(R.dimen.min_calendar_widget_height);
        return (minHeight > neededSize);
    }
}