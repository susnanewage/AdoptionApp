package com.example.adoptionapp.ui.theme.puppy

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.adoptionapp.R
import com.example.adoptionapp.model.DataProvider
import com.example.adoptionapp.model.PuppyModel

@Composable
fun PuppyDetails(puppyModel: PuppyModel, navController: NavHostController) {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(text = "Puppy Details") },
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack, contentDescription = "Menu Btn",
                        modifier = Modifier
                            .clickable {
                                navController.navigateUp()
                            },
                    )
                }
            },
            backgroundColor = Color.Black,
            contentColor = Color.White,
        )
        BoxWithConstraints(modifier = Modifier.weight(1f)) {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState),
                ) {
                    ProfileHeader(
                        scrollState,
                        puppyModel,
                        this@BoxWithConstraints.maxHeight
                    )
                    ProfileContent(puppyModel, this@BoxWithConstraints.maxHeight)
                }
            }
        }
    }
}

@Composable
private fun ProfileHeader(
    scrollState: ScrollState,
    puppyModel: PuppyModel,
    containerHeight: Dp
) {
    val offset = (scrollState.value / 2)
    val offsetDp = with(LocalDensity.current) { offset.toDp() }

    Image(
        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .fillMaxWidth()
            .padding(top = offsetDp),
        painter = painterResource(id = puppyModel.img ?: 0),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}

@Composable
private fun ProfileContent(puppyModel: PuppyModel, containerHeight: Dp) {
    val context = LocalContext.current
    Column {
        Spacer(modifier = Modifier.height(8.dp))

        Name(puppyModel)

        ProfileProperty(stringResource(R.string.sex), puppyModel.sex ?: "")

        ProfileProperty(stringResource(R.string.orgin), puppyModel.orgin ?: "")

        ProfileProperty(stringResource(R.string.color), puppyModel.color ?: "")

        ProfileProperty(stringResource(R.string.overView), puppyModel.description ?: "")

        Button(
            onClick = {
                Toast.makeText(context, "Adopted ${puppyModel.name}", Toast.LENGTH_SHORT).show()
            }, colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Black
            ),
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Adopt ${puppyModel.name}",
                style = TextStyle(
                    color = Color.White
                ),
                modifier = Modifier.padding(10.dp)
            )
        }

        Spacer(Modifier.height((containerHeight - 320.dp).coerceAtLeast(0.dp)))
    }
}

@Composable
private fun Name(
    puppyModel: PuppyModel
) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Name(
            puppy = puppyModel,
            modifier = Modifier.paddingFromBaseline(32.dp)
        )
    }
}

@Composable
private fun Name(puppy: PuppyModel, modifier: Modifier = Modifier) {
    Text(
        text = puppy.name ?: "",
        modifier = modifier,
        style = MaterialTheme.typography.h5,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ProfileProperty(label: String, value: String, isLink: Boolean = false) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Divider()
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = label,
                style = MaterialTheme.typography.caption,
            )
        }
        val style = if (isLink) {
            MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.primary)
        } else {
            MaterialTheme.typography.body1
        }
        Text(
            text = value,
            style = style
        )
    }
}

@Preview
@Composable
fun ProfilePreview() {
    val puppy = DataProvider.puppyModel
    val navController = rememberNavController()
    PuppyDetails(puppyModel = puppy, navController = navController)
}
