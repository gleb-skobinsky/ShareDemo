import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(
    viewModel: MainViewModel
) {
    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar({ Text("Image share demo") })
            }
        ) { paddingValues ->
            val image by viewModel.imageUrl.collectAsState()
            Column(Modifier.padding(paddingValues).padding(20.dp)) {
                image?.let { url ->
                    AsyncImage(
                        model = url,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f)
                    )
                } ?: run {
                    Box(
                        Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .fillMaxWidth()
                            .aspectRatio(1f)
                            .background(Color.LightGray)
                    )
                }
            }
        }
    }
}