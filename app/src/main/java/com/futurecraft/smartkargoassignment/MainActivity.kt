package com.futurecraft.smartkargoassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.futurecraft.smartkargoassignment.navigation.AppNavigation
import com.futurecraft.smartkargoassignment.ui.theme.SmartKargoAssignmentTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartKargoAssignmentTheme {
                AppNavigation()
            }
        }
    }


}

