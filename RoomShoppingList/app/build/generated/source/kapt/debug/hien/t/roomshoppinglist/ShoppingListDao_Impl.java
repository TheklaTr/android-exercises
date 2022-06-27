package hien.t.roomshoppinglist;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class ShoppingListDao_Impl implements ShoppingListDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfShoppingListItem;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  public ShoppingListDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfShoppingListItem = new EntityInsertionAdapter<ShoppingListItem>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `shopping_list_table`(`id`,`name`,`count`,`price`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ShoppingListItem value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getCount() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getCount());
        }
        if (value.getPrice() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getPrice());
        }
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM shopping_list_table WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public long insert(ShoppingListItem item) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfShoppingListItem.insertAndReturnId(item);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(int itemId) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      _stmt.bindLong(_argIndex, itemId);
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDelete.release(_stmt);
    }
  }

  @Override
  public List<ShoppingListItem> getAll() {
    final String _sql = "SELECT * from shopping_list_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfCount = _cursor.getColumnIndexOrThrow("count");
      final int _cursorIndexOfPrice = _cursor.getColumnIndexOrThrow("price");
      final List<ShoppingListItem> _result = new ArrayList<ShoppingListItem>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ShoppingListItem _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final Integer _tmpCount;
        if (_cursor.isNull(_cursorIndexOfCount)) {
          _tmpCount = null;
        } else {
          _tmpCount = _cursor.getInt(_cursorIndexOfCount);
        }
        final Double _tmpPrice;
        if (_cursor.isNull(_cursorIndexOfPrice)) {
          _tmpPrice = null;
        } else {
          _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
        }
        _item = new ShoppingListItem(_tmpId,_tmpName,_tmpCount,_tmpPrice);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
