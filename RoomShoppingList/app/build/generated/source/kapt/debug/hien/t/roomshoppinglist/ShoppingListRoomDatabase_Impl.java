package hien.t.roomshoppinglist;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class ShoppingListRoomDatabase_Impl extends ShoppingListRoomDatabase {
  private volatile ShoppingListDao _shoppingListDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `shopping_list_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `count` INTEGER, `price` REAL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"312c34f409d0ffe33854e6b314acbea3\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `shopping_list_table`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsShoppingListTable = new HashMap<String, TableInfo.Column>(4);
        _columnsShoppingListTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsShoppingListTable.put("name", new TableInfo.Column("name", "TEXT", false, 0));
        _columnsShoppingListTable.put("count", new TableInfo.Column("count", "INTEGER", false, 0));
        _columnsShoppingListTable.put("price", new TableInfo.Column("price", "REAL", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysShoppingListTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesShoppingListTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoShoppingListTable = new TableInfo("shopping_list_table", _columnsShoppingListTable, _foreignKeysShoppingListTable, _indicesShoppingListTable);
        final TableInfo _existingShoppingListTable = TableInfo.read(_db, "shopping_list_table");
        if (! _infoShoppingListTable.equals(_existingShoppingListTable)) {
          throw new IllegalStateException("Migration didn't properly handle shopping_list_table(hien.t.roomshoppinglist.ShoppingListItem).\n"
                  + " Expected:\n" + _infoShoppingListTable + "\n"
                  + " Found:\n" + _existingShoppingListTable);
        }
      }
    }, "312c34f409d0ffe33854e6b314acbea3", "43db481b40d066564afa379b2fc6c700");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "shopping_list_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `shopping_list_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public ShoppingListDao shoppingListDao() {
    if (_shoppingListDao != null) {
      return _shoppingListDao;
    } else {
      synchronized(this) {
        if(_shoppingListDao == null) {
          _shoppingListDao = new ShoppingListDao_Impl(this);
        }
        return _shoppingListDao;
      }
    }
  }
}
