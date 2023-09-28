package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {

    val imagesResources = listOf(
        R.drawable._1_gustabe_dore,
        R.drawable._2_gustave_dore,
        R.drawable._3_gustave_dore,
        R.drawable._4_gustave_dore,
        R.drawable._5_gustave_dore,
        R.drawable._6_gustave_dore,
        R.drawable._7_gustave_dore,
        R.drawable._8_joseph_pisan,
        R.drawable._9_gustave_dore,
        R.drawable._0_sacha_schneider,
    )

    val titles = listOf(
        R.string.firstArtwork,
        R.string.secondArtwork,
        R.string.thirdArtwork,
        R.string.fourthArtwork,
        R.string.fifthArtwork,
        R.string.sixthArtwork,
        R.string.seventhArtwork,
        R.string.eighthArtwork,
        R.string.ninthArtwork,
        R.string.tenthArtwork,
    )

    val years = listOf(
        R.string.firstArtwork_year,
        R.string.secondArtwork_year,
        R.string.thirdArtwork_year,
        R.string.fourthArtwork_year,
        R.string.fifthArtwork_year,
        R.string.sixthArtwork_year,
        R.string.seventhArtwork_year,
        R.string.eighthArtwork_year,
        R.string.ninthArtwork_year,
        R.string.tenthArtwork_year,
    )

    val descriptions = listOf(
        R.string.firstArtwork_description,
        R.string.secondArtwork_description,
        R.string.thirdArtwork_description,
        R.string.fourthArtwork_description,
        R.string.fifthArtwork_description,
        R.string.sixthArtwork_description,
        R.string.seventhArtwork_description,
        R.string.eighthArtwork_description,
        R.string.ninthArtwork_description,
        R.string.tenthArtwork_description,
    )


    var currentIndex by remember { mutableStateOf(0) }

    fun previousImage() {
        currentIndex = (currentIndex - 1).coerceIn(0, imagesResources.size - 1)
    }

    fun restartImage() {
        currentIndex = 0
    }

    fun nextImage() {
        currentIndex = (currentIndex + 1).coerceIn(0, imagesResources.size - 1)
    }


    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,

        ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(28.dp))
                .background(colorResource(R.color.teal_100))
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = stringResource(R.string.author))
        }

        ArtworkTextAndImage(
            currentArtwork = imagesResources[currentIndex],
            title = titles[currentIndex],
            year = years[currentIndex],
            description = descriptions[currentIndex],
        )

        Row(
            modifier = modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(14.dp)

        ) {
            Button(
                onClick = { previousImage() },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 4.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.teal_200)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp,
                )
            ) {
                Text(
                    text = stringResource(R.string.previous),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }

            IconButton(
                onClick = { restartImage() },
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(28.dp))
                    .background(colorResource(id = R.color.teal_100))
            ) {
                Icon(
                    Icons.Rounded.Refresh,
                    contentDescription = "Restart Images"
                )
            }

            Button(
                onClick = { nextImage() },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 4.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.teal_200)
                ),

                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                ),
            ) {
                Text(
                    text = stringResource(R.string.next),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }
        }
    }
}

@Composable
fun ArtworkTextAndImage(
    @DrawableRes currentArtwork: Int,
    @StringRes title: Int,
    @StringRes year: Int,
    @StringRes description: Int
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,


        ) {
        Box(
            modifier = Modifier
                .height(440.dp)
                .clip(RoundedCornerShape(28.dp))
                .border(3.dp, colorResource(id = R.color.teal_200), RoundedCornerShape(28.dp))

        ) {
            ArtworkImage(
                modifier = Modifier.fillMaxSize(),
                currentArtwork = currentArtwork,
            )
        }


        Spacer(
            modifier = Modifier.size(5.dp)
        )
        ArtworkTitle(
            title = title,
            year = year,
            description = description
        )
    }

}


@Composable
fun ArtworkImage(
    @DrawableRes currentArtwork: Int,
    modifier: Modifier
) {
    Image(
        painter = painterResource(id = currentArtwork),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}

@Composable
fun ArtworkTitle(
    @StringRes title: Int,
    @StringRes year: Int,
    @StringRes description: Int,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = title),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.teal_700),
            fontSize = 22.sp,
        )
        Text(
            text = stringResource(id = year),
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.gray_300),
            fontSize = 16.sp,
        )
        Text(
            text = stringResource(R.string.illustrated_by, stringResource(id = description)),
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.gray_300),
            fontSize = 16.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}

