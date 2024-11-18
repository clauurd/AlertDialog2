package com.example.alertdialog2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alertdialog2.ui.theme.AlertDialog2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlertDialog2Theme {
                MiInterfaz()
                }
            }
        }
    }


@Composable
fun MiInterfaz() {
    val contactos = listOf(
        "Anabel Perez",
        "Bruno Redondo",
        "Lukasz Chojnacky",
        "Beatriz Navea",
        "Jony Melabo",
        "Claudio Redondo",
        "Alejandro Salvestrini",
        "Nuria López",
        "Claudia Sierra",
        "Monica Manuela Gutiérrez",
        "Maria Ramos"


    )

    // Contenedor principal que incluye la barra superior, lista de contactos y botón flotante
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(16.dp)
    ) {
        // Barra superior con título
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Black)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Contactos",
                color = Color.White,
                style = TextStyle(fontFamily = FontFamily.Monospace),
                modifier = Modifier.weight(1f) // Centrar el texto en el espacio disponible
            )
        }

        Spacer(modifier = Modifier.height(5.dp))

        // Column para la lista de contactos
        Column(
            modifier = Modifier
                .weight(1f)  // Llenar el espacio restante
                .padding(8.dp)
        ) {
            contactos.forEach { contacto ->
                ContactoItem(nombre = contacto)
                Divider() // Divisor entre los contactos
            }
        }



        // Botón flotante para agregar contacto
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            FloatingActionButton(onClick = { /* Acción para agregar un contacto */ }) {
                Icon(Icons.Default.Add, contentDescription = "Agregar Contacto")
            }
        }
        Spacer(modifier = Modifier.height(35.dp))
    }
}

@Composable
fun ContactoItem(nombre: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        // Avatar con iniciales
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(48.dp)
                .background(color = Color.Blue, CircleShape)
        ) {
            Text(
                text = nombre.take(2).uppercase(),
                color = Color.White,
                style = TextStyle(fontFamily = FontFamily.Monospace)
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        // Nombre del contacto
        Text(
            text = nombre,
            style = TextStyle(fontFamily = FontFamily.Monospace)

        )
    }
}

