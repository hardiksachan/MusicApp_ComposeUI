package com.hardiksachan.musicapp_composeui.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hardiksachan.musicapp_composeui.R
import com.hardiksachan.musicapp_composeui.ui.SongProvider
import com.hardiksachan.musicapp_composeui.ui.model.Song

@Composable
fun HomeScreen(handleThemeSwitch: () -> Unit) {
    Scaffold(
        topBar = {
            GreetingSection(
                Modifier.padding(
                    horizontal = 32.dp,
                    vertical = 16.dp
                )
            ) { handleThemeSwitch() }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(start = 32.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ) {
            itemsIndexed(
                items = listOf(
                    "recent activity" to listOf(
                        SongProvider.allTooWell,
                        SongProvider.beAlright,
                        SongProvider.loveStory
                    ),
                    "trending tracks" to listOf(
                        SongProvider.itsYou,
                        SongProvider.driversLicense,
                        SongProvider.loveMeLikeYouDo
                    ),
                    "recommended" to listOf(
                        SongProvider.loseYouToLoveMe,
                        SongProvider.arcade,
                        SongProvider.youBrokeMeFirst
                    )
                )
            ) { _, sectionPair ->
                SongsRow(title = sectionPair.first, songs = sectionPair.second)
            }
        }
    }
}


@Composable
fun GreetingSection(
    modifier: Modifier = Modifier,
    handleThemeSwitch: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "hey there.",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.W500,
            letterSpacing = (-1.5).sp,
        )
        Icon(
            painter = painterResource(
                id = if (MaterialTheme.colors.isLight)
                    R.drawable.ic_sun
                else
                    R.drawable.ic_moon
            ),
            contentDescription = "theme icon",
            modifier = Modifier
                .size(28.dp)
                .padding(bottom = 8.dp)
                .clickable {
                    handleThemeSwitch()
                },
        )
    }
}

@Composable
fun SongsRow(
    title: String,
    songs: List<Song>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.h5,
            )
            Icon(
                painter = painterResource(R.drawable.ic_right_arrow),
                contentDescription = "right arrow",
                modifier = Modifier
                    .size(28.dp)
                    .padding(bottom = 8.dp)
            )
        }

        LazyRow(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            itemsIndexed(songs) { _, song ->
                SongCard(song = song, modifier = Modifier.padding(end = 16.dp))
            }
        }
    }
}

@Composable
fun SongCard(
    song: Song,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = song.image),
            contentDescription = song.name,
            modifier = Modifier
                .size(125.dp)
                .clip(MaterialTheme.shapes.large),
        )
        Spacer(modifier = Modifier.padding(vertical = 2.dp))
        Text(
            text = song.name,
            style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.W600,
            letterSpacing = (-0.5).sp

        )

        Spacer(modifier = Modifier.padding(vertical = 1.dp))
        Text(text = song.artist, style = MaterialTheme.typography.body2)
    }
}