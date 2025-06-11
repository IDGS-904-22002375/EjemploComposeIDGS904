package com.example.ejemplo1composeidgs904

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejemplo1composeidgs904.ui.theme.Ejemplo1ComposeIDGS904Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ejemplo1ComposeIDGS904Theme {
                ListaPersonajes()
            }
        }
    }
}

data class Personaje(val nombre: String, val descripcion: String, val imagenResId: Int)

val listaPersonajes = listOf(
    Personaje("Goku", "El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla. Sin embargo, el caer por un barranco le proporcionó un brutal golpe", R.drawable.goku),
    Personaje("Vegeta", "Príncipe de los Saiyans, inicialmente un villano, pero luego se une a los Z Fighters. A pesar de que a inicios de Dragon Ball Z, Vegeta cumple un papel antagónico, poco después decide rebelarse ante el Imperio de Freeza", R.drawable.vegeta),
    Personaje("Piccolo", "Es un namekiano que surgió tras ser creado en los últimos momentos de vida de su padre, siendo su actual reencarnación. Aunque en un principio fue el archienemigo de Son Goku, con el paso del tiempo fue haciéndose menos malvado hasta finalmente convertirse en un ser bondadoso", R.drawable.personaje3),
    Personaje("Bulma", "Bulma es la protagonista femenina de la serie manga Dragon Ball y sus adaptaciones al anime Dragon Ball, Dragon Ball Z, Dragon Ball Super y Dragon Ball GT. Es hija del Dr. Brief y su esposa Panchy, hermana menor de Tights", R.drawable.bulma),
    Personaje("Freezer", "Freezer es el tirano espacial y el principal antagonista de la saga de Freezer", R.drawable.personaje1),
    Personaje("Zarbon", "Zarbon es uno de los secuaces de Freezer y un luchador poderoso", R.drawable.zarbon),
    Personaje("Dodoria", "Dodoria es otro secuaz de Freezer conocido por su brutalidad", R.drawable.dodoria),
    Personaje("Ginyu", "Ginyu es el líder del la élite de mercenarios de mayor prestigio del Ejército de Freeza, la cual lleva el nombre de Fuerzas Especiales Ginew en su honor", R.drawable.ginyu)


)

@Composable
fun ListaPersonajes() {
    LazyColumn(modifier = Modifier.padding(8.dp)) {
        items(listaPersonajes) { personaje ->
            Tarjeta(personaje)
        }
    }
}

@Composable
fun Tarjeta(personaje: Personaje) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            ImagenHeroe(personaje.imagenResId)
            Spacer(modifier = Modifier.width(8.dp))
            PersonajeDescripcion(personaje)
        }
    }
}

@Composable
fun ImagenHeroe(resId: Int) {
    Image(
        painter = painterResource(id = resId),
        contentDescription = null,
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
            .padding(4.dp)
    )
}

@Composable
fun PersonajeDescripcion(personaje: Personaje) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Nombre: ${personaje.nombre}", style = MaterialTheme.typography.titleMedium)
        Text(text = "Descripción: ${personaje.descripcion}", style = MaterialTheme.typography.bodySmall)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTarjeta() {
    Ejemplo1ComposeIDGS904Theme {
        ListaPersonajes()
    }
}
