//package com.example.notes.navigation
//
//import HomeScreen
//import androidx.compose.runtime.Composable
//import androidx.navigation.NavType
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import androidx.navigation.navArgument
//import com.example.mymovieapplication.screens.DetailsScreen
//
//
//@Composable
//
//
//fun AppNavigation (){
//    var navigationController = rememberNavController()
//   NavHost(navController = navigationController, startDestination = AppScreens.HomeScreen.name, ){
//       composable(route = AppScreens.HomeScreen.name){
//        HomeScreen(navController = navigationController)
//       }
//
//
//       composable(route = AppScreens.DetailsScreen.name+ "/{movie}",
//
//           arguments = listOf(navArgument(name = "movie", ){ type= NavType.StringType})
//           )
//       {
//           backStackEntry ->
//           DetailsScreen(navController = navigationController,
//               backStackEntry.arguments?.getString("movie")
//           )
//       }
//   }
//}