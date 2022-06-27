package hien.t.roomshoppinglist;

import java.lang.System;

@android.arch.persistence.room.Dao()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\'\u00a8\u0006\f"}, d2 = {"Lhien/t/roomshoppinglist/ShoppingListDao;", "", "delete", "", "itemId", "", "getAll", "", "Lhien/t/roomshoppinglist/ShoppingListItem;", "insert", "", "item", "app_debug"})
public abstract interface ShoppingListDao {
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * from shopping_list_table")
    public abstract java.util.List<hien.t.roomshoppinglist.ShoppingListItem> getAll();
    
    @android.arch.persistence.room.Insert()
    public abstract long insert(@org.jetbrains.annotations.NotNull()
    hien.t.roomshoppinglist.ShoppingListItem item);
    
    @android.arch.persistence.room.Query(value = "DELETE FROM shopping_list_table WHERE id = :itemId")
    public abstract void delete(int itemId);
}