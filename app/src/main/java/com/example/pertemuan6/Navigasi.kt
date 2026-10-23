package com.example.pertemuan6

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pertemuan6.view.FormIsian
import com.example.pertemuan6.view.TampilData

enum class Navigasi {
    FormulirSaya,
    Detail
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Navigasi.FormulirSaya.name
    ) {
        composable(route = Navigasi.FormulirSaya.name) {
            FormIsian(
                OnSubmitBtnClick = {
                    navController.navigate(Navigasi.Detail.name)
                }
            )
        }
        composable(route = Navigasi.Detail.name) {
            TampilData(
                onBackBtnClick = {
                    cancelAndBackToFormulir(navController)
                }
            )
        }
    }
}

private fun cancelAndBackToFormulir(
    navController: NavHostController
) {
    navController.popBackStack(Navigasi.FormulirSaya.name, inclusive = false)
}