package com.example.bookswapapplication.composables
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.bookswapapplication.viewModel.BookViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookswapapplication.utils.CategoryEnum

@Composable
fun AddBook(modifier: Modifier = Modifier, viewModel: BookViewModel = viewModel(), toHomeScreen: ()-> Unit){
    var ISBN by remember { mutableStateOf("") }
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var author by remember { mutableStateOf("") }
    var condition by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,)
    {
        Text(
            text = "Add your book",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF4D88D1)
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Book title") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        OutlinedTextField(
            value = author,
            onValueChange = { author = it },
            label = { Text("Book author") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        OutlinedTextField(
            value = ISBN,
            onValueChange = { ISBN = it },
            label = { Text("ISBN") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        OutlinedTextField(
            value = condition,
            onValueChange = { condition = it },
            label = { Text("Condition") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        OutlinedTextField(
            value = category,
            onValueChange = { category = it },
            label = { Text("Category") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Button(
            onClick = {
                viewModel.addbook(ISBN.toLong(), title, description ,author, condition, category = CategoryEnum.valueOf(category.uppercase()))
                toHomeScreen()
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            modifier = Modifier.fillMaxWidth()
        )
        {
            Text(text = "Add")
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    BookSwapApplicationTheme {
//        AddBook()
//
//    }
//}



//@Composable
//fun SignUpScreen(
//    bookViewModel: BookViewModel, toHomeScreen: () -> Unit, toSignIn: () -> Unit
//) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally,
//    ) {
//
//        Text(text = "Bank App", style = MaterialTheme.typography.headlineMedium, color =  Color(0xFF9AD14D))
//
//        Spacer(modifier = Modifier.height(16.dp))
//        // double check
//        SignUpForm(BookViewModel(), toSignIn)
//
//        Spacer(modifier = Modifier.height(16.dp))
//        TextButton(onClick = toSignIn) {
//            Text(text = "Already have an account? Sign In")
//        }
//    }
//}
//
//
//@Composable
//fun SignUpForm(bookViewModel: BookViewModel, toSignIn: () -> Unit) {
//    var name by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//    var email by remember { mutableStateOf("") }
//    var phoneNumber by remember { mutableStateOf("") }
//
//    Column {
//        OutlinedTextField(
//            value = name,
//            onValueChange = { name = it },
//            label = { Text("Name") },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp)
//        )
//        OutlinedTextField(
//            value = email,
//            onValueChange = { email = it },
//            label = { Text("Email") },
//            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp)
//        )
//        OutlinedTextField(
//            value = password,
//            onValueChange = { password = it },
//            label = { Text("Password") },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp)
//        )
//        OutlinedTextField(
//            value = phoneNumber,
//            onValueChange = { phoneNumber = it },
//            label = { Text("Phone Number") },
//            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp)
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(
//            onClick = {
//                bookViewModel.signup(email, password, name, phoneNumber)
//                toSignIn()
//            },
//            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
//            modifier = Modifier.fillMaxWidth()) {
//            Text(text = "Sign Up")
//        }
//    }
//}