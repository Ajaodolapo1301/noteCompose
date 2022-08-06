//package com.example.mymovieapplication.navigation
package com.example.notes.navigation

enum class AppScreens{
    HomeScreen,
    DetailsScreen;


    companion object  {
        fun fromRoutes(route: String?): AppScreens = when (route?.substringBefore("/")){
            HomeScreen.name  -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route does not exist")
        }
    }
}