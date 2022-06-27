package hien.t.roomshoppinglist;

import java.lang.System;

@android.arch.persistence.room.Database(entities = {hien.t.roomshoppinglist.ShoppingListItem.class}, version = 1)
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lhien/t/roomshoppinglist/ShoppingListRoomDatabase;", "Landroid/arch/persistence/room/RoomDatabase;", "()V", "shoppingListDao", "Lhien/t/roomshoppinglist/ShoppingListDao;", "app_debug"})
public abstract class ShoppingListRoomDatabase extends android.arch.persistence.room.RoomDatabase {
    
    @org.jetbrains.annotations.NotNull()
    public abstract hien.t.roomshoppinglist.ShoppingListDao shoppingListDao();
    
    public ShoppingListRoomDatabase() {
        super();
    }
}