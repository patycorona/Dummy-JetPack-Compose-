package com.example.jetpackcompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme

private val messages: List<MainActivity.myMessage> = listOf(
    MainActivity.myMessage("¡Hola JETPACK COMPOSE", "¿Preparado?, Un texto es una composición de signos codificados en un sistema de escritura que forma una unidad de sentido. Detalle de texto en inglés (sobre papel)."),
    MainActivity.myMessage("¡Hola JETPACK COMPOSE_1", "¿Preparado?, Un texto es una composición de signos codificados"),
    MainActivity.myMessage("¡Hola JETPACK COMPOSE_2", "¿Preparado?, sistema de escritura que forma una unidad de sentido."),
    MainActivity.myMessage("¡Hola JETPACK COMPOSE_3", "¿Preparado?, Arte de la expresión escrita o hablada.\n" +
            "\"la lírica, la narrativa y el teatro Forman parte de la literatura\""),
    MainActivity.myMessage("¡Hola JETPACK COMPOSE_4", "¿Preparado?, 101 paisajes que te harán viajar a otro mundo. Si disfrutas contemplando un paisaje de ensueño, no puedes perderte a los ganadores"),
    MainActivity.myMessage("¡Hola JETPACK COMPOSE_5", "¿Preparado?, Descargue fotos de Paisajes naturales de stock "),
    MainActivity.myMessage("¡Hola JETPACK COMPOSE_6", "¿Preparado?, Algunos filósofos han dejado frases para la historia y por ello, hemos decidido recopilar algunas de las mejores frases dichas por filósofos."),
    MainActivity.myMessage("¡Hola JETPACK COMPOSE_7", "¿Preparado?, La verdad, la mentira, la mujer o la libertad han sido motivo de atención para los filósofos desde la Antigua Grecia hasta el día de hoy. Te invitamos a continuación con estas citas a reflexionar."),
    MainActivity.myMessage("¡Hola JETPACK COMPOSE_8", "¿Preparado?, La libertad está en ser dueños de la propia vida"),
    MainActivity.myMessage("¡Hola JETPACK COMPOSE_9", "¿Preparado?, Si me engañas una vez, tuya es la culpa; si me engañas dos, es mía"),
    MainActivity.myMessage("¡Hola JETPACK COMPOSE_10", "¿Preparado?, No hagas a otros aquello que no te gustaría que te hicieran a ti, ni te hagas a ti lo que no le harías a los demás"),
    MainActivity.myMessage("¡Hola JETPACK COMPOSE_11", "¿Preparado?, La educación genera confianza. La confianza genera esperanza. La esperanza genera paz. Confucio. ... La suerte favorece sólo a la mente preparada. Isaac Asimov."),
    MainActivity.myMessage("¡Hola JETPACK COMPOSE_12", "¿Preparado?, Espacio se refiere a una colección de objetos entre los que pueden definirse relaciones de adyacencia y cercanía. En contextos específicos, puede tomar un sentido mucho más abstracto. Generalmente se refiere al espacio físico, el espacio geográfico o el espacio exterior.")
)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //indica que todo lo que situemos dentro deberan ser elementos composable
        // elementos que van a conformar la UI
        setContent{
            JetPackComposeTheme() {
                myMessages(messages)
            }
        }
    }

    @Composable
    fun myMessages(message: List<myMessage>){
        //se encarga de dibujar solo los elementos que se estan vizualizando en la panatalla
        //y hasta que se desliza se esque se pintan los demas elementos
        LazyColumn{
            items(message){ message ->
                myComponente(message = message)
            }
        }
    }

    @Composable
    fun myComponente(message:myMessage){
        Row(
            Modifier
                .background(MaterialTheme.colors.background)
                .padding(8.dp)) {
            myImage()
            myTexts(message)
        }
    }

    data class myMessage(val title:String, val body:String)

    @Composable
    fun myImage(){
        Image(
            painterResource(R.drawable.ic_launcher_foreground),
            "Mi Imagen de Prueba",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colors.primary)
        )
    }

    @Composable
    fun myTexts(message: myMessage){

        var expanded by remember{ mutableStateOf(false)}

        Column(Modifier.padding(start = 8.dp).clickable {
            expanded = !expanded
        }){
            myText(message.title,
                MaterialTheme.colors.primaryVariant,
                MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = Modifier.height(16.dp))
            myText(message.body,
                MaterialTheme.colors.onBackground,
                MaterialTheme.typography.subtitle2,
                if(expanded) Int.MAX_VALUE else 1
            )
        }
    }

    @Composable
    fun myText(text:String, color:Color, style: TextStyle, lines:Int = Int.MAX_VALUE ){
        Text(text, color = color, style = style, maxLines = lines)
    }

    @Preview(showSystemUi = true)// para visualizar la pantalla completa
    @Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
    @Composable
    fun preViewComponent(){
        JetPackComposeTheme {
            myMessages(messages)
        }
    }

//Lista
//    @Preview(showSystemUi = true)// para visualizar la pantalla completa
//    @Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
//    @Composable
//    fun preViewComponent(){
//        JetPackComposeTheme {
//            //Hace referencia a una función pertenenciente a jetpack compose que nos
//            //proporciona una implementacion por defecto del estado del scroll
//            val scrollState = rememberScrollState()
//
//            Column(modifier = Modifier.verticalScroll(scrollState)) {
//                myComponente()
//                myComponente()
//                myComponente()
//                myComponente()
//                myComponente()
//                myComponente()
//                myComponente()
//                myComponente()
//                myComponente()
//                myComponente()
//                myComponente()
//            }
//        }
//    }

}

