package dev.codeninja.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.codeninja.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ArtSpaceTheme {
				// A surface container using the 'background' color from the theme
				Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
					ArtSpaceScreen()
				}
			}
		}
	}
}

@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {
	val firstArtwork = R.drawable.aristotlel
	val secondArtwork = R.drawable.avreliy
	val thirdArtwork = R.drawable.pifagor
	val fourthArtwork = R.drawable.socrat

	var title by remember {
		mutableStateOf(R.string.aristotel)
	}

	var say by remember {
		mutableStateOf(R.string.aristotel_say)
	}

	var currentArtwork by remember {
		mutableStateOf(firstArtwork)
	}

	var imageResource by remember {
		mutableStateOf(currentArtwork)
	}


	Column(
		modifier = modifier
			.fillMaxWidth(),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		ArtworkDisplay(currentArtwork = currentArtwork)
		Spacer(modifier = modifier.size(16.dp))
		ArtworkTitle(title = title, say = say)
		Spacer(modifier = modifier.size(25.dp))
		Row(
			modifier = modifier.padding(horizontal = 8.dp),
			horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
		) {
			// Previous Button
			Button(
				onClick = {
					when (currentArtwork) {
						firstArtwork -> {
							currentArtwork = secondArtwork
							title = R.string.avreliy
							say = R.string.avreliy_say
						}
						secondArtwork -> {
							currentArtwork = thirdArtwork
							title = R.string.pifagor
							say = R.string.pidagor_say
						}
						thirdArtwork -> {
							currentArtwork = fourthArtwork
							title = R.string.socrat
							say = R.string.socrat_say
						}
						else -> {
							currentArtwork = firstArtwork
							title = R.string.aristotel
							say = R.string.aristotel_say
						}
					}
				},
				colors = ButtonDefaults.buttonColors(
					backgroundColor = colorResource(id = R.color.gray_900)
				),
				elevation = ButtonDefaults.elevation(
					defaultElevation = 1.dp,
					pressedElevation = 0.dp,
					focusedElevation = 0.dp
				)
			) {
				Text(
					text = "Previous",
					fontSize = 16.sp,
					color = colorResource(id = R.color.blue_300)
				)
			}

			// Next Button
			Button(
				onClick = {
					when (currentArtwork) {
						firstArtwork -> {
							currentArtwork = secondArtwork
							title = R.string.avreliy
							say = R.string.avreliy_say
						}
						secondArtwork -> {
							currentArtwork = thirdArtwork
							title = R.string.pifagor
							say = R.string.pidagor_say
						}
						thirdArtwork -> {
							currentArtwork = fourthArtwork
							title = R.string.socrat
							say = R.string.socrat_say
						}
						else -> {
							currentArtwork = firstArtwork
							title = R.string.aristotel
							say = R.string.aristotel_say
						}
					}
				},
				colors = ButtonDefaults.buttonColors(
					backgroundColor = colorResource(id = R.color.blue_300)
				),
				elevation = ButtonDefaults.elevation(
					defaultElevation = 1.dp,
					pressedElevation = 0.dp,
					focusedElevation = 0.dp
				)
			) {
				Text(
					text = "Next",
					fontSize = 16.sp,
					color = colorResource(id = R.color.gray_900)
				)
			}
		}
	}
}

@Composable
fun ArtworkDisplay(
	modifier: Modifier = Modifier,
	@DrawableRes currentArtwork: Int
) {
	Image(
		painter = painterResource(currentArtwork),
		contentDescription = stringResource(id = R.string.avreliy),
		modifier = modifier.fillMaxWidth(),
		contentScale = ContentScale.FillWidth
	)
}

@Composable
fun ArtworkTitle(
	@StringRes title: Int,
	@StringRes say: Int
) {
	Column (
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		// Artwork title
		Text(
			text = stringResource(id = title),
			fontWeight = FontWeight.Bold,
			color = colorResource(id = R.color.blue_100),
			fontSize = 32.sp
		)
		
		// Artwork say
		Text(
			text = "${stringResource(id = say)}",
			fontSize = 16.sp,
			fontWeight = FontWeight.Medium,
			color = colorResource(id = R.color.gray_300)
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