package com.tijanidian.add_playground.ut02.exercise02

import androidx.appcompat.app.AppCompatActivity
import com.tijanidian.add_playground.R
import commons.Serializer

class DataSourceFactory<T:LocalModel>(
    private val activity: AppCompatActivity,
    private val serializer: Serializer<T>
) {
    fun create(idActionClicked: Int): LocalStorage<T> {
        return when (idActionClicked) {
            R.id.action_repository_file -> FileLocalStorage(activity, serializer)
            R.id.action_repository_shapref -> SharPrefDataSource(activity, serializer)
            else -> MemLocalStorage()
        }
    }
}