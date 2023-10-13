package Actividades.sqlite_conexion.Data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import Actividades.sqlite_conexion.Data.productosContract.ProductosEntry;

public class inventarioDBHelper  extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Inventario.db";

    public inventarioDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + ProductosEntry.TABLE_NAME + " ("+
                ProductosEntry.ID + " INTEGER PRIMARY KEY," +
                ProductosEntry.NAME+ " TEXT NOT NULL," +
                ProductosEntry.DESCRIPTION+ " INTEGER NOT NULL," +
                ProductosEntry.QUANTITY+ "INTEGER NOT NULL,"+
                ProductosEntry.PRICE + "INTEGER NOT NULL,"+
                ProductosEntry.OUT + "INTEGER NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long saveUser(productos producto) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.insert(
                ProductosEntry.TABLE_NAME,
                null,
                producto.toContentValues());
    }

    public Cursor getAllProductos() {
        return getReadableDatabase()
                .query(
                        ProductosEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    public Cursor getProductoById(String productoId) {
        Cursor c = getReadableDatabase().query(
                ProductosEntry.TABLE_NAME,
                null,
                ProductosEntry.ID + " LIKE ?",
                new String[]{productoId},
                null,
                null,
                null);
        return c;
    }


    public int deleteProducto(String productoId) {
        return getWritableDatabase().delete(
                ProductosEntry.TABLE_NAME,
                ProductosEntry.ID+ " LIKE ?",
                new String[]{productoId});
    }

    public int updateProducto(productos productoModificar, String productoId) {
        return getWritableDatabase().update(
                ProductosEntry.TABLE_NAME,
                productoModificar.toContentValues(),
                ProductosEntry.ID + " LIKE ?",
                new String[]{productoId}
        );
    }
}

