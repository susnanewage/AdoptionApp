package com.example.adoptionapp.ui.theme.puppy

import android.os.Bundle
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.adoptionapp.Routes
import com.example.adoptionapp.model.DataProvider
import com.example.adoptionapp.model.DataProvider.puppyList
import com.example.adoptionapp.model.PuppyModel
import com.example.adoptionapp.ui.theme.VerticalSpace


@Composable
fun PuppyList(navController: NavHostController) {
    Scaffold {
        HomeScreenContent(navController)
    }
}

@Composable
fun HomeScreenContent(navController: NavController) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
    ) {
        TopAppBar(title = { Text(text = "Adopt Me") })
        HomeSearchBar()
        PuppyHorizontalList(navController)
        PopularDogsList(navController)
    }
}

@Composable
fun PopularDogsList(navController: NavController) {
    VerticalSpace(value = 20.dp)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Text(
            text = "Popular Dogs",
            style = TextStyle(
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
    VerticalSpace(value = 10.dp)
    val books = puppyList.shuffled()
    books.forEach { book ->
        PopularDogsItem(book, navController)
        Divider(color = Color(0xFFE6E6E6))
    }
}

@Composable
fun PopularDogsItem(puppyModel: PuppyModel, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 15.dp)
            .clickable {
                puppyDetails(puppyModel, navController)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        NewDogItem(puppyModel = puppyModel, navController, maxWidth = 60.dp)
        Column(
            modifier = Modifier
                .padding(start = 10.dp)
                .weight(1f),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = puppyModel.name ?: "",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )

            Text(
                text = puppyModel.lifeSpan ?: "",
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                ),
                modifier = Modifier.padding(bottom = 5.dp)
            )

            Text(
                text = "Price: ${puppyModel.price}",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

@Composable
fun PuppyHorizontalList(navController: NavController) {
    VerticalSpace(value = 20.dp)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Text(
            text = "New Dogs",
            style = TextStyle(
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
    VerticalSpace(value = 10.dp)
    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(
            items = puppyList,
            itemContent = { item ->
                NewDogItem(item, navController)
            }
        )
    }
}

@Composable
fun NewDogItem(puppyModel: PuppyModel, navController: NavController, maxWidth: Dp = 140.dp) {
    Image(
        painter = painterResource(id = puppyModel.img ?: 0),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .width(maxWidth)
            .aspectRatio(0.75f)
            .size(70.dp)
            .background(
                color = Color.LightGray,
                shape = RoundedCornerShape(10.dp)
            )
            .clip(RoundedCornerShape(10.dp))
            .clickable {
                puppyDetails(puppyModel, navController)
            }
    )
}

@Composable
fun HomeSearchBar() {
    VerticalSpace(value = 10.dp)

    VerticalSpace(value = 5.dp)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Text(
            text = "Find Your Dogs",
            style = TextStyle(
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
    VerticalSpace(value = 20.dp)

    var searchTextFieldState by remember { mutableStateOf(TextFieldValue()) }
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = searchTextFieldState,
        onValueChange = { searchTextFieldState = it },
        shape = RoundedCornerShape(10.dp),
        placeholder = {
            Text(
                text = "Search Dogs",
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            backgroundColor = Color(0xFFF4F4F4)
        ),
        singleLine = true,
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        ),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                tint = Color.White,
                modifier = Modifier
                    .offset(x = 10.dp)
                    .background(
                        color = Color(0xFFC5A7E7),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .requiredSize(55.dp)
                    .padding(10.dp)
            )
        }
    )
}

fun puppyDetails(puppyModel: PuppyModel, navController: NavController) {
    navController.currentBackStackEntry?.arguments =
        Bundle().apply {
            putParcelable("puppy", puppyModel)
        }
    navController.navigate(Routes.PuppyDetails.route)
}

@Preview
@Composable
fun PreviewPuppyItem() {
    val puppy = DataProvider.puppyModel
    val navController = rememberNavController()
    Column() {
        TopAppBar(title = { Text(text = "Adopt Me") })
        PopularDogsItem(puppyModel = puppy, navController = navController)
    }
}
