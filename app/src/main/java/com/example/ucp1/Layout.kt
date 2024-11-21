package com.example.p4


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ucp1.R

@Preview(showBackground = true)
@Composable
fun Input (modifier: Modifier = Modifier) {

    var nama by remember { mutableStateOf("") }
    var origin by remember { mutableStateOf("") }
    var departure by remember { mutableStateOf("") }
    var arrival by remember { mutableStateOf("") }
    var transport by remember { mutableStateOf("") }

    val dataT = listOf("Bus", "Ship", "Train", "Plane")

    var simpanNama by remember { mutableStateOf("") }
    var simpanOrigin by remember { mutableStateOf("") }
    var simpanDeparture by remember { mutableStateOf("") }
    var simpanArrival by remember { mutableStateOf("") }
    var simpanTransport by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TampilanHeader()
        Text(
            text = "Biodata",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),

            value = nama,
            onValueChange = { nama = it },
            label = { Text("Origin") },

        )


        Row(
            modifier = Modifier.padding(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            dataT.forEach { type ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(end = 5.dp)
                ) {
                    RadioButton(
                        selected = (transport == type),
                        onClick = { transport = type }
                    )
                    Text(transport)
                }
            }
        }

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = departure,
            onValueChange = { departure = it },
            label = { Text("Departure") },

        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = arrival,
            onValueChange = { arrival = it },
            label = { Text("Arrival") },

        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = transport,
            onValueChange = { transport = it },
            label = { Text("Transport") }
        )

        Button(
            onClick = {
                simpanNama = nama
                simpanOrigin = origin
                simpanDeparture = departure
                simpanArrival = arrival
                simpanTransport = transport
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)

        ) {
            Text("Submit")
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column {
                TampilData(judul = "Origin", isinya = simpanNama)
                TampilData(judul = "Departure", isinya = simpanDeparture)
                TampilData(judul = "Arrival", isinya = simpanArrival)
                TampilData(judul = "Transport", isinya = simpanTransport)
            }
        }
    }
}

@Composable
fun TampilanHeader(){
    Box(modifier = Modifier.fillMaxWidth()
        .background(Color.Blue)
        .padding(20.dp)){
        Row {
            Box(contentAlignment = Alignment.BottomEnd){
                Image(
                    painterResource(R.drawable.foto),
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp)

                )

                Icon(
                    Icons.Default.Done, contentDescription = null,
                    modifier = Modifier
                        .background(color = Color.Red, shape = CircleShape),
                    tint = Color.DarkGray)

            }
            Column(modifier = Modifier.padding(20.dp)) {
                Text("Muhammad Azmi Anshari",
                    color = Color.White,
                    fontSize = 20.sp)
                Spacer(modifier = Modifier.padding(5.dp))
                Text("Kota Tasikmalaya",
                    color = Color.White,
                    fontSize = 17.sp)
            }
        }
    }
}

@Composable
fun TampilData(
    judul: String,
    isinya: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(judul, modifier = Modifier.weight(0.8f))
        Text(":", modifier = Modifier.weight(0.2f))
        Text(isinya, modifier = Modifier.weight(2f))
    }
}
