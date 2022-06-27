package hien.t.roomshoppinglist

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/*
represents a table within the Room database. Table name will be shopping_list_table,
id will be autoGenerate id and other variables describes a shopping list data.
*/

@Entity(tableName = "shopping_list_table")
data class ShoppingListItem(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String?,
    var count: Int?,
    var price: Double?
)