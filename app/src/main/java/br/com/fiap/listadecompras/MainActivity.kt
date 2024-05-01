package br.com.fiap.listadecompras

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.listadecompras.ui.theme.ListaDeComprasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define o layout da tela
        setContentView(R.layout.activity_main)

        // Recupera os componentes da tela
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView);
        val itemsAdapter = ItemsAdapter()
        recyclerView.adapter = itemsAdapter

        val button = findViewById<Button>(R.id.button)
        val buttonClear = findViewById<Button>(R.id.button_clear)
        val editText = findViewById<EditText>(R.id.editText)

        // Define a cor de fundo do botão
        buttonClear.setBackgroundColor(ContextCompat.getColor(this, R.color.red))

        // Define o comportamento do botão ao ser clicado
        button.setOnClickListener {
            // Cria um novo item com o texto do EditText
            val item = ItemModel(
                name = editText.text.toString()
            )

            // Adiciona o item na lista e limpa o campo EditText
            itemsAdapter.addItem(item)
            editText.setText("")
        }

        // Define o comportamento do botão de limpar ao ser clicado
        buttonClear.setOnClickListener {
            itemsAdapter.clearItems()
        }
    }

}