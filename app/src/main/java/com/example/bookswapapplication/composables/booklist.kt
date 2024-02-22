import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookswapapplication.R
import com.example.bookswapapplication.composables.list.LocalBookDataProvider
import com.example.bookswapapplication.data.Book
import com.example.bookswapapplication.ui.theme.BookTheme
import com.example.bookswapapplication.viewModel.BookViewModel

//toSwapBook: ()-> Unit
@Composable
fun BookListScreen(bookViewModel: BookViewModel = viewModel(), navToDetails: (Book) -> Unit){
    Text(text = "Books List", fontSize = 30.sp)
    LazyColumn(modifier = Modifier.fillMaxSize()){
        items(bookViewModel.books?: bookViewModel.getBookData()){
            BookCard(it, navToDetails)
            BookListItem(book = it, onItemClick = navToDetails)
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BookListItem(
    book: Book,
    onItemClick: (Book) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(),
        modifier = modifier,
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        onClick = { onItemClick(book) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(dimensionResource(R.dimen.card_image_height))
        ) {

            Column(
                modifier = Modifier
                    .padding(
                        vertical = dimensionResource(R.dimen.padding_small),
                        horizontal = dimensionResource(R.dimen.padding_medium)
                    )
                    .weight(1f)
            ) {
                Text(
                    text = book.title,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = dimensionResource(R.dimen.card_text_vertical_space))
                )
                Text(
                    text = book.author,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 3
                )

            }
        }
    }
}

@Composable
fun BookCard(book: Book, navToDetails: (Book) ->Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White),
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .height(150.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {
        Text(text = book.title)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = book.author)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = book.ISBN.toString())
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    navToDetails(book)
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                modifier = Modifier.fillMaxWidth()
            ){
                Text(text = "Swap Request")
            }
        }
    }

}




@Preview
@Composable
fun BookListPreview(){
    BookTheme {

    }
}
