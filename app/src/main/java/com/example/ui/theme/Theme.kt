package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = HighlightBlue,
    onPrimary = Color.White,
    primaryContainer = DarkSurfaceElevated,
    onPrimaryContainer = Color.White,
    secondary = HighlightPurple,
    onSecondary = Color.White,
    secondaryContainer = DarkSurfaceCard,
    onSecondaryContainer = DarkTextWhite,
    tertiary = HighlightGreen,
    onTertiary = Color.White,
    background = DarkPureBlack,
    onBackground = DarkTextWhite,
    surface = DarkSurfaceElevated,
    onSurface = DarkTextWhite,
    surfaceVariant = DarkSurfaceCard,
    onSurfaceVariant = DarkTextSecondary,
    outline = DarkBorderLine,
    error = HighlightRed,
    onError = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = HighlightBlue,
    onPrimary = Color.White,
    primaryContainer = HighlightBlueLight,
    onPrimaryContainer = HighlightBlueDark,
    secondary = HighlightPurple,
    onSecondary = Color.White,
    secondaryContainer = HighlightPurpleLight,
    onSecondaryContainer = HighlightPurpleDark,
    tertiary = HighlightGreen,
    onTertiary = Color.White,
    tertiaryContainer = HighlightGreenLight,
    onTertiaryContainer = HighlightGreenDark,
    background = CleanPureWhite,
    onBackground = TextBlack,
    surface = CleanPureWhite,
    onSurface = TextBlack,
    surfaceVariant = CleanSurfaceVariant,
    onSurfaceVariant = TextDarkGray,
    outline = CleanBorder,
    error = HighlightRed,
    onError = Color.White,
    errorContainer = HighlightRedLight,
    onErrorContainer = HighlightRedDark
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
