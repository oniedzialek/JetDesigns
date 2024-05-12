
package com.jetdesigns.presentation.advancedComponents

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.delay

@Composable
fun PagingShowcase() {
    val pager = remember {
        Pager(PagingConfig(pageSize = 20)) {
            ExampleDataSource()
        }
    }
    val lazyPagingItems = pager.flow.collectAsLazyPagingItems()

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        if (lazyPagingItems.loadState.refresh is LoadState.Loading) {
            // Shows a progress indicator during the initial loading of items
            item {
                Box(modifier = Modifier.fillMaxWidth().padding(16.dp), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
        }

        items(lazyPagingItems.itemCount) { index ->
            lazyPagingItems[index]?.let {
                ListItem(text = it)
            }
        }

        if (lazyPagingItems.loadState.append is LoadState.Loading) {
            // Shows a progress indicator at the bottom of the list while more items are being loaded
            item {
                Box(modifier = Modifier.fillMaxWidth().padding(16.dp), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}

@Composable
fun ListItem(text: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation( 4.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(16.dp)
        )
    }
}

class ExampleDataSource : PagingSource<Int, String>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, String> {
        val nextPage = params.key ?: 0
        delay(3000)
        return try {
            val data = List(20) { "Item #${nextPage * 20 + it}" } // Generuje 20 elementów na stronę
            LoadResult.Page(
                data = data,
                prevKey = if (nextPage == 0) null else nextPage - 1,
                nextKey = if (data.isEmpty()) null else nextPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, String>): Int? {
        // Metoda do odświeżania danych
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}