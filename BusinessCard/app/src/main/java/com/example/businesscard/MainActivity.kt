package com.example.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Nickname
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Blue
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .padding(top = 260.dp)
            .fillMaxHeight()
    ) {
        MainInformation(
            image = painterResource(R.drawable.rock),
            fullName = stringResource(R.string.full_name),
            title = stringResource(R.string.title)
        )
        Contacts(
            phoneNumber = stringResource(R.string.phone_number),
            nickname = "@${stringResource(R.string.github_nick)}",
            email = stringResource(R.string.email)
        )
    }
}

@Composable
private fun MainInformation(
   image: Painter,
   fullName: String,
   title: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = fullName,
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp,
            lineHeight = 38.sp,
            textAlign = TextAlign.Center
        )
        Image(painter = image, contentDescription = null, Modifier.size(200.dp))
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
    }
}

@Composable
private fun ContactRow(
    text : String,
    icon : ImageVector,
    modifier: Modifier = Modifier
){
    Row(
        modifier
            .padding(horizontal = 20.dp, vertical = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(icon, contentDescription = null)
        Text(text = text, fontSize = 20.sp)
    }
}

@Composable
private fun Contacts(
    phoneNumber: String,
    nickname: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 15.dp)
    ) {
        ContactRow(text = phoneNumber, icon = Icons.Rounded.Call)
        ContactRow(text = nickname, icon = Icons.Rounded.Person)
        ContactRow(text = email, icon = Icons.Rounded.Email)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}