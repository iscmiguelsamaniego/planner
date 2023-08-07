package org.samtech.planner.ui

import org.samtech.planner.R

sealed class BottomNavItem(
    var title: String,
    var icon: Int
) {
    object Calendar :
        BottomNavItem(
            "Reloj", //TODO extrac string resource
            R.drawable.ic_clock
        )

    object Home :
        BottomNavItem(
            "Hoy",
            R.drawable.ic_calendar
        )
}