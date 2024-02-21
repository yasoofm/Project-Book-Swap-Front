package com.example.bookswapapplication.ui.theme.list

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class BookViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        BookUiState(
            BookList = LocalBookDataProvider.getBookData(),
            currentBook = LocalBookDataProvider.getBookData().getOrElse(0) {
                LocalBookDataProvider.defaultBook
            }
        )
    )
    val uiState: StateFlow<BookUiState> = _uiState

    fun updateCurrentBook(selectedBook: Book) {
        _uiState.update {
            it.copy(currentBook = selectedBook)
        }
    }fun navigateToListPage() {
        _uiState.update {
            it.copy(isShowingListPage = true)
        }
    }
    fun navigateToDetailPage() {
        _uiState.update {
            it.copy(isShowingListPage = false)
        }
    }
}
data class BookUiState(
    val BookList: List<Book> = emptyList(),
    val currentBook: Book = LocalBookDataProvider.defaultBook,
    val isShowingListPage: Boolean = true
)